package site.xmy.projects.cs.im.service;

import site.xmy.projects.cs.im.dto.IMLoginRequest;

import java.util.Map;

public interface LoginService {
    // 登录
    void login(IMLoginRequest request);
    // 登出
    void logout(String userId);
    // 判断是否登录
    Boolean isLogin(String userId);
    // 获取用户登录请求信息
    IMLoginRequest getLoginInfo(String userId);
    // 获取所有登录用户
    Map<String, IMLoginRequest> getAllLoginUser();
}
