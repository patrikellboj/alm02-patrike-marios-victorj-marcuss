package com.example.almspringprova;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
class FortuneController {

//--------------------------------------

    public FortuneController() {    }

//--------------------------------------

    @GetMapping("/")
    public String GoToHomePage(@ModelAttribute("theperson") Person person) {
        //Person person = new Person();
        // model.addAttribute("theperson", person);
        return "index";
    }


}
