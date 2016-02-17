package co.alexis.spring.controller;

import co.alexis.spring.entity.User;
import co.alexis.spring.repository.CustomerRepository;
import co.alexis.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {

	@Autowired
	private UserRepository repository;

	@ModelAttribute("user")
	public User getUser() {

		return new User();
	}

	@ModelAttribute("users")
	public List<User> getUsers() {

		return repository.findAll();
	}

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model){

	    List<User> users = repository.findAll();

        model.addAttribute("users", users);

        return "login";
    }

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSubmit(@Valid User user, BindingResult result, Model model) {



		model.addAttribute("user", user);

		if (repository.findByName(user.getEmail()) != null) {
			System.out.println("User already exist!");
		} else {
			repository.save(user);
		}
//		if (result.hasErrors()) {
//			System.out.println("ERROR");
//			return "login";
//		}

		System.out.println(user);

		return "cabinet";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(){

		repository.deleteAll();

		return "redirect:/login";
	}
}
