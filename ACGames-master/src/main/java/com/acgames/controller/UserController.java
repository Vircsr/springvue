package com.acgames.controller;

import com.acgames.entity.User;
import com.acgames.result.ResultFactory;
import com.acgames.service.AdminUserRoleService;
import com.acgames.service.UserService;
import com.acgames.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * User controller.
 *
 * @author Evan
 * @date 2019/11
 */

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;

    @GetMapping("api/user/getname/{id}")
    public Result getUsername(@PathVariable("id")int id){
        return ResultFactory.buildSuccessResult(userService.findUsernameById(id));
    }
    @GetMapping("/api/user/{username}")
    public Result getUserInfo (@PathVariable("username") String username) {
        return ResultFactory.buildSuccessResult((userService.findByUsername(username)));
    }
    @GetMapping("/api/admin/user")
    public Result listUsers() {
        return ResultFactory.buildSuccessResult(userService.list());
    }

    @PutMapping("/api/admin/user/status")
    public Result updateUserStatus(@RequestBody @Valid User requestUser) {
        userService.updateUserStatus(requestUser);
        return ResultFactory.buildSuccessResult("用户状态更新成功");
    }

    @PutMapping("/api/admin/user/password")
    public Result resetPassword(@RequestBody @Valid User requestUser) {
        userService.resetPassword(requestUser);
        return ResultFactory.buildSuccessResult("重置密码成功");
    }

    @PutMapping("/api/admin/user")
    public Result editUser(@RequestBody @Valid User requestUser) {
        userService.editUser(requestUser);
        return ResultFactory.buildSuccessResult("修改用户信息成功");
    }
}
