package tech.algofinserve.advisory.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.algofinserve.advisory.dao.InstrumentTickerAngelRepository;
import tech.algofinserve.advisory.mapper.InstrumentTickerAngelMapper;
import tech.algofinserve.advisory.model.domain.InstrumentTickerAngel;
import tech.algofinserve.advisory.model.persistable.InstrumentTickerAngelPersistable;
import tech.algofinserve.advisory.model.persistable.RecommendationPersistable;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static com.opencsv.CSVWriter.DEFAULT_SEPARATOR;

@Service
public class AngelMetaDataServiceImpl implements MetaDataService {
    private final String ANGEL_ALL_INSTRUMENT_LIST_API="https://margincalculator.angelbroking.com/OpenAPI_File/files/OpenAPIScripMaster.json";
private final String ANGEL_ALL_INSTRUMENT_FILE_CSV="src/main/resources/all_instrument.csv";
    private final String ANGEL_ALL_INSTRUMENT_FILE_TXT="src/main/resources/all_instrument_txt.txt";


    @Autowired
    InstrumentTickerAngelRepository instrumentTickerRepository;

    @Autowired
    InstrumentTickerAngelMapper instrumentTickerMapper;

   private List<InstrumentTickerAngel> instrumentTickerAngelList =new ArrayList<>();
   //NSE Code to Instrument Map
   private Map<String,InstrumentTickerAngel> instrumentTickerAngelMap=new ConcurrentHashMap<>();
 //  @PostConstruct
    public void loadInstrumentsTickerFromAPI() {
        deleteAllInstrumentTicker();
        URLConnection request = null;
        InputStreamReader inputStreamReader;
        try {
            request = new URL(ANGEL_ALL_INSTRUMENT_LIST_API).openConnection();
            request.connect();
            inputStreamReader = new InputStreamReader((InputStream) request.getContent());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // map to GSON objects
        JsonElement root = new JsonParser().parse(inputStreamReader);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonArray items = root.getAsJsonArray();

        items.forEach(item -> {
            try {
                InstrumentTickerAngel instrument = objectMapper.readValue(item.toString(), InstrumentTickerAngel.class);
                instrumentTickerAngelList.add(instrument);
                instrumentTickerAngelMap.put(instrument.getName(), instrument);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        saveInstrumentTickerList(instrumentTickerAngelList);
//writeDataToFile(ANGEL_ALL_INSTRUMENT_FILE_CSV,InstrumentTickerAngel.class, instrumentTickerAngelList);
    }

    public void saveInstrumentTickerList(List<InstrumentTickerAngel> instrumentTickerAngelList){
        List<InstrumentTickerAngelPersistable> instrumentPersistableList=
                instrumentTickerAngelList.stream().map(p->instrumentTickerMapper.mapDomainToPersistable(p)).collect(Collectors.toList());
        instrumentTickerRepository.saveAll(instrumentPersistableList);
    }

    public void deleteAllInstrumentTicker(){

        instrumentTickerRepository.deleteAll();
        instrumentTickerAngelList.clear();
        instrumentTickerAngelMap.clear();
    }

    public List<InstrumentTickerAngel> getAllInstrumentTickerList(){
        if(instrumentTickerAngelList.isEmpty()){
            instrumentTickerAngelList
                    .addAll(instrumentTickerRepository.findAll().stream()
                    .map(p->instrumentTickerMapper.mapPersistableToDomain(p)).collect(Collectors.toList()));

        }
        return instrumentTickerAngelList;
    }

    public InstrumentTickerAngel getInstrumentTickerForName(String tickerName){
        if(instrumentTickerAngelMap.isEmpty()){
            instrumentTickerAngelList
                    .addAll(instrumentTickerRepository.findAll().stream()
                            .map(p->instrumentTickerMapper.mapPersistableToDomain(p)).collect(Collectors.toList()));
            instrumentTickerAngelList.stream()
                    .forEach(p->instrumentTickerAngelMap.put(p.getName(), p));
        }
        return instrumentTickerAngelMap.get(tickerName);
    }

   public void writeDataToFile(String fileLocation,Class typeOfObject,List dataList) {
       Writer writer;
       try {
           writer = Files.newBufferedWriter(Paths.get(fileLocation));
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

       ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
       mappingStrategy.setType(typeOfObject);

       StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
               .withMappingStrategy(mappingStrategy)
               .withSeparator(DEFAULT_SEPARATOR)
               .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
               .build();
       try {
           beanToCsv.write(dataList);
           System.out.println("File Writing completed.");
       } catch (CsvDataTypeMismatchException e) {
           throw new RuntimeException(e);
       } catch (CsvRequiredFieldEmptyException e) {
           throw new RuntimeException(e);
       }


   }

}
