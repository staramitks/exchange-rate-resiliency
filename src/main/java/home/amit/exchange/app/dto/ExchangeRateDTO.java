package home.amit.exchange.app.dto;
/*
User :- AmitSingh
Date :- 8/18/2023
Time :- 8:14 PM
Year :- 2023
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExchangeRateDTO {
    private String fromCurreny;
    private String toCurrency;
    private Date exchangeDate;
    private Double rate;
    private double exchangedAmount;
    private double amount;

}
