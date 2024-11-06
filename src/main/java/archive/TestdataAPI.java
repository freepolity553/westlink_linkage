package archive;

import org.apache.commons.lang3.RandomStringUtils;

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
    public static String requestPMC = "{" +
            "\"data\":" + "[" +
            "{" +
            "\"file_link\":\"Ссылка на документ 66\"," +
            "\"num\":1," +
            "\"sheet\":" +
            "[{\"note\":\"Комментарий к листу 22\"," +
            "\"num\":2,\"reason_code\":1}]," +
            "\"vol_id\":1}]," +
            "\"pmc\":" + "{" +
            "\"approver_id\":2," +
            "\"author_id\":2," +
            "\"changer_id\":1," +
            "\"cpe_id\":1," +
            "\"normal_inspector_id\":1," +
            //"\"note\":\""+ random +"\"," +
            "\"note\":\"random\"," +
            "\"num\":1" +
            "}" +
            "}";
    public static String requestPMCerror = "{" +
            "\"data\":" + "[" +
            "{" +
            "\"file_link\":\"https://www.wikihow.com/\"," +
            "\"num\":2," +
            "\"sheet\":" +
            "[{\"note\":\"Testtest\"," +
            "\"num\":2,\"reason_code\":2}]," +
            "\"vol_id\":4}]," +
            "\"pmc\":" + "{" +
            "\"approver_id\":5," +
            "\"author_id\":1," +
            "\"changer_id\":1," +
            "\"cpe_id\":1," +
            "\"normal_inspector_id\":1," +
            "\"note\":\"Testnote\"," +
            "\"num\":1" +
            "}" +
            "}";

}

