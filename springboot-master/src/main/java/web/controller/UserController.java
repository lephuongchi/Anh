package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/formUser")
    public String formUser(Model model) {
        model.addAttribute("user", new User());
        return "formUser";
    }

    @PostMapping(path = "/add")
    public String addNewUser(HttpServletRequest request, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {
        request.getSession().isNew();
        request.getSession().getId();
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        userService.saveUser(user);
        return "registryCustomer";
    }

    @PostMapping(path = "/addBody")
    public @ResponseBody
    String addNewUserBody(@RequestBody User user) {
        userService.saveUser(user);
        return "User Created";
    }
}