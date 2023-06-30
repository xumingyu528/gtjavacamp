package site.xmy.projects.cs.im.controller;


import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.xmy.projects.cs.im.dto.IMLoginRequest;
import site.xmy.projects.cs.im.dto.IMLoginResponse;
import site.xmy.projects.cs.im.service.LoginService;

@RestController
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    public IMLoginResponse login(@RequestBody IMLoginRequest request){
        IMLoginResponse response = new IMLoginResponse();
        if (loginService.isLogin(request.getUserid())){
            response.setMsg("repeat login!");
            response.setCode("4001");
            return response;
        }
        loginService.login(request);
        logger.info("{} login success!", JSON.toJSONString(request));
        response.setMsg("login success!");
        response.setCode("0000");
        return response;

    }

    @PostMapping(value = "/logout/{userId}")
    public void logout(@PathVariable("userId") String userId){
        loginService.logout(userId);
        logger.info("logout success!");
    }

}
