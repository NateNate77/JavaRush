package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(byteArrayOutputStream.toByteArray());
        BigInteger bigInt = new BigInteger(1, thedigest);
        String digest = bigInt.toString(16);
// Now we need to zero pad it if you actually want the full 32 chars.
        while(digest.length() < 32 ){
            digest = "0"+digest;
        }
     //   String digest = new String(thedigest);
        return digest.equals(md5);
    }
}
