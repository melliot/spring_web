package co.alexis.spring.controller;

import co.alexis.spring.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model){
        model.addAttribute("user", new User());

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute User user, BindingResult result, Model model) {
        model.addAttribute("user", user);


        user.setName((String) result.getRawFieldValue("name"));
        user.setEmail((String) result.getRawFieldValue("email"));

        System.out.println(user);

        return "cabinet";
    }
}
