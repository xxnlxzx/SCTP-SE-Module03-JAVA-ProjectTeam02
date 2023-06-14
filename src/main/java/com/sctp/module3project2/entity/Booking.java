package com.sctp.module3project2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// Joel

@Entity
@Table(name = "Booking")
public class Booking {
    
    @Id
    @Column(name = "id", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "Vessel")
    private Vessel vessel;

    @OneToOne(mappedBy = "berth")
    private Berth berth;

    @OneToOne(mappedBy = "ShippingRoute")
    private ShippingRoute shippingRoute;

    @OneToOne(mappedBy = "DateTime")
    private DateTime dateTime;

    @Column(name = "created_at", nullable=false)
    private Date created_at;

    @Column(name = "activity" , nullable=false)
    private String activity;

    @Column(name = "remarks")
    private String remarks;

}
