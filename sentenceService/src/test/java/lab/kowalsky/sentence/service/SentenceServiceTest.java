package lab.kowalsky.sentence.service;

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
public class SentenceServiceTest {

    @Mock
    private WordService wordService;
    @InjectMocks
    private SentenceService target;

    @Test
    public void testAssembleSentence_allWordsReturned_sentenceIsAssembledInOrder() {
        when(wordService.getSubject()).thenReturn("I");
        when(wordService.getVerb()).thenReturn("ran");
        when(wordService.getArticle()).thenReturn("an");
        when(wordService.getAdjective()).thenReturn("awesome");
        when(wordService.getNoun()).thenReturn("test");

        assertThat(target.assembleSentence(), is(equalTo("I ran an awesome test.")));
    }
}
