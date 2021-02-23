package com.lihao.springjpa.controller;

import com.lihao.springjpa.entity.Resp;
import com.lihao.springjpa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/*")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("all")
    public Resp list(){
        try {
            return Resp.isOk().data(userService.list());
        } catch (Exception exception) {
            return Resp.isFail(exception);
        }
    }

    @GetMapping("all/{username}")
    public Resp listByName(@PathVariable("username") String username){
        try {
            return Resp.isOk().data(userService.findByUsername(username));
        } catch (Exception exception) {
            return Resp.isFail(exception);
        }
    }


    @GetMapping("get/{userId}")
    public Resp retrieveById(@PathVariable("userId") String userId){
        try {
            return Resp.isOk().data(userService.getById(userId));
        } catch (Exception exception) {
          return Resp.isFail(exception);
        }
    }
}
