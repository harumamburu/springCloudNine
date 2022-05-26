package lab.kowalsky.sentence.client.feign;

import lab.kowalsky.sentence.client.WordClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("word-service-article")
public interface ArticleClient extends WordClient {
}
