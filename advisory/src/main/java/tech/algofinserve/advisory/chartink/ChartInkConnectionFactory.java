package tech.algofinserve.advisory.chartink;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class ChartInkConnectionFactory {

    public static final String url = "https://chartink.com/screener/process";
    private static Connection connection= null;
    private ChartInkConnectionFactory()
    {

    }


    public static synchronized Connection getChartInkConnection()
    {
        if (connection == null) {
            connection = Jsoup.connect(url);
        }
        return connection;
    }
}
