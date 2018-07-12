/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserController
 * Author:   aa806
 * Date:     2018/7/12 21:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mmall.controller.portal;

import com.mmall.common.Const;
import com.mmall.common.ServierResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author aa806
 * @create 2018/7/12
 * @since 1.0.0
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;
    /**
     * 用户登录
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody/*将返回值序列化成Json*/
    public ServierResponse<User> login(String username, String password, HttpSession session){
        //service-->mybatis-->dao
        ServierResponse<User> response = iUserService.login(username, password);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return  response;
    }
}