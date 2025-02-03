package page;

import static utilites.RandomValue.randomInt;

public class SharedData {
    private static String groupName = "Авто Группа-" + randomInt(4);;
    private static String orgName = "ООО-" + randomInt(4);;

    // Setter for the extracted value
    public static void setGroupName(String value) {
        groupName = value;
    }

    // Getter for the extracted value
    public static String getGroupName() {
        return groupName;
    }
    public static void setOrgName(String value) {
        orgName = value;
    }

    // Getter for the extracted value
    public static String getOrgName() {
        return orgName;
    }
}
