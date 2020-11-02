package cn.yesomething.utils;

import org.apache.commons.lang3.StringEscapeUtils;

public class MessageHandler {
    /**
     * 解密消息
     * @param messageContent 需要解密的消息
     * @return 解密后的消息
     */
    public static String decodeMessage(String messageContent){
        String umContent = StringEscapeUtils.unescapeJava(messageContent);
        umContent = StringEscapeUtils.unescapeJava(umContent);
        return umContent;
    }

    /**
     * 加密消息
     * @param messageContent 需要加密的消息
     * @return 加密后的消息
     */
    public static String encodeMessage(String messageContent){
        String mContent = StringEscapeUtils.escapeJava(messageContent);
        return mContent;
    }
}
