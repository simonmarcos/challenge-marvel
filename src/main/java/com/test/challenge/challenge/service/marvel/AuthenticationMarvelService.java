package com.test.challenge.challenge.service.marvel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface AuthenticationMarvelService {

    String getHash() throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
