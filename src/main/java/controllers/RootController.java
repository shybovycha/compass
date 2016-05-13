package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shybovycha on 12/05/16.
 */
@Controller
public class RootController {
    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
