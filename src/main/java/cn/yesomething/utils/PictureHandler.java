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
    //文件日期格式
    private static String fileTimeFormat = "yyyy-MM-dd_HH-mm-ss";
    //文件格式
    private static String fileFormat = "png";
    //文件路径
    public static final String filePathName = "C:/Users/SmallYe/Desktop/SoftwareProject/pictures/";
    //图片文件夹位置
    public static final String picturesUrl = "http://10.0.2.2:8080/IMProjectPictures/";

    /**
     * 将前端拿到的图片放入服务器的文件中
     * @param userName 用户名
     * @param base64pictureContent 图片内容
     * @return 图片在服务器的链接
     */
    public static String upLoadPictureToFileFolder(String userName,String base64pictureContent){
        try {
            Init.init();
            byte[] pictureBytes = Base64.decode(base64pictureContent);
            ByteArrayInputStream bais = new ByteArrayInputStream(pictureBytes);
            BufferedImage bis = ImageIO.read(bais);
            DateFormat sdf = new SimpleDateFormat(fileTimeFormat);
            String fileTime = sdf.format(new Date());
            final String pictureName = fileTime + "_" + "." + fileFormat;
            File f = new File(filePathName
                    + userName + "/" + pictureName);
            boolean canFinish = false;
            //文件不存在时创建文件
            if (!f.exists()) {
                f.mkdirs();
            }
            canFinish = ImageIO.write(bis, fileFormat, f);
            //成功存储
            if (canFinish) {
                String specialPictureUrl = picturesUrl + userName + "/" + pictureName;
                return specialPictureUrl;
            }
        } catch (Base64DecodingException | IOException e) {
            throw new PictureDecodeException("图片编码错误");
        }
        return null;
    }
}
