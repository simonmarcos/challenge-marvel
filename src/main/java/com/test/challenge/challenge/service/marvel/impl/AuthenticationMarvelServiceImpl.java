package com.test.challenge.challenge.service.marvel.impl;

import com.test.challenge.challenge.service.marvel.AuthenticationMarvelService;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class AuthenticationMarvelServiceImpl implements AuthenticationMarvelService {

    @Value("${marvel.api.privatekey}")
    private String privatekey;

    @Value("${marvel.api.publickey}")
    private String publickey;


    @Override
    public String getHash() throws NoSuchAlgorithmException {
        final String tsValue = "1";
        final String hashValue = tsValue + privatekey + publickey;

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] theMD5digest = messageDigest.digest(hashValue.getBytes(StandardCharsets.UTF_8));

        return Arrays.toString(theMD5digest);
    }
}
