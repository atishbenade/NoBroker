package com.NoBroker.payload;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class OwnerPlanDto {
    @Id
    private Long planId;

    private String planeName;

    private double price;

    private int planeValidity;

    private boolean relationShipManager;

    private boolean rentalAgreement;

    private boolean propertyPromotion;

    private boolean guaranteedTenants;

    private boolean facebookMarketingOfProperty;
}
