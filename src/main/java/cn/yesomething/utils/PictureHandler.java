package cn.yesomething.utils;

import cn.yesomething.Exception.PictureDecodeException;
import com.sun.org.apache.xml.internal.security.Init;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PictureHandler {
    //图片类型
    public static final int USER_PICTURE = 0;
    public static final int MESSAGE_PICTURE = 1;
    //文件日期格式
    private static final String FILE_TIME_FORMAT = "yyyy-MM-dd_HH-mm-ss";
    //文件格式
    private static final String FILE_FORMAT = "png";
    //文件路径
    private static final String USER_PICTURES_PATH = "C:/Users/SmallYe/Desktop/SoftwareProject/IMProjectUserPictures/";
    private static final String MESSAGE_PICTURES_PATH = "C:/Users/SmallYe/Desktop/SoftwareProject/IMProjectMessagePictures/";
    //图片文件夹位置
    private static final String USER_PICTURE_URL = "http://10.0.2.2:8080/IMProjectUserPictures/";
    private static final String MESSAGE_PICTURE_URL = "http://10.0.2.2:8080/IMProjectMessagePictures/";

    /**
     * 将前端拿到的图片放入服务器的文件中
     * @param userName 用户名
     * @param base64pictureContent 图片内容
     * @return 图片在服务器的链接
     */
    public static String upLoadPictureToFileFolder(String userName,String base64pictureContent){
        return upLoadPictureToFileFolder(userName,base64pictureContent,USER_PICTURE);
    }

    /**
     * 将前端拿到的图片放入服务器的文件中
     * @param userName 用户名
     * @param base64pictureContent 图片内容
     * @param pictureType 图片类型(用户头像/消息图片)
     * @return 图片在服务器的链接
     */
    public static String upLoadPictureToFileFolder(String userName,String base64pictureContent,int pictureType){
        try {
            Init.init();
            byte[] pictureBytes = Base64.decode(base64pictureContent);
            ByteArrayInputStream pictureByteArrayInputStream = new ByteArrayInputStream(pictureBytes);
            BufferedImage pictureBufferedImage = ImageIO.read(pictureByteArrayInputStream);
            //确定图片名字
            DateFormat sdf = new SimpleDateFormat(FILE_TIME_FORMAT);
            String fileTime = sdf.format(new Date());
            final String pictureName = fileTime + "." + FILE_FORMAT;
            //创建文件
            File pictureFile = null;
            //根据类型选取路径
            if(pictureType == USER_PICTURE){
                pictureFile = new File(USER_PICTURES_PATH + userName + "/" + pictureName);
            }
            else if(pictureType == MESSAGE_PICTURE){
                pictureFile = new File(MESSAGE_PICTURES_PATH + userName + "/" + pictureName);
            }
            boolean canFinish = false;
            //文件不存在时创建文件
            if (!pictureFile.exists()) {
                pictureFile.mkdirs();
            }
            //判断是否成功存储
            canFinish = ImageIO.write(pictureBufferedImage, FILE_FORMAT, pictureFile);
            if (canFinish) {
                String specialPictureUrl = null;
                if(pictureType == USER_PICTURE){
                    specialPictureUrl = USER_PICTURE_URL + userName + "/" + pictureName;
                }
                else if(pictureType == MESSAGE_PICTURE){
                    specialPictureUrl = MESSAGE_PICTURE_URL + userName + "/" + pictureName;
                }
                return specialPictureUrl;
            }
        } catch (Base64DecodingException | IOException e) {
            throw new PictureDecodeException("图片编码错误");
        }
        return null;
    }
}
