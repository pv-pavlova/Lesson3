package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.NotEmpty;

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting() {
        return "greeting";
    }

    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String SayHello(Model model) {
        model.addAttribute("message","Hello, user");
        return "hello";
    }

    @RequestMapping(value="/hello", method=RequestMethod.POST)
    public String SayHelloResult(@ModelAttribute FormEntity form, Model model) {
        model.addAttribute("message", "Hello, " + form.name);
        return "hello";
    }

}

class FormEntity{
    @NotEmpty(message = "Name should not be empty")
    public String name;

    public FormEntity() {

    }

    public FormEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
