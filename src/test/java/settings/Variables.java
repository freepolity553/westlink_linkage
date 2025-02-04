package settings;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static utilites.RandomValue.randomInt;

public class Variables {


    private String groupName = "Авто Группа-" + random(5);
    public static String lastName = "Тестовский"+ randomInt(4);
    public static String firstName = "Тест";
    public static String sql = "SELECT * FROM (VALUES ('10-10-2024'::DATE, 10), ('11-10-2024'::DATE, 15), ('12-10-2024'::DATE, 11)) AS t (date, id)";



}



