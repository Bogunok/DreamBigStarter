package com.dreambigproject.dreambigstarter.service;

import java.time.LocalDate;
import java.time.Month;

public class SeasonalDiscountService {

    private final boolean discountsEnabled;

    public SeasonalDiscountService(boolean discountsEnabled) {
        this.discountsEnabled = discountsEnabled;
    }

    public double calculateDiscountedPrice(double originalPrice) {
        if (!discountsEnabled) {
            return originalPrice;
        }

        Month currentMonth = LocalDate.now().getMonth();
        double discount = getMonthlyDiscount(currentMonth);

        return originalPrice * (1 - discount);
    }

    private double getMonthlyDiscount(Month month) {
        switch (month) {
            case FEBRUARY:
                return 0.10;
            case MARCH:
                return 0.05;
            case AUGUST:
                return 0.20;
            case DECEMBER:
                return 0.25;
            default:
                return 0.0;
        }
    }
}