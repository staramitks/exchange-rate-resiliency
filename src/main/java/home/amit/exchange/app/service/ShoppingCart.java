package home.amit.exchange.app.service;
/*
User :- AmitSingh
Date :- 8/23/2023
Time :- 5:24 PM
Year :- 2023
*/

import home.amit.exchange.app.dto.ShoppingItem;

public interface ShoppingCart {

    boolean removeItem(ShoppingItem item);
    boolean addItem(ShoppingItem item);
    Integer shoppingSize();
}
