package kr.pengu.pengu.domain.riot.controller;

import kr.pengu.pengu.domain.riot.service.RiotApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/riots")
@RequiredArgsConstructor
@Slf4j
public class RiotApiController {

    private final RiotApiService riotApiService;

    @GetMapping("/{gameName}/{tagLine}")
    @ResponseBody
    public String search(@PathVariable String gameName, @PathVariable String tagLine) {
        log.debug("gameName: {}, tagLine: {}", gameName, tagLine);
        return riotApiService.searchSummoner(gameName, tagLine);
    }
}
