package tech.algofinserve.pricing;

import com.angelbroking.smartapi.Routes;
import com.angelbroking.smartapi.SmartConnect;
import com.angelbroking.smartapi.http.SessionExpiryHook;
import com.angelbroking.smartapi.http.exceptions.SmartAPIException;
import com.angelbroking.smartapi.models.TokenSet;
import com.angelbroking.smartapi.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class AngelBrokerConnector {

    public static void main(String[] args) throws IOException, SmartAPIException {
        SmartConnect smartConnect = new SmartConnect();

        // Provide your API key here for historical
        smartConnect.setApiKey(AngelApiKey.historicalApiKey);

        // Set session expiry callback.
        smartConnect.setSessionExpiryHook(new SessionExpiryHook() {
            @Override
            public void sessionExpired() {
                System.out.println("session expired");
            }
        });
        String clientID="S133712";
        String passowrd="1805";
     //   String passowrd="Shree@12345";
        String totp=getTotp();
        generateSession(smartConnect,clientID,passowrd,totp);
       AngelBrokerConnector.getCandleData(smartConnect);
      //   log.info("response : {}", response);
    //    AngelBrokerConnector.getHistoricalData();



    }

    private static String getTotp() {
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        int code = gAuth.getTotpPassword(AngelApiKey.oneTimetotpKey);
        return String.valueOf(code);
    }

    private void regenerateToken(SmartConnect smartConnect ,User user){
        TokenSet tokenSet = smartConnect.renewAccessToken(user.getAccessToken(),
                user.getRefreshToken());
        smartConnect.setAccessToken(tokenSet.getAccessToken());
    }

    private static void generateSession(SmartConnect smartConnect, String clientID, String password, String topt){
        User user = smartConnect.generateSession(clientID, password,topt);
        smartConnect.setAccessToken(user.getAccessToken());
        smartConnect.setUserId(user.getUserId());
    }


    public static void getCandleData(SmartConnect smartConnect) throws SmartAPIException, IOException {

        JSONObject requestObejct = new JSONObject();
        requestObejct.put("exchange", "NSE");
        requestObejct.put("symboltoken", "3045");
        requestObejct.put("interval", "ONE_MINUTE");
        requestObejct.put("fromdate", "2023-12-29 09:00");
        requestObejct.put("todate", "2023-12-29 09:20");

        JSONArray response = smartConnect.candleDataAsJSONArray(requestObejct);
        System.out.println(response);
    }


}
