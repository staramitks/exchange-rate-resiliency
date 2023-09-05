package home.amit.exchange.app.controller;
/*
User :- AmitSingh
Date :- 8/23/2023
Time :- 5:32 PM
Year :- 2023
*/

import home.amit.exchange.app.dto.ShoppingItem;
import home.amit.exchange.app.service.ShoppingCart;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ShoppingController {

    @Autowired
    private ShoppingCart shoppingCart;

    @GetMapping("/shopping")
    public ResponseEntity<String> addItems(HttpServletRequest request)
    {

        shoppingCart.addItem( ShoppingItem.builder().productName("Banana").qty(12).build());
        return ResponseEntity.ok("Item added count is "+shoppingCart.shoppingSize());
    }
}
