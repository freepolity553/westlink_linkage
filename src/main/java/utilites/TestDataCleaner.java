package utilites;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDataCleaner {

    public static void cleanTestDataFromNavigator() {
        String sql = "delete FROM public.widget_metric WHERE widget_id IN ( SELECT id FROM public.widget WHERE title LIKE ANY(ARRAY['Виджет(Таблица)%', 'Виджет(Диаграмма)%', 'Города(авто)%', 'Точки продаж(авто)%']));\n" +
                "delete FROM public.dashboard_widgets WHERE widget_id IN (SELECT id FROM public.widget WHERE title LIKE ANY(ARRAY['Виджет(Таблица)%', 'Виджет(Диаграмма)%', 'Города(авто)%', 'Точки продаж(авто)%']));\n" +
                "delete FROM public.metric WHERE name LIKE ANY(ARRAY['Показатель(авто)%','Город(авто)%','Точка продажи(авто)%']);\n" +
                "DELETE from public.widget WHERE title LIKE ANY(ARRAY['Виджет(Таблица)%','Виджет(Диаграмма)%','Города(авто)%','Точки продаж(авто)%']);\n" +
                "delete FROM public.dashboard WHERE name LIKE ANY(ARRAY['Агротех(авто)%','Дашборд(авто)%']);"; // Replace with your condition

        try (Connection conn = DatabaseUtils.getConnectionNavigator();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
            System.out.println("Test data cleaned successfully for Navigator .");

        } catch (SQLException e) {
            System.err.println("Error cleaning test data: " + e.getMessage());
        }
    }
    public static void cleanTestDataFromUsers() {
        String sql = "delete FROM public.person WHERE last_name like 'ТЕСТ%';\n" +
                "delete FROM public.organisation  WHERE full_name like 'ООО-(авто)%';\n" +
                "delete FROM public.access_group WHERE name like 'Группа(авто)-%';";

        try (Connection conn = DatabaseUtils.getConnectionUsers();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.executeUpdate();
            System.out.println("Test data cleaned successfully for Users.");

        } catch (SQLException e) {
            System.err.println("Error cleaning test data: " + e.getMessage());
        }

    }
}