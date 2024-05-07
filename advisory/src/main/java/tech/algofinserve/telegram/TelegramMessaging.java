package tech.algofinserve.telegram;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TelegramMessaging {
    static String telegramToken = "6552278371:AAHhYOrBcC1ccls6BVTwF9UoOjFjc8Zj9p8";

    public static void main(String[] args) {

        TelegramMessaging.getUpdates();
        TelegramMessaging.sendMessage2();
    }

    public static void sendMessage() {
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

        String chatId = "ideastoinvest";
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

    public static void getUpdates() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.telegram.org/bot" + telegramToken + "/getUpdates")
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            System.out.println(responseBody);

            // Parse the response to get chat IDs
            // Example: Extract chat ID from responseBody and use it
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void sendMessage2() {
        String telegramToken = "6552278371:AAHhYOrBcC1ccls6BVTwF9UoOjFjc8Zj9p8";
        String chatId = "ideastoinvest";
        String text = "Hello world!";
        try {
            URL url = new URL("http://api.telegram.org/bot" + telegramToken + "/sendMessage");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");

            String jsonInputString = "{\"chat_id\": \"" + chatId + "\", \"text\": \"" + text + "\"}";

            try (OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream())) {
                wr.write(jsonInputString);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
