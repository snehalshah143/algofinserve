package tech.algofinserve.pricing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AngelMetaData {
    public static final String ANGEL_ALL_INSTRUMENT_LIST_API="https://margincalculator.angelbroking.com/OpenAPI_File/files/OpenAPIScripMaster.json";

   public static List<AngelInstrument> angelInstrumentList=new ArrayList<>();
   //NSE Code to Instrument Map
   public static Map<String,AngelInstrument> angelInstrumentMap=new ConcurrentHashMap<>();
   @PostConstruct
    public void loadAngelInstruments() throws IOException {
        URLConnection request = new URL(ANGEL_ALL_INSTRUMENT_LIST_API).openConnection();
        request.connect();
        InputStreamReader inputStreamReader = new InputStreamReader((InputStream) request.getContent());

        // map to GSON objects
        JsonElement root = new JsonParser().parse(inputStreamReader);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonArray items = root.getAsJsonArray();

        items.forEach(item->{
            try {
                AngelInstrument instrument= objectMapper.readValue( item.toString(), AngelInstrument.class);
                angelInstrumentList.add(instrument);
                angelInstrumentMap.put(instrument.getName(),instrument);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }


}
