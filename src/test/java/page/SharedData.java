package page;

public class SharedData extends BasePage {

    private static String groupName = "Авто Группа-" + randomInt(4);
    ;

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

    public static String getOrgName() {
        return orgName;
    }

    private static String lastName = "ТЕСТ" + randomestring(4);

    public static void setLastName(String value) {
        lastName = value;
    }

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

    private static String widgetTableName = "Виджет(Таблица) " + randomInt(3);
    public static void setWidgetTableName(String value) {
        widgetTableName = value;
    }
    // Getter for the extracted value
    public static String getWidgetTableName() {
        return widgetTableName;
    }

    private static String widgetDiagrammeName = "Виджет(Диаграмма) " + randomInt(3);
    public static void setWidgetDiagrammeName(String value) {
        widgetDiagrammeName = value;
    }

    // Getter for the extracted value
    public static String getWidgetDiagrammeName() {
        return widgetDiagrammeName;
    }

    private static String dashboardName = "Дашборд " + randomInt(3);
    public static void setDashboardName(String value) {
        dashboardName = value;
    }

    // Getter for the extracted value
    public static String getDashboardName() {
        return dashboardName;
    }
    // Setter for the extracted value
}



