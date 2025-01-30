package page;

import static utilites.RandomValue.randomInt;

public class SharedData {
    private static String groupName = "Авто Группа-" + randomInt(4);;

    // Setter for the extracted value
    public static void setGroupName(String value) {
        groupName = value;
    }

    // Getter for the extracted value
    public static String getGroupName() {
        return groupName;
    }
}
