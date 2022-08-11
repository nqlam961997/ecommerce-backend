package com.lam.springbootsecommerce.service;

import com.lam.springbootsecommerce.dto.Purchase;
import com.lam.springbootsecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
