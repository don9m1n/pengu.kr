package kr.pengu.pengu.domain.riot.service;

import kr.pengu.pengu.common.config.RestTemplateConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Transactional
@RequiredArgsConstructor
public class RiotApiService {

    private final RestTemplate restTemplate;

    public String searchSummoner(String gameName, String tagLine) {

        String url = UriComponentsBuilder
                .fromHttpUrl("https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}")
                .buildAndExpand(gameName, tagLine)
                .toUriString();

        try {
            // TODO: 이후에 적합한 타입으로 반환하도록 수정
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            // 예외 처리: API 호출에 실패했을 경우 에러 메시지 반환
            return "Error while fetching data from Riot API: " + e.getMessage();
        }
    }
}
