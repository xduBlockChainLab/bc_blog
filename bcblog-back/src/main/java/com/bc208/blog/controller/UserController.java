package com.bc208.blog.controller;

import com.bc208.blog.common.dto.LoginDto;
import com.bc208.blog.utils.ParamsException;
import com.bc208.blog.utils.ResultInfo;
import com.bc208.blog.pojo.UserModel;
import com.bc208.blog.service.impl.UsersServiceImpl;
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

@RestController
@RequestMapping("/bc208/api")
public class UserController {
    @Autowired
    private UsersServiceImpl usersServiceImpl;

    @PostMapping("/login")
    @ResponseBody
    public ResultInfo userLogin(@RequestBody LoginDto user) throws NoSuchAlgorithmException {
        ResultInfo resultInfo = new ResultInfo();
        System.out.println(user.getEmail() +" "+ user.getPassword());
        String email = user.getEmail();
        String password = user.getPassword();


        MessageDigest messageDigest =MessageDigest.getInstance("SHA-256");
        byte[] digest = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        String private_password = Hex.encodeHexString(digest);

       try{
            UserModel userModel= usersServiceImpl.userLogin(email,private_password);
            resultInfo.setResult(userModel);
        }catch (ParamsException p){
           resultInfo.setCode(p.getCode());
           resultInfo.setMsg(p.getMsg());
           p.printStackTrace();
       }catch (Exception e){
           resultInfo.setCode(500);
           resultInfo.setMsg("登录失败");
        }

            return resultInfo;
    }
    @PostMapping("/register")
    @ResponseBody

    public ResultInfo userRegister(@RequestBody LoginDto user) throws NoSuchAlgorithmException {
        ResultInfo resultInfo = new ResultInfo();
        String email = user.getEmail();
        String password = user.getPassword();

        MessageDigest messageDigest =MessageDigest.getInstance("SHA-256");
        byte[] digest = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        String private_password = Hex.encodeHexString(digest);
        try{
            UserModel userModel = usersServiceImpl.userRegister(email,private_password);
            resultInfo.setResult(userModel);
        }catch (ParamsException p){
            resultInfo.setCode(p.getCode());
            resultInfo.setMsg(p.getMsg());
            p.printStackTrace();
        }catch (Exception e){
            resultInfo.setCode(500);
            resultInfo.setMsg("注册失败");
        }
        return resultInfo;
    }


    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }
}
