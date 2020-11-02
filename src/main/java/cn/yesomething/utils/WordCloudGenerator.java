package cn.yesomething.utils;
import cn.yesomething.Exception.UnknownException;
import cn.yesomething.domain.TagsKeeper;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WordCloudGenerator {
    //Python脚本的路径
    private static final String PYTHON_PATH = "src/main/resources/pythonScript/word_cloud.py";
    //字体文件的路径
    private static final String FONT_PATH = "src/main/resources/pythonScript/SourceHanSerifK-Light.otf";
    //文件日期格式
    private static final String FILE_TIME_FORMAT = "yyyy-MM-dd_HH-mm-ss";
    //文件格式
    private static final String FILE_FORMAT = "png";
    //图片输出路径
    //todo 放到服务器上时需要修改
    public static final String IMG_PATH = "C:/Users/SmallYe/Desktop/SoftwareProject/IMProjectWordCloudPictures/";
    //词云在服务器的地址
    private static final String WORD_CLOUD_PICTURE_URL = "http://10.0.2.2:8080/IMProjectWordCloudPictures/";

    /**
     * 根据聊天记录生成词云图片
     * @param context 聊天记录
     * @param userName 用户名
     * @return 词云图片在服务器的链接
     */
    public static TagsKeeper generateWordCloud(ArrayList<String> context,String userName){
        //确定图片名字
        DateFormat sdf = new SimpleDateFormat(FILE_TIME_FORMAT);
        String fileTime = sdf.format(new Date());
        String pictureName = fileTime + "." + FILE_FORMAT;
        //图片路径
        String imgPath = IMG_PATH + userName + "/" + pictureName;
        //无文件夹时先新建文件夹
        String folderPath = IMG_PATH + userName;
        File folder = new File(folderPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        //拼接聊天记录
        String text = null;
        for(int i=0;i<context.size();i++){
            text = text + context.get(i);
        }
        ArrayList<String> tagsList = new ArrayList();
        // 执行py文件
        try{
            String[] args = new String[] { "python", PYTHON_PATH, text ,imgPath,FONT_PATH};
            Process proc = Runtime.getRuntime().exec(args);
            //读取关键词
            //todo 临时使用的编码
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream(),"GBK"));
            String tag = bufferedReader.readLine();
            while(tag != null){
                tagsList.add(tag);
                tag = bufferedReader.readLine();
            }
            proc.waitFor();
        }catch (Exception e){
            throw new UnknownException("调用python脚本出现错误");
        }
        //查看是否创建成功
        File image = new File(imgPath);
        if(!image.exists()){
            throw new UnknownException("文件创建出现错误");
        }
        else {
            //返回对应的服务器地址
            String wordCloudPictureUrl = WORD_CLOUD_PICTURE_URL + userName + "/" + pictureName;
            String[] pictureArray = tagsList.toArray(new String[]{});
            return new TagsKeeper(pictureArray,wordCloudPictureUrl);
        }
    }
}
