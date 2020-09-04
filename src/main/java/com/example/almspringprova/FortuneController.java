package com.example.almspringprova;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
class FortuneController {
    Translator translator;



//--------------------------------------
    @Autowired
    public FortuneController(Translator translator) {
        this.translator = translator;
    }

//--------------------------------------

    @GetMapping("/")
    public String GoToHomePage(@ModelAttribute("theperson") Person person) {
        return "index";
    }

    @GetMapping("/fortune")
    public String getfortune(@ModelAttribute("theperson") Person person) {
        String result = translator.selectMsgAccordingToRule(person);
        return "redirect:/?response=" + result;
    }
}
