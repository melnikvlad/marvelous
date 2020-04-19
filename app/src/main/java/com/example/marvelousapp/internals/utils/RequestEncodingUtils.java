package com.example.marvelousapp.internals.utils;

import androidx.annotation.NonNull;

import com.example.marvelousapp.internals.exceptions.EncodeParamsException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class RequestEncodingUtils {

    private static final String PRIVATE_KEY = "98f6f500b78198bcfc0549fdaf127568ab45dea1";

    /*
        md5 encoding to get hashed api key.
        The api documentation says that md5 input should consist of "ts + privateKey + publicKey"
     */
    public static String encode(String ts, @NonNull String publicKey) throws EncodeParamsException {
        String input = new StringBuilder()
                .append(ts)
                .append(PRIVATE_KEY)
                .append(publicKey)
                .toString();

        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new EncodeParamsException();
        }
        digest.reset();
        digest.update(input.getBytes());
        byte[] array = digest.digest();
        int len = array.length;
        StringBuilder sb = new StringBuilder(len << 1);
        for (byte b : array) {
            sb.append(Character.forDigit((b & 0xf0) >> 4, 16));
            sb.append(Character.forDigit(b & 0x0f, 16));
        }
        return sb.toString();
    }
}
