package tech.algofinserve.advisory.infra;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.annotation.PostConstruct;

public class ChartInkConnectionFactory {

    public static final String url = "https://chartink.com/screener/process";
    private static Connection connection= null;
    private ChartInkConnectionFactory()
    {

    }
    @PostConstruct
    public static synchronized Connection getChartInkConnection()
    {
        if (connection == null) {
            connection = Jsoup.connect(url);
        }
        return connection;
    }
}
