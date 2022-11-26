import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String key = null;
        Map coursesAndDateSubscribs = new TreeMap();
        List dateSubscribs;

        String url = "jdbc:mysql://localhost:3306/skillbox_sql_db";
        String user = "root";
        String pass = "admin123";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT pl.course_name, " +
                    "pl.subscription_date  " +
                    "FROM purchaseList pl " +
                    "ORDER BY pl.course_name, pl.subscription_date;" );
            dateSubscribs = new ArrayList<>();
            while (resultSet.next()){

                String courseName = resultSet.getString("course_name");
                String subscriptionDate = resultSet.getString("subscription_date");
                if(key == null) {
                    key = courseName;
                }
                    if(courseName.equals(key)){
                        dateSubscribs.add(subscriptionDate);
                    }else{
                        coursesAndDateSubscribs.put(key, dateSubscribs);
                        dateSubscribs = new ArrayList<>();
                        key = courseName;
                        dateSubscribs.add(subscriptionDate);
                    }
            }
            coursesAndDateSubscribs.put(key,dateSubscribs);

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        for(Object courses : coursesAndDateSubscribs.keySet()) {
             ArrayList dates = (ArrayList) coursesAndDateSubscribs.get(courses);
             String beginDate = (String) dates.get(0);
             String endDate = (String) dates.get(dates.size() - 1);



            int delta = getMonthsSales(endDate) - getMonthsSales(beginDate);
            double averageSales =  ((double) Math.round(((double)dates.size() / delta)*100))/100;
            System.out.println("Для курса: \"" + courses + "\" - среднее количество покупок в месяц за 2018 год равно: " + averageSales );
        }
    }

    public static int getMonthsSales(String stringDate) {

        String toDate = stringDate.replace(" ", "T");
        LocalDateTime date = LocalDateTime.parse(toDate);
        int month = (date.getMonthValue());

        return month;
    }
}
