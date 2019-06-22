package com.mosaiker.authservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.authservice.service.AuthenticationService;
import com.mosaiker.authservice.service.TokenService;
import com.mosaiker.authservice.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/token")
public class TokenController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private TokenService tokenService;

    // 请求体中包含 username 和 password, 如果认证成功，生成并返回 token。
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public JSONObject getToken(@RequestBody JSONObject request) {
        // 认证
        JSONObject authenticationResult = authenticationService.authenticate(request);
        if (authenticationResult.getString("message").equals("authentication fail"))
            return TokenUtil.constructJsonOfFail();
        // 认证成功，生成token
        String token = tokenService.createToken(
                request.getString("phone"), authenticationResult.getString("role"));

        return TokenUtil.constructJsonOfSuccess(token);
    }

    // 请求体中包含 token 和要求的身份，如果 token 符合该身份要求，返回 true。
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public boolean verifyToken(@RequestBody JSONObject request) {
        return tokenService.verifyToken(request.getString("token"), request.getString("role"));
    }

}
