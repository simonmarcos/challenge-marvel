package com.test.challenge.challenge.service.marvel;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

public interface AuthenticationMarvelService {
    Map<String, Object> getParamsUrl() throws NoSuchAlgorithmException;

    String getBaseUrl(String pathname);
}
