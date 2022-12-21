package com.test.challenge.challenge.service.marvel.impl;

import com.test.challenge.challenge.service.marvel.AuthenticationMarvelService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationMarvelServiceImpl implements AuthenticationMarvelService {

    @Value("${marvel.api.privatekey}")
    private String privatekey;

    @Value("${marvel.api.publickey}")
    private String publickey;

    @Value("${marvel.api.url}")
    private String BASE_URL;

    @Override
    public Map<String, Object> getParamsUrl() throws NoSuchAlgorithmException {
        Map<String, Object> params = new HashMap<>();
        params.put("ts", "1");
        params.put("apikey", publickey);
        params.put("hash", getHash());

        return params;
    }

    @Override
    public String getBaseUrl(String pathname) {
        return BASE_URL + pathname + "?ts={ts}&apikey={apikey}&hash={hash}";
    }

    private String getHash() throws NoSuchAlgorithmException {
        final String tsValue = "1";
        final String hashValue = tsValue + privatekey + publickey;

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(hashValue.getBytes());
        byte[] theMD5digest = messageDigest.digest();

        StringBuilder stringBuilder = new StringBuilder();

        for (byte b : theMD5digest) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }

}
