package cn.yesomething.utils;

import cn.yesomething.Exception.UnknownException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class EmotionAnalyzer {
    //todo 使用绝对路径 python脚本路径PYTHON_PATH
    private static final String PYTHON_PATH = "C:/Users/SmallYe/Desktop/github/SoftwareProject/IMProject" +
            "/src/main/resources/pythonScript/EmotionAnalyzer.py";

    /**
     * 传入信息判断该信息的情绪指数
     * @param messageContent 需要传入的信息
     * @return 当前信息的情绪指数 -表示负面情绪
     */
    public static double Analyze(String messageContent) {
        Double result = 0.0;
        try {
            String[] args = new String[] { "python", PYTHON_PATH, messageContent };
            Process proc = Runtime.getRuntime().exec(args);// 执行py文件
            proc.waitFor();
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            line = in.readLine();
            if(line != null){
                result = Double.parseDouble(line);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(result == 0.0){
            throw new UnknownException("情绪分析异常");
        }
        else {
            return result;
        }
    }
}
