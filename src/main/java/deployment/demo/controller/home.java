package deployment.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {

    @RequestMapping("/")
    public String home(){
        return "Deployment Assignment";
    }
}
