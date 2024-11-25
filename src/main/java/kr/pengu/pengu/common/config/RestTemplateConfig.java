package kr.pengu.pengu.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {

    private final RiotApiConfig riotApiConfig;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(List.of(riotApiInterceptor()));
        return restTemplate;
    }

    // RIOT API 통신에 필요한 X-Riot-Token 을 헤더를 추가하는 인터셉터
    private ClientHttpRequestInterceptor riotApiInterceptor() {
        return (request, body, execution) -> {
            request.getHeaders().add("X-Riot-Token", riotApiConfig.getRiotApiKey());
            return execution.execute(request, body);
        };
    }
}


