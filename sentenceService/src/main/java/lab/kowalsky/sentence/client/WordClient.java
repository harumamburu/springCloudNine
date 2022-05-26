package lab.kowalsky.sentence.client;

import org.springframework.web.bind.annotation.GetMapping;

public interface WordClient {

    @GetMapping("/")
    String getWord();
}
