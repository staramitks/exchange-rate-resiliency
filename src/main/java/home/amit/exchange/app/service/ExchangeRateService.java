package home.amit.exchange.app.service;

import home.amit.exchange.app.dto.ExchangeRateDTO;

import java.util.Map;

/*
User :- AmitSingh
Date :- 8/18/2023
Time :- 8:13 PM
Year :- 2023
*/

public interface ExchangeRateService {

    Map<String, Double> getExchangeRates();
    Double getExchangeRate(ExchangeRateDTO exchangeRateDTO);
}
