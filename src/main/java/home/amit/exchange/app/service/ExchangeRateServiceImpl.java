package home.amit.exchange.app.service;
/*
User :- AmitSingh
Date :- 8/18/2023
Time :- 8:16 PM
Year :- 2023
*/

import home.amit.exchange.app.dto.ExchangeRateDTO;
import home.amit.exchange.app.util.ExchangeRateConstants;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService{
    private static final String EXCHANGE_SERVICE = "exchangeService";


    // 0/10 0 * * * ?
    //  @Scheduled(cron = 0/10 0 * * * ?)

//    @Scheduled(fixedRate = 10000)
    @Override
    @CircuitBreaker(name = EXCHANGE_SERVICE, fallbackMethod = "fallbackAfterRetry")
    @Retry(name = EXCHANGE_SERVICE)
     public Map<String, Double> getExchangeRates() {
        System.out.println("Trying to check service ");


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
                    throw new RuntimeException("Failed to fetch exchange rates from ECB ");
        }

    }
    public Map<String, Double> fallbackAfterRetry(Exception ex) {
        System.out.println("Retry exhausted with exception "+ ex.getMessage());
        return new HashMap<>();
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

        Map<String, Double> rates = getExchangeRates() ;
        double fromRate = rates.getOrDefault(exchangeRateDTO.getFromCurreny(), 1.0);
        double toRate = rates.getOrDefault(exchangeRateDTO.getToCurrency(), 1.0);
        double fromRateEur=exchangeRateDTO.getAmount()/fromRate;
        double toRateCurrencyAmount=fromRateEur*toRate;
        return toRateCurrencyAmount;


    }
}
