package com.snowflex.snowflack.service;

import com.snowflex.snowflack.dto.Purchase;
import com.snowflex.snowflack.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder (Purchase purchase);
}
