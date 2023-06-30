package site.xmy.projects.cs.im.service.impl;

import org.springframework.stereotype.Service;
import site.xmy.projects.cs.im.dto.IMLoginRequest;
import site.xmy.projects.cs.im.service.LoginService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MockLoginServiceImpl implements LoginService {
    private static Map<String, IMLoginRequest> loginRequestMap = new ConcurrentHashMap<>();

    @Override
    public void login(IMLoginRequest request) {
//        if (isLogin(request.getUserid())){
//            System.out.println("already login！");
//        }else {
        loginRequestMap.putIfAbsent(request.getUserid(), request);
//        }
    }

    @Override
    public void logout(String userId) {
        loginRequestMap.remove(userId);
    }

    @Override
    public Boolean isLogin(String userId) {
        return getLoginInfo(userId) != null;
    }

    @Override
    public IMLoginRequest getLoginInfo(String userId) {
        return loginRequestMap.get(userId);
    }

    @Override
    public Map<String, IMLoginRequest> getAllLoginUser() {
        return loginRequestMap;
    }
}
