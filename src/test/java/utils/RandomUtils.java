package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        String [] name = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        //System.out.println(randomCity(name));
    }


    public static String randomString(int len) {

        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String randomEmail() {

        return randomString(10) + "@mail.ru";
    }
    public static String random(String[] values) {


        int hobbies = randomInt(0, values.length - 1);
            return values[hobbies];
    }




}
