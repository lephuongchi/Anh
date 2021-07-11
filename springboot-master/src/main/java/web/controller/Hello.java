package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import web.model.Customer;

@Controller
public class Hello {
    @RequestMapping(value = {"/securitylogin"})
    public String login(@RequestParam(required = false) String message, final Model model) {
        if (message != null && !message.isEmpty()) {
            model.addAttribute("message", "Login Failed!");
        }
        return "lol";
    }

    @RequestMapping(value = {"/login"})
    public String Login() {
        return "logincc";
    }

    @GetMapping(value = "/")
    public ModelAndView index() {
        //LocaleContextHolder.
        ModelAndView modelAndView = new ModelAndView("registryCustomer");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @GetMapping(value = "/international")
    public String inter() {
        //LocaleContextHolder.setLocale(Locale.JAPAN);
        return "lol";
    }

    @GetMapping(value = "mycar.html")
    public String inter1() {
        //LocaleContextHolder.setLocale(Locale.JAPAN);
        return "mycar";
    }

    @GetMapping(value = "/home")
    public String home() {
        return "home";
    }

    @GetMapping(value = "/api")
    public String api() {
        return "home";
    }
}
