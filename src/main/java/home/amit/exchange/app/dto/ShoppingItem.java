package home.amit.exchange.app.dto;
/*
User :- AmitSingh
Date :- 8/23/2023
Time :- 5:23 PM
Year :- 2023
*/

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShoppingItem {

    private String productName;
    private Integer qty;

}
