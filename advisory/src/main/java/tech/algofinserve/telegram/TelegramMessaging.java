package tech.algofinserve.telegram;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TelegramMessaging {





public static void main(String[] args){
    TelegramMessaging.sendMessage();
}
    public static void sendMessage(){
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
        String telegramToken="6552278371:AAHhYOrBcC1ccls6BVTwF9UoOjFjc8Zj9p8";
        String chatId = "-1001024054312";
        String text = "Hello world!";




        urlString = String.format(urlString, telegramToken, chatId, text);

        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
