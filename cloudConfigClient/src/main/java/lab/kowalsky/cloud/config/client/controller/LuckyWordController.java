package lab.kowalsky.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class LuckyWordController {

    @Value("${wordConfig.preamble}")
    private String preamble;
    @Value("${wordConfig.luckyWord}")
    private String luckyWord;

    @GetMapping("/word")
    public String showLuckyWord() {
        return String.format("%s: %s.", preamble, luckyWord);
    }
}
