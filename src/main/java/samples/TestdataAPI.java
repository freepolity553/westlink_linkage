package samples;

import java.util.Random;



public class TestdataAPI {

    protected static String getSaltString() {
        String SALTCHARS = "АБВГДАЖЗИКЛМНОПРСТУФХЦЧШЩЯ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    static String random = getSaltString();
    public static String request = "{" +
            "\"data\":" + "[" +
            "{" +
            //"\"note\":\""+ random +"\"," +
            "\"note\":\"random\"," +
            "\"num\":1" +
            "}" +
            "}";


}

