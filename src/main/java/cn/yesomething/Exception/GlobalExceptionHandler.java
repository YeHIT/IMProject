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
            objectNode = JsonObjectValueGetter.getJsonObjectNode(501,"无此用户");
        }
        else if(ex instanceof PasswordErrorException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(502,"用户名或密码错误");
        }
        else if(ex instanceof PictureDecodeException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(501,"图片编码错误,请换个图片");
        }
        else if(ex instanceof InfoNoChangeException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(501,"当前资料已为最新版本");
        }
        else if(ex instanceof UnknownException){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(500,"未知错误请稍后再试");
        }
        return objectNode.toString();
    }
}