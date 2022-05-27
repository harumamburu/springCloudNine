package lab.kowalsky.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/fallback")
public class FallbackController {

    @GetMapping("/subject")
    public String fallbackSubject() {
        return "Someone";
    }

    @GetMapping("/verb")
    public String fallbackVerb() {
        return "failed";
    }

    @GetMapping("/noun")
    public String fallbackNoun() {
        return "something";
    }

    @GetMapping("/empty")
    public String fallbackEmpty() {
        return "";
    }
}
