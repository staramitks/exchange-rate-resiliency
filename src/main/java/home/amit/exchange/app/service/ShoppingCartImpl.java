package home.amit.exchange.app.service;
/*
User :- AmitSingh
Date :- 8/23/2023
Time :- 5:25 PM
Year :- 2023
*/

import home.amit.exchange.app.dto.ShoppingItem;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("shoppingCart")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartImpl implements  ShoppingCart{

    private List<ShoppingItem> shoppingCart=new ArrayList<>();


    @Override
    public boolean removeItem(ShoppingItem item) {
        shoppingCart.remove(  ShoppingItem.builder().productName("Banana").qty(12).build());
        return true;
    }

    @Override
    public boolean addItem(ShoppingItem item) {
        shoppingCart.add(item );
        System.out.println("Size is "+shoppingCart.size());
        return  true;
    }

    @Override
    public Integer shoppingSize() {
        return shoppingCart.size();
    }
}
