package com.ws.experiment.springmvc.controller;

import com.ws.experiment.springmvc.pojo.User;
import com.ws.experiment.springmvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * UserController
 *
 * @author Eric at 2019-12-27_18:16
 */
@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/showUserToJspById", method = RequestMethod.GET)
    public String showUser(Model model) {
        LOGGER.info("In showUser() function");
        User user = userService.getById(1);
        model.addAttribute("user", user);
        return "showUser";
    }
}
