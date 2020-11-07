```tips
该项目的接口均以发送json请求包的方式调用,具体接口及调用方式如下
```

### 用户相关

#### 获取userSig

```java
后台地址+/im_general_service/generate_user_sig
请求URL示例:http://127.0.1:8080/IMProject/im_general_service/generate_user_sig
请求包示例:
{
    "userName":"ye"
}
应答包示例:
{
    "responseCode":200,
    "userSig":"xxxxxxx"
}
{
    "responseCode":600,
    "errorMessage":"未知错误请稍后再试"
}
```

#### 用户注册

```java
后台地址+/im_user_service/user_register
请求URL示例:http://127.0.1:8080/IMProject/im_user_service/user_register
请求包示例:
{
    "userName":"ye",
    "userPassword":"xxxxxx"
}
应答包示例:
{
    "responseCode":200
}
{
    "responseCode":500,
    "errorMessage":"服务器异常"
}
{
    "responseCode":501,
    "errorMessage":"用户已存在"
}
{
    "responseCode":502,
    "errorMessage":"用户名密码不能为空"
}
```

#### 用户登陆

```java
后台地址+/im_user_service/user_login
请求URL示例:http://127.0.1:8080/IMProject/im_user_service/user_login
请求包示例:
{
    "userName":"ye",
    "userPassword":"xxxxxx"
}
应答包示例:
{
    "responseCode":200
}
{
    "responseCode":500,
    "errorMessage":"服务器异常"
}
{
    "responseCode":503,
    "errorMessage":"无此用户"
}
{
    "responseCode":504,
    "errorMessage":"用户名或密码错误"
}
```

#### 用户信息更新

```java
后台地址+/im_user_service/user_update
请求URL示例:http://127.0.1:8080/IMProject/im_user_service/user_update
请求包示例:
{
    "userName":"ye",
    "userPassword":"xxxxxx",
    "userSex":0/1, 				//表示男女
    "userNickname":"smallYe", 	//昵称
    "userBirthday":"2020-10-01",//Date类型
    "userEmail":"xxxx",			//用户邮箱地址
    "userPhoneNumber":"xxxx"    //用户手机号
}
应答包示例:
{
    "responseCode":200,
    "user":{		//更新后的数据
        "userName":"ye",
        "userPassword":"xxxxxx",
        "userSex":0/1, 				//表示男女
        "userNickname":"smallYe", 	//昵称
        "userBirthday":"2020-10-01",//Date类型
    	"userEmail":"xxxx",			//用户邮箱地址
    	"userPhoneNumber":"xxxx"    //用户手机号
    }
}
{
    "responseCode":500,
    "errorMessage":"服务器异常"
}
{
    "responseCode":503,
    "errorMessage":"无此用户"
}
{
    "responseCode":505,
    "errorMessage":"当前资料已为最新版本"
}
```

#### 用户资料查询

```java
后台地址+/im_user_service/user_select
请求URL示例:http://127.0.1:8080/IMProject/im_user_service/user_select
请求包示例:
{
    "userName":"ye"
}
应答包示例:
{
    "responseCode":200,
    "user":{		
        "userName":"ye",
        "userPassword":"xxxxxx",
        "userSex":0/1, 							//表示男女
        "userNickname":"smallYe", 				//昵称
        "userBirthday":"2020-10-01 xxxxxx",		//Date类型
        "userPicture":"xxxx", 			   		//用户头像地址
        "userHistoricalPictures":["xxx","ccc"] 	//用户历史头像地址
    	"userEmail":"xxxx",						//用户邮箱地址
    	"userPhoneNumber":"xxxx",   			//用户手机号
        "userTags":["xxx","xxx"],   			//用户标签
        "bubbleType":"xxx", 					//用户气泡
        "historicalBubbleTypes":["xxx","xxx"] 	//历史气泡
    }
}
{
    "responseCode":500,
    "errorMessage":"服务器异常"
}
{
    "responseCode":503,
    "errorMessage":"无此用户"
}
```

#### 用户头像上传

