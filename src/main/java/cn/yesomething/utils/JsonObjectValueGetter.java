package cn.yesomething.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonObjectValueGetter {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 传入json字符串获取对应的json对象
     * @param JsonStr 传入的json字符串
     * @return 对应的json对象
     */
    public static JsonNode changeStringToJsonObj(String JsonStr){
        try {
            return objectMapper.readTree(JsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 传入json字符串获取对应的json对象以及想要获取的属性名获取所需属性
     * @param JsonStr 传入的json字符串
     * @param valueName 属性名
     * @return 所需属性值
     */
    public static String getJsonValue(String JsonStr,String valueName){
        return changeStringToJsonObj(JsonStr).path(valueName).toString();
    }

}
