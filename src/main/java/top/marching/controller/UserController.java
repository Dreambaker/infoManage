package top.marching.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import top.marching.model.User;



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
    @RequestMapping("/add")
    public ModelAndView addUser(String id,String email,String mobile,String username,String role){
            ModelAndView mv = new ModelAndView();
            User user = new User(Long.parseLong(id), email, mobile, username, role);
            userService.addUser(user);
        return mv;
    }
}
