package com.test.challenge.challenge.service.marvel;

import org.springframework.data.domain.Pageable;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

public interface AuthenticationMarvelService {
    Map<String, Object> getParamsUrl() throws NoSuchAlgorithmException;

    Map<String, Object> getParamsUrlWithPagination(Pageable pageable) throws NoSuchAlgorithmException;

    String getBaseUrl(String pathname);

    String getBaseUrlWithPagination(String pathname);
}
