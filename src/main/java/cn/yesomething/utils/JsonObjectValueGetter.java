package cn.yesomething.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonObjectValueGetter {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 传入json字符串获取对应的json对象
     * @param JsonStr 传入的json字符串
     * @return 对应的json对象
     */
    private static JsonNode changeStringToJsonObj(String JsonStr){
        try {
            return objectMapper.readTree(JsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 创建ObjectNode并添加状态码与错误信息
     * @param responseCode 当前操作的状态码 200为成功
     * @param errorMessage 错误信息
     * @return ObjectNode
     */
    public static ObjectNode getJsonObjectNode(int responseCode,String errorMessage){
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("responseCode",responseCode);
        if(errorMessage != null){
            objectNode.put("errorMessage",errorMessage);
        }
        return objectNode;
    }

    /**
     * 创建ObjectNode并添加状态码
     * @param responseCode 当前操作的状态码 200为成功
     * @return ObjectNode
     */
    public static ObjectNode getJsonObjectNode(int responseCode){
        return getJsonObjectNode(responseCode,null);
    }

    /**
     * 创建ArrayNode
     * @return ArrayNode
     */
    public static ArrayNode getJsonArrayNode(){
        return objectMapper.createArrayNode();
    }

    /**
     * 传入json字符串获取对应的json对象以及想要获取的属性名获取所需属性
     * @param JsonStr 传入的json字符串
     * @param valueName 属性名
     * @return 所需属性值
     */
    public static String getJsonValue(String JsonStr,String valueName){
        if(changeStringToJsonObj(JsonStr) != null){
            return changeStringToJsonObj(JsonStr).path(valueName).asText();
        }
        return null;
    }
}
