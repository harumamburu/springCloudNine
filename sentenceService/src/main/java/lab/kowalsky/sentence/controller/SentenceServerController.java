package lab.kowalsky.sentence.controller;

import lab.kowalsky.sentence.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentenceServerController {

    @Autowired
    private SentenceService sentenceService;

    @GetMapping("/sentence")
    public String getRandomWord() {
        return sentenceService.assembleSentence();
    }
}
