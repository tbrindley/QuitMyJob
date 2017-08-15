package com.jdbcdemo.controller;


import com.fp.models.Clients;
import com.jdbcdemo.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * Created by jayme on 8/15/2017.
 */

public class Password {
    public static String hashAndSalt(String password) throws NoSuchAlgorithmException, NoSuchProviderException {
        //String passwordToHash = "password";
        byte[] salt = getSalt();

        String securePassword = getSecurePassword(password, salt);
        //System.out.println(securePassword); //Prints 83ee5baeea20b6c21635e4ea67847f66

        //String regeneratedPasswordToVerify = getSecurePassword(passwordToHash, salt);
        //System.out.println(regeneratedPasswordToVerify); //Prints 83ee5baeea20b6c21635e4ea67847f66
      return securePassword;
    }

    private static String getSecurePassword(String passwordToHash, byte[] salt) {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt);
            //Get the hash's bytes
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    //Add salt
    private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
    {
        //Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        sr.nextBytes(salt);
        //return salt
        return salt;
    }
}