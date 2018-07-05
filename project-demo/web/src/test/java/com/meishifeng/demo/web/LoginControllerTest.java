package com.meishifeng.demo.web;

import com.meishifeng.demo.BaseSpringJUnit4Test;
import com.meishifeng.demo.web.controller.LoginController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <ul>
 * <li>描述类的作用</li>
 * <li>1.方法一说明</li>
 * <li>2.方法二说明</li>
 * <li>User:meishifeng Date:2018/7/5 Time:21:01</li>
 * </ul>
 */
public class LoginControllerTest extends BaseSpringJUnit4Test {

    @Autowired
    private LoginController loginController;

    @Test
    public void testResponseBody(){
        System.out.println(loginController.login());
    }

}
