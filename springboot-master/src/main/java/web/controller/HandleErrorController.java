package web.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
@Controller
public class HandleErrorController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("ccerror");
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                modelAndView.addObject("error", "404 - Not Found");
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                modelAndView.addObject("error", "500 - Internal Server");
            } else if(statusCode == HttpStatus.UNAUTHORIZED.value()) {
                modelAndView.addObject("error", "401 - Unauthorized");
            }
        }
        return modelAndView;
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
