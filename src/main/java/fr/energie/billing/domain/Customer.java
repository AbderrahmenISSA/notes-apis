package fr.energie.billing.domain;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String reference;

    @OneToOne(mappedBy = "customer")
    private Person person;

    @OneToOne(mappedBy = "customer")
    private Business business;

    @OneToMany(mappedBy = "customer")
    private Set<ElectricityConsumptionDetail> customerElectricityConsumptionDetails;

    @OneToMany(mappedBy = "customer")
    private Set<GazConsumptionDetail> customerGazConsumptionDetails;

    @OneToMany(mappedBy = "customer")
    private Set<Bill> customerBills;

}