```java
后台地址+/im_user_service/user_picture_upload
请求URL示例:http://127.0.1:8080/IMProject/im_user_service/user_picture_upload
请求包示例:
{
    "userName":"ye",
    "base64String":"xxxxxxx" //用户头像(将图片使用base64编码再转为String)
}
应答包示例:
{
    "responseCode":200,
    "userPicture":"http://xxxxxxxxxxx" //头像位于的网络地址
}
{
    "responseCode":500,
    "errorMessage":"服务器异常"
}
{
    "responseCode":503,
    "errorMessage":"无此用户"
}
{
    "responseCode":506,
    "errorMessage":"图片编码错误,请换个图片"
}
{
    "responseCode":600,
    "errorMessage":"未知错误请稍后再试"
}
```

#### 用户词云生成

```java
后台地址+/im_user_service/user_word_cloud_generate
请求URL示例:http://127.0.1:8080/IMProject/im_user_service/user_word_cloud_generate
请求包示例:
{
    "userName":"ye"
}
应答包示例:
{
    "responseCode":200,
    "wordCloudPicture":"http://xxxxxxxxxxx", //词云位于的网络地址
    "tags":["xxx","xxx"]					 //用户关键词
}
{
    "responseCode":500,
    "errorMessage":"服务器异常"
}
{
    "responseCode":512,
    "errorMessage":"消息不足,无法生成词云"
}
{
    "responseCode":600,
    "errorMessage":"未知错误请稍后再试"
}
```



### 消息相关

#### 消息插入

```java
后台地址+/im_message_service/message_insert
请求URL示例:http://127.0.1:8080/IMProject/im_message_service/message_insert
请求包示例:
{
    "fromId":"ye",
    "toId":"robot",
    "messageTime":"2020-10-01 xxxxxxx", // Date类型
    "messageContent":"hello"
    "messageContentType":1	//可选 默认为1 表示文本消息
}
应答包示例:
{
    "responseCode":200,
    "message":{
        "messageId":1,
        "fromId":"ye",
        "toId":"robot",
        "messageTime":1603173307000,
        "messageContent":"hello",	   // 图片消息的内容为图片的网络地址
        "messageContentType":1,		   //消息类型 1为文本 2为图片
        "messageEmotionalScore":0.5,   //消息情绪得分
        "hasViolentInfo": 0,		   //是否含黄暴信息
        "processedContent": "xxxxx"    //处理后的信息内容
    }    
}
{
    "responseCode":500,
    "errorMessage":"服务器异常"
}
{
    "responseCode":506,
    "errorMessage":"图片编码错误,请换个图片"
}
{
    "responseCode":600,
    "errorMessage":"未知错误请稍后再试"
}
```

#### 消息查询

```java
后台地址+/im_message_service/message_select
请求URL示例:http://127.0.1:8080/IMProject/im_message_service/message_select
请求包示例:
{
    "fromId":"ye",
    "toId":"robot",
    //以下参数均不传则回查询两人间的所有消息
    "messageStartTime":"2020-10-01 xxxxxxx", // 可选 Date类型 表示要查询的开始时间 需要先获取时间戳然后使用format转化才不会导致格式错误
    "messageEndTime":"2020-10-02 xxxxxx"	 // 可选 Date类型 表示要查询的终止时间
}
应答包示例:
{
    "responseCode":200,
    "messages":[
        {
           "messageId":1,
            "fromId":"ye",
            "toId":"robot",
            "messageTime":1603173307000,
            "messageContent":"hello",      // 图片消息的内容为图片的网络地址
            "messageContentType":1,		   //消息类型 1为文本 2为图片
            "messageEmotionalScore":0.5,   //消息情绪得分
       		"hasViolentInfo": 0,		   //是否含黄暴信息
        	"processedContent": "xxxxx"    //处理后的信息内容
                
        },	         
        {
           "messageId":2,
            "fromId":"ye",
            "toId":"robot",
            "messageTime":1603173307000,
            "messageContent":"hello2",      // 图片消息的内容为图片的网络地址
            "messageContentType":1,		   //消息类型 1为文本 2为图片
            "messageEmotionalScore":0.5,   //消息情绪得分
       		"hasViolentInfo": 0,		   //是否含黄暴信息
        	"processedContent": "xxxxx"    //处理后的信息内容
                
        }
    ]
}
{
    "responseCode":500,
    "errorMessage":"服务器异常"
}
{
    "responseCode":507,
    "errorMessage":"当前时间段无历史消息,请换一个时间段"
}
{
    "responseCode":508,
    "errorMessage":"请检查输入的日期是否正确"
}
```

