import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox_sql_db";
        String user = "root";
        String pass = "admin123";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCT p.course_name,\n" +
                    "(MAX(DATE_FORMAT(p.subscription_date, '%m')) - MIN(DATE_FORMAT(p.subscription_date, '%m')))`months_sale`,\n" +
                    "DATE_FORMAT(skillbox_sql_db.p.subscription_date,\n" +
                    "'%m') `month`, count(*) `count`\n" +
                    "FROM purchaselist p\n" +
                    "GROUP BY p.course_name\n" +
                    "ORDER BY subscription_date;");

            while (resultSet.next()) {

                String courseName = resultSet.getString("course_name");
                double monthsSale = Double.parseDouble((resultSet.getString("months_sale")));
                double countSale = Double.parseDouble((resultSet.getString("count")));
                double averageSales = ((double) Math.round((countSale / monthsSale) * 100)) / 100;
                System.out.println("Для курса: \"" + courseName + "\" - среднее количество покупок в месяц за 2018 год равно: " + averageSales);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}