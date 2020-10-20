import cn.yesomething.dao.UserDao;
import cn.yesomething.domain.User;
import cn.yesomething.utils.JsonObjectValueGetter;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TestJson {
    @Resource
    UserDao userDao;

    @Test
    public void createJson() throws Exception{
        JsonMapper jsonMapper = new JsonMapper();
        ObjectNode objectNode = jsonMapper.createObjectNode();
        objectNode.put("usersig","zzzzzzz");
        objectNode.put("responseCode","200");
        System.out.println(objectNode);
    }

    @Test
    public void testUserJson(){
        String userName = "xyz";
        User resultUser = userDao.selectByUserName(userName);
        ObjectNode objectNode = null;
        if(resultUser == null){
            objectNode = JsonObjectValueGetter.getJsonObjectNode(500);
        }
        else {
            objectNode = JsonObjectValueGetter.getJsonObjectNode(200);
            objectNode.putPOJO("user",resultUser);
        }
        System.out.println(objectNode.toString());
    }
}
