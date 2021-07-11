package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionScope
public class SessionController {
    @RequestMapping(value = "/session")
    @ResponseBody
    public String testSession(HttpServletRequest request) {
        String getId = request.getSession().getId();
        return "Oh my God";
    }
}
