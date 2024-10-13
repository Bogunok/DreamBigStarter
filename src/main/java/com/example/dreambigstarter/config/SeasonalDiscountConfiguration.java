package com.example.dreambigstarter.config;

import com.example.dreambigstarter.service.SeasonalDiscountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeasonalDiscountConfiguration {

    @Value("${discounts.enabled:true}")
    private boolean discountsEnabled;

    @Bean
    @ConditionalOnMissingBean
    public SeasonalDiscountService discountService() {
        return new SeasonalDiscountService(discountsEnabled);
    }
}
