package co.alexis.spring.controller;

import co.alexis.spring.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){

        return "test";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute User user, Model model) {

        model.addAttribute("user", user);


        System.out.println(user);
        System.out.println(user.getId());

        model.addAttribute("id", user.getId());
        model.addAttribute("name", user.getName());

        return "cabinet";
    }
}
