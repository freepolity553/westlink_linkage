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




    private static String mockName = "test" + randomInt(4);
    public static void setMockName(String value) {
        mockName = value;
    }
    public static String getMockName() {
        return mockName;
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
    public static String getMetricName() {
        return metricName;
    }

    private static String metricCities = "Города " + randomInt(3);
    public static void setMetricCities(String value) {
        metricCities = value;
    }
    public static String getMetricCities() {
        return metricCities;
    }

    private static String metricPoints = "Точки продажи " + randomInt(3);
    public static void setMetricPoints(String value) {
        metricPoints = value;
    }
    public static String getMetricPoints() {
        return metricPoints;
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
    public static String getWidgetDiagrammeName() {
        return widgetDiagrammeName;
    }


    private static String widgetCitiesName = "Города " + randomInt(3);
    public static void setWidgetCitiesName(String value) {
        widgetCitiesName = value;
    }
    public static String getWidgetCitiesName() {
        return widgetCitiesName;
    }


    private static String widgetPointsName = "Точки продаж " + randomInt(3);
    public static void setWidgetPointsName(String value) {
        widgetPointsName = value;
    }
    public static String getWidgetPointsName() {
        return widgetPointsName;
    }


    private static String dashboardName = "Дашборд " + randomInt(3);
    public static void setDashboardName(String value) {
        dashboardName = value;
    }
    public static String getDashboardName() {
        return dashboardName;
    }

    private static String dashboardAgrotech = "Агротех " + randomInt(3);
    public static void setDashboardAgrotech(String value) {
        dashboardAgrotech = value;
    }
    public static String getDashboardAgrotech() {
        return dashboardAgrotech;
    }

    private static String workstationName = "АРМ " + randomInt(3);
    public static void setWorkstationName(String value) {
        workstationName = value;
    }
    public static String getWorkstationName() {
        return workstationName;
    }

}



