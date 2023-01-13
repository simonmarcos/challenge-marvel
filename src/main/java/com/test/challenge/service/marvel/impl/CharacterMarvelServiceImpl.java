package com.test.challenge.service.marvel.impl;

import com.test.challenge.service.marvel.AuthenticationMarvelService;
import com.test.challenge.service.marvel.CharacterMarvelService;
import com.test.challenge.service.marvel.model.CharacterMarvel;
import com.test.challenge.service.marvel.model.GenericMarvelResponse;
import org.springframework.data.domain.Pageable;
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
    public List<CharacterMarvel> findAll(Pageable pageable) {
        List<CharacterMarvel> characterResponseList = null;

        try {
            Map<String, Object> paramsForRequest = authenticationMarvelService.getParamsUrlWithPagination(pageable);
            String BASE_URL = authenticationMarvelService.getBaseUrlWithPagination(PATH_NAME);

            ResponseEntity<GenericMarvelResponse> responseEntity = restTemplate.getForEntity(BASE_URL, GenericMarvelResponse.class, paramsForRequest);
            characterResponseList = Objects.requireNonNull(responseEntity.getBody()).getDataMarvelResponse().getResults();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return characterResponseList;
    }

    @Override
    public List<CharacterMarvel> findByName(String name) {
        List<CharacterMarvel> characterResponseList = null;

        try {
            Map<String, Object> paramsForRequest = authenticationMarvelService.getParamsUrl();
            paramsForRequest.put("name", name);

            String baseUrl = authenticationMarvelService.getBaseUrl(PATH_NAME) + "&name={name}";

            ResponseEntity<GenericMarvelResponse> responseEntity = restTemplate.getForEntity(baseUrl, GenericMarvelResponse.class, paramsForRequest);
            characterResponseList = Objects.requireNonNull(responseEntity.getBody()).getDataMarvelResponse().getResults();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return characterResponseList;
    }
}
