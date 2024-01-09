package com.NoBroker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "owner_plans")
public class OwnerPlan {
    @Id
    private Long planId;

    @Column(name = "plane_name",unique = true)
    private String planeName;

    @Column(name = "price")
    private double price;

    @Column(name = "plane_validity")
    private int planeValidity;

    @Column(name = "relationship_manager")
    private boolean relationShipManager;

    @Column(name = "rental_agreement")
    private boolean rentalAgreement;

    @Column(name = "property_promotion")
    private boolean propertyPromotion;

    @Column(name = "guaranteed_tenants")
    private boolean guaranteedTenants;

    @Column(name = "facebook_marketing")
    private boolean facebookMarketingOfProperty;
}
