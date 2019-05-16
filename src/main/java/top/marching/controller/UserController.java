package top.marching.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.marching.model.User;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private top.marching.service.IUserService userService;

    @RequestMapping("/select")
    public ModelAndView selectUser() throws Exception {
        ModelAndView mv = new ModelAndView();
        User user = userService.selectUser(1);
        mv.addObject("user", user);
        mv.setViewName("user");
        return mv;
    }

    @RequestMapping(value = "/add" )
    public String  addUser(){
        return "addUser";
    }

    @RequestMapping(value = "/reg" ,method = RequestMethod.POST)
    public String  register(@ModelAttribute User user){
        userService.addUser(user);
        return "redirect:/user/select/";
    }

    @RequestMapping(value = "/delete")
    public String  deleteUser(@RequestParam("id") long id){
        userService.deleteUser(id);
        return "addUser";
    }

}