### 好友相关

#### 添加好友

```java
后台地址+/im_friends_service/friends_add
请求URL示例:http://127.0.1:8080/IMProject/im_friends_service/friends_add
请求包示例:
{
    "friendId":"ye",  //好友名
    "userId":"robot", //当前用户名
    "friendName":"smallYe", // 给好友的昵称
    "friendType":"好友"	 // 可选 String类型 表示好友类型 默认为好友
    "friendGroupType":"我的好友" //可选 String类型 表示好友所在的组名 默认为我的好友
}
应答包示例:
{
    "responseCode":200
}
{
    "responseCode":500,
    "errorMessage":"服务器异常"
}
{
    "responseCode":509,
    "errorMessage":"已为好友,请勿重复添加"
}
```

#### 更新好友

```java
后台地址+/im_friends_service/friends_update
请求URL示例:http://127.0.1:8080/IMProject/im_friends_service/friends_update
请求包示例:
{
    "friendId":"ye",  //好友名
    "userId":"robot", //当前用户名
    "friendName":"smallYe", // 给好友的昵称
    "friendType":"好友"	 // 可选 String类型 表示好友类型 默认为好友
    "friendGroupType":"我的好友" //可选 String类型 表示好友所在的组名 默认为我的好友
}
应答包示例:
{
    "responseCode":200,
    "friends":{
        "friendId":"ye",  //好友名
        "userId":"robot", //当前用户名
        "friendName":"smallYe", // 给好友的昵称
        "friendType":"好友"	 // 可选 String类型 表示好友类型 默认为好友
        "friendGroupType":"我的好友" //可选 String类型 表示好友所在的组名 默认为我的好友
    }
}
{
    "responseCode":500,
    "errorMessage":"服务器异常"
}
{
    "responseCode":505,
    "errorMessage":"当前资料已为最新版本"
}
{
    "responseCode":510,
    "errorMessage":"并非好友关系"
}
```

#### 查找两个用户的具体好友关系

```java
后台地址+/im_friends_service/friends_select
请求URL示例:http://127.0.1:8080/IMProject/im_friends_service/friends_select
请求包示例:
{
    "friendId":"ye",  //好友名
    "userId":"robot"  //当前用户名
}
应答包示例:
{
    "responseCode":200,
    "friends":{
        "friendId":"ye",  //好友名
        "userId":"robot", //当前用户名
        "friendName":"smallYe", // 给好友的昵称
        "friendType":"好友"	 // 可选 String类型 表示好友类型 默认为好友
        "friendGroupType":"我的好友" //可选 String类型 表示好友所在的组名 默认为我的好友
    }
}
{
    "responseCode":500,
    "errorMessage":"服务器异常"
}
{
    "responseCode":510,
    "errorMessage":"并非好友关系"
}
```

#### 查找用户的好友列表

```java
后台地址+/im_friends_service/friends_list_select
请求URL示例:http://127.0.1:8080/IMProject/im_friends_service/friends_list_select
请求包示例:
{
    "userId":"robot"  //当前用户名
}
应答包示例:
{
    "responseCode":200,
    "friendsList":[
    	{
        "friendId":"ye",  //好友名
        "userId":"robot", //当前用户名
        "friendName":"smallYe", // 给好友的昵称
        "friendType":"好友"	 // 可选 String类型 表示好友类型 默认为好友
        "friendGroupType":"我的好友" //可选 String类型 表示好友所在的组名 默认为我的好友
    	}
    ]
}
{
    "responseCode":511,
    "errorMessage":"未和任何人有好友关系"
}
```



