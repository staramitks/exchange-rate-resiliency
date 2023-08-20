package home.amit.exchange.app.controller;
/*
User :- AmitSingh
Date :- 8/18/2023
Time :- 8:12 PM
Year :- 2023
*/

import home.amit.exchange.app.dto.ExchangeRateDTO;
import home.amit.exchange.app.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/exchange")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping("/rates")
    public ResponseEntity<Map<String, Double>> getExchangeRates() {
        Map<String, Double> rates = exchangeRateService.getExchangeRates();
        return ResponseEntity.ok(rates);
    }

    @GetMapping("/convert")
    public ResponseEntity<?> convertCurrency(
            @RequestParam double amount,
            @RequestParam String fromCurrency,
            @RequestParam String toCurrency) {
        ExchangeRateDTO exchangeRateDTO=ExchangeRateDTO.builder().amount(amount).fromCurreny(fromCurrency).toCurrency(toCurrency).build();
        double convertedAmount = exchangeRateService.getExchangeRate(exchangeRateDTO);
        return ResponseEntity.ok(convertedAmount);

    }
}