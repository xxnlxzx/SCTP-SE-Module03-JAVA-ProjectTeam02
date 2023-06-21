package com.sctp.module3project2.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


// Updated by Wei Kang
@Entity
@Table(name = "ShippingRoute")
public class ShippingRoute {
    @Id
    @Column(name = "id", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "port")
    @NotBlank(message = "port name is mandatory")
    private String port;

    @Column(name = "date_of_arrival")
    private LocalDate date_of_arrival;

    @Column(name = "purpose_of_travel")
    private String purpose_of_travel;

    @Column(name = "tax_fees_port_expenses")
    private double tax_fees_port_expenses;

    @JsonBackReference
    @ManyToOne(optional = true)
    @JoinColumn(name = "vessel_id", referencedColumnName = "id")
    private Vessel vessel;

    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // @JoinColumn(name = "vessel_id", referencedColumnName = "id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    // @JsonIgnore
    // private Vessel vessel;

    public Vessel getVessel() {
        return vessel;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public LocalDate getDate_of_arrival() {
        return date_of_arrival;
    }

    public void setDate_of_arrival(LocalDate date_of_arrival) {
        this.date_of_arrival = date_of_arrival;
    }

    public String getPurpose_of_travel() {
        return purpose_of_travel;
    }

    public void setPurpose_of_travel(String purpose_of_travel) {
        this.purpose_of_travel = purpose_of_travel;
    }

    public double getTax_fees_port_expenses() {
        return tax_fees_port_expenses;
    }

    public void setTax_fees_port_expenses(double tax_fees_port_expenses) {
        this.tax_fees_port_expenses = tax_fees_port_expenses;
    }

}
