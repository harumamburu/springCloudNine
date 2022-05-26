package lab.kowalsky.sentence.service;

import lab.kowalsky.sentence.client.feign.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class WordServiceTest {

    @Mock
    private SubjectClient subjectClient;
    @Mock
    private VerbClient verbClient;
    @Mock
    private ArticleClient articleClient;
    @Mock
    private AdjectiveClient adjectiveClient;
    @Mock
    private NounClient nounClient;
    @InjectMocks
    private WordService target;

    @Test
    public void testAssembleSentence_allWordsReturned_sentenceIsAssembledInOrder() {
        when(subjectClient.getWord()).thenReturn("I");
        when(verbClient.getWord()).thenReturn("ran");
        when(articleClient.getWord()).thenReturn("an");
        when(adjectiveClient.getWord()).thenReturn("awesome");
        when(nounClient.getWord()).thenReturn("test");

        assertThat(String.format("%s %s %s %s %s.",
                target.getSubject(), target.getVerb(), target.getArticle(), target.getAdjective(), target.getNoun()),
                is(equalTo("I ran an awesome test.")));
    }
}
