package com.michaelliuyang.shiro.demo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The real login post action by shiro filter
 * Created by michael on 14-7-5.
 */
@Controller
public class DemoController {

    /**
     * login page
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * home page
     */
    @RequiresPermissions(value = "user:default")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /**
     * login fail
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM)
                       String userName, Model model) {
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
        return "fail";
    }

    /**
     * user page
     */
    @RequiresPermissions(value = "user:maintain")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user() {
        return "user";
    }

}
