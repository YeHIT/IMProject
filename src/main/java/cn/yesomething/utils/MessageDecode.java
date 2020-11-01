package cn.yesomething.utils;

import org.apache.commons.lang3.StringEscapeUtils;

public class MessageDecode {
    public static String decodeMessage(String messageContent){
        String umContent = StringEscapeUtils.unescapeJava(messageContent);
        umContent = StringEscapeUtils.unescapeJava(umContent);
        return umContent;
    }
}
