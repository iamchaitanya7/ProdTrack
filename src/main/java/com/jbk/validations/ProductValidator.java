package com.jbk.validations;

import com.jbk.entity.Product;
import com.jbk.exceptions.InvalidProductException;
import java.time.LocalDate;

public class ProductValidator {

    /*public static void validateProduct(Product product) {
        validateQuantity(product.getProductQuantity());
        validatePrice(product.getProductPrice());
        validateDates(product.getMfgDate(), product.getExpDate());
    }

    public static void validateQuantity(int quantity) {
        if (quantity < 0) {
            throw new InvalidProductException("Product quantity cannot be negative.");
        }
    }

    public static void validatePrice(double price) {
        if (price < 0) {
            throw new InvalidProductException("Product price cannot be negative.");
        }
    }

    public static void validateDates(LocalDate mfgDate, LocalDate expDate) {
        if (mfgDate.isAfter(expDate)) {
            throw new InvalidProductException("Manufacturing date cannot be after expiry date.");
        }
    }*/
}
