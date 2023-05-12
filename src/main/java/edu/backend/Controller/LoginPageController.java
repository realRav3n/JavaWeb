package edu.backend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin
public class LoginPageController {
    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public String Index(){
        return "loginPage";
    }
}
