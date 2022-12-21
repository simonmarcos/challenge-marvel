package com.test.challenge.challenge.service.marvel.impl;

import com.test.challenge.challenge.service.marvel.AuthenticationMarvelService;
import com.test.challenge.challenge.service.marvel.CharacterMarvelService;
import com.test.challenge.challenge.service.marvel.model.CharacterMarvel;
import com.test.challenge.challenge.service.marvel.model.GenericMarvelResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class CharacterMarvelServiceImpl implements CharacterMarvelService {

    private final RestTemplate restTemplate;
    private final AuthenticationMarvelService authenticationMarvelService;

    private final String PATH_NAME = "characters";

    public CharacterMarvelServiceImpl(RestTemplate restTemplate, AuthenticationMarvelService authenticationMarvelService) {
        this.restTemplate = restTemplate;
        this.authenticationMarvelService = authenticationMarvelService;
    }

    @Override
    public List<CharacterMarvel> findByName(String name) {
        List<CharacterMarvel> characterResponseList = null;

        try {
            Map<String, Object> paramsForRequest = authenticationMarvelService.getParamsUrl();
            paramsForRequest.put("name", name);

            StringBuilder sbBaseUrl = new StringBuilder(authenticationMarvelService.getBaseUrl(PATH_NAME));
            sbBaseUrl.append("&name={name}");

            ResponseEntity<GenericMarvelResponse> responseEntity = restTemplate.getForEntity(sbBaseUrl.toString(), GenericMarvelResponse.class, paramsForRequest);
            characterResponseList = Objects.requireNonNull(responseEntity.getBody()).getDataMarvelResponse().getResults();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return characterResponseList;
    }
}
