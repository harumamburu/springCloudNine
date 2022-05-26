package lab.kowalsky.sentence.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lab.kowalsky.sentence.client.feign.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {

    @Autowired
    private SubjectClient subjectClient;
    @Autowired
    private VerbClient verbClient;
    @Autowired
    private ArticleClient articleClient;
    @Autowired
    private AdjectiveClient adjectiveClient;
    @Autowired
    private NounClient nounClient;
    
    @CircuitBreaker(name = "subjectClientCircuitBreaker", fallbackMethod = "getFallbackSubject")
    public String getSubject() {
        return subjectClient.getWord();
    }
    
    @CircuitBreaker(name = "verbClientCircuitBreaker", fallbackMethod = "getFallbackVerb")
    public String getVerb() {
        return verbClient.getWord();
    }
    
    @CircuitBreaker(name = "articleClientCircuitBreaker", fallbackMethod = "getFallbackArticle")
    public String getArticle() {
        return articleClient.getWord();
    }
    
    @CircuitBreaker(name = "adjectiveClientCircuitBreaker", fallbackMethod = "getFallbackAdjective")
    public String getAdjective() {
        return adjectiveClient.getWord();
    }
    
    @CircuitBreaker(name = "nounClientCircuitBreaker", fallbackMethod = "getFallbackNoun")
    public String getNoun() {
        return nounClient.getWord();
    }

    private String getFallbackSubject(Exception exc) {
        return "Someone";
    }

    private String getFallbackVerb(Exception exc) {
        return "failed";
    }

    private String getFallbackArticle(Exception exc) {
        return "";
    }

    private String getFallbackAdjective(Exception exc) {
        return "";
    }

    private String getFallbackNoun(Exception exc) {
        return "something";
    }
}
