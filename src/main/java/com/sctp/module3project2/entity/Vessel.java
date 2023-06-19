package com.sctp.module3project2.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
// Updated by Afif
@Entity
@Table(name = "Vessel")
public class Vessel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Type")
    private String type;
    
    @OneToMany(mappedBy = "vessel")
    private List<ShippingRoute> shippingRoute;

     @OneToOne(mappedBy = "vessel")
    private Booking booking;
    
    public Vessel() {
    }

    


    public Vessel(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }




    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }

      public List<ShippingRoute> getShippingRoute() {
        return shippingRoute;
    }

    public void setShippingRoute(List<ShippingRoute> shippingRoute) {
        this.shippingRoute = shippingRoute;
    }
     
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
    
    
   
}

