package boot.mytemp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homeView(){
        //System.out.println("home");
        return "views/home";
    }
}
