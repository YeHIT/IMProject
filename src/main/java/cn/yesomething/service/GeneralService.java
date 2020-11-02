package cn.yesomething.service;

//用于向前端提供通用服务
public interface GeneralService {
    /**
     * @param userId 需要产生usersig的ID
     * @return 返回产生的usersig
     */
    String generateUserSig(String userId);
}
