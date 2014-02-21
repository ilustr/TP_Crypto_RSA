/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 *
 * @author Anthony
 */
public class Cryptage {

    /**
     * Encoder le message en Sha1
     * @param message
     * @return Sha1 du message
     * @throws NoSuchAlgorithmException 
     */
    public static String encoderEnSHA1(String message) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(message.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        System.out.println("Crypter: "+sb.toString());
        return sb.toString();
    }
    
    /**
     * Compate SHA1
     * @param mot :  mot a encrypter en sha1 pour comparer
     * @param sha1 : sha1 a comparer
     * @return 
     */
    public Boolean compareSHA1(String mot, String sha1) throws NoSuchAlgorithmException{
        String sha1AComparer = Cryptage.encoderEnSHA1(mot);
        return sha1AComparer.equals(sha1);
    }
}
