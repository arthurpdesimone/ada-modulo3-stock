package br.tech.ada.stock.service;

import br.tech.ada.stock.model.Stock;
import br.tech.ada.stock.repository.StockRepository;
import br.tech.ada.stock.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class StockService {
    @Value("${api.key}")
    private String apiKey;

    @Value("${url}")
    private String URL;

    @Autowired
    private StockRepository stockRepository;

    public void downloadStock(String ticker) throws IOException, ParseException {
        String stockString = Utils.downloadToString(URL+"TIME_SERIES_DAILY&symbol="+ticker+"&outputsize=full&datatype=csv&apikey="+apiKey);
        /** Stock download*/
        BufferedReader timeSeries = new BufferedReader(new StringReader(stockString));
        timeSeries.readLine(); /** Skip the first line */
        String row;
        while ((row = timeSeries.readLine()) != null) {
            String[] data = row.split(",");
            String date = data[0];
            String close = data[4];
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date d = simpleDateFormat.parse(date);
            Double closeValue = Double.parseDouble(close);
            Stock stock = new Stock(ticker,d, closeValue);
            stockRepository.save(stock);
        }
        timeSeries.close();
    }


}
