package page;

import static utilites.RandomValue.randomInt;

public class SharedData extends BasePage{
    private static String groupName = "Авто Группа-" + randomInt(4);;
    public static void setGroupName(String value) {
        groupName = value;
    }
    // Getter for the extracted value
    public static String getGroupName() {
        return groupName;
    }
    private static String orgName = "ООО-" + randomInt(4);
    public static void setOrgName(String value) {
        orgName = value;
    }

    // Getter for the extracted value
    public static String getOrgName() {
        return orgName;
    }

    private static String lastName =  "ТЕСТ"+randomestring(4);
    public static void setLastName(String value) {
        lastName = value;
    }

    // Getter for the extracted value
    public static String getLastName() {
        return lastName;
    }

    private static String metricName = "Показатель " + randomInt(3);
    public static void setMetricName(String value) {
        metricName = value;
    }

    // Getter for the extracted value
    public static String getMetricName() {
        return metricName;
    }

    // Setter for the extracted value




}
