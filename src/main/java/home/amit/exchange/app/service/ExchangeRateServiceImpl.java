package home.amit.exchange.app.service;
/*
User :- AmitSingh
Date :- 8/18/2023
Time :- 8:16 PM
Year :- 2023
*/

import home.amit.exchange.app.dto.ExchangeRateDTO;
import home.amit.exchange.app.util.ExchangeRateConstants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService{



    // 0/10 0 * * * ?
    //  @Scheduled(cron = 0/10 0 * * * ?)
    @Override
    @Scheduled(fixedRate = 10000)
    public Map<String, Double> getExchangeRates() {
        int MAX_RETRIES=3;
        int retries = 0;
        while (retries < MAX_RETRIES) {
            try {
                Document doc = Jsoup.connect(ExchangeRateConstants.EXCHANGE_RATE_URL).get();
                Elements elements = doc.select("Cube[currency]");

                Map<String, Double> rates = new HashMap<>();
                rates.put("EUR", 1.0); // Euro as base currency

                for (Element element : elements) {
                    String currency = element.attr("currency");
                    double rate = Double.parseDouble(element.attr("rate"));
                    rates.put(currency, rate);
                }

                return rates;
            } catch (IOException e) {
                // Retry the fetch
                retries++;
                if (retries >= MAX_RETRIES) {
                    throw new RuntimeException("Failed to fetch exchange rates from ECB after retries.");
                }
                // Add some delay before retrying
                sleepForRetry();
            }
        }
        throw new RuntimeException("Failed to fetch exchange rates from ECB.");
    }

    private void sleepForRetry() {
        try {
            Thread.sleep(1000); // Sleep for 1 second before retrying
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    // INR to DLR
    // INR to EUR
    // DLR to EUR
    // INRAMT to DLR
    @Override
    public Double getExchangeRate(ExchangeRateDTO exchangeRateDTO) {
        Map<String, Double> rates = getExchangeRates();
        double fromRate = rates.getOrDefault(exchangeRateDTO.getFromCurreny(), 1.0);
        double toRate = rates.getOrDefault(exchangeRateDTO.getToCurrency(), 1.0);
        double fromRateEur=exchangeRateDTO.getAmount()/fromRate;
        double toRateCurrencyAmount=fromRateEur*toRate;
        return toRateCurrencyAmount;
    }
}
