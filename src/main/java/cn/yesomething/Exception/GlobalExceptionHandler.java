package cn.yesomething.Exception;

import cn.yesomething.utils.JsonObjectValueGetter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@ControllerAdvice("cn.yesomething.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String exceptionHandler(Throwable ex){
        ObjectNode objectNode = null;
        if(ex instanceof DataAccessException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(500,"服务器异常");
        }
        else if(ex instanceof UserExistException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(501,"用户已存在");
        }
        else if(ex instanceof UserNameIsNullException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(502,"用户名密码不能为空");
        }
        else if(ex instanceof NoSuchUserException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(503,"无此用户");
        }
        else if(ex instanceof PasswordErrorException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(504,"用户名或密码错误");
        }
        else if(ex instanceof InfoNoChangeException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(505,"当前资料已为最新版本");
        }
        else if(ex instanceof PictureDecodeException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(506,"图片编码错误,请换个图片");
        }
        else if(ex instanceof NoMessageException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(507,"当前时间段无历史消息,请换一个时间段");
        }
        else if(ex instanceof DateParseException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(508,"请检查输入的日期是否正确");
        }
        else if(ex instanceof FriendRepeatException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(509,"已为好友,请勿重复添加");
        }
        else if(ex instanceof NoFriendRelationException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(510,"并非好友关系");
        }
        else if(ex instanceof NoFriendListException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(511,"未和任何人有好友关系");
        }
        else if(ex instanceof NoEnoughMessageException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(512,"消息不足,无法生成词云");
        }
        else if(ex instanceof UnknownException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(600,"未知错误请稍后再试");
        }
        else{
            ex.printStackTrace();
            objectNode = JsonObjectValueGetter.getJsonObjectNode(600,"未知错误请稍后再试");
        }
        return objectNode.toString();
    }
}
