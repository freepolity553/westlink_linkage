package settings;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static utilites.RandomValue.randomInt;

public class Variables {


    private String groupName = "Авто Группа-" + random(5);
    public static String lastName = "Тестовский"+ randomInt(4);
    public static String firstName = "Тест";
    public static String sqlBasic = "SELECT * FROM (VALUES ('10-10-2024'::DATE, 10), ('11-10-2024'::DATE, 15), ('12-10-2024'::DATE, 11)) AS t (date, id)";

    public static String sqlCities = "SELECT public.cities.id,public.cities.city_name FROM public.cities";

    public static String sqlPoints = "SELECT public.points.id ,public.points.point_name,public.points.city_id  FROM public.points";

//Connection
    public static final String host = "89.169.138.24";
    public static final String port = "5432";
    public static final String nameBD = "demo_agrotech_set";
    public static final String user = "demo_view";
    public static final String password = "rnOWV07pmx1AuCELVATb";

}



