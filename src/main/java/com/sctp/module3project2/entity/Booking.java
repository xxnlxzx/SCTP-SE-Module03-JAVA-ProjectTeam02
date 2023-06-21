package com.sctp.module3project2.entity;

import javax.persistence.CascadeType;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// Joel
// Will wait for other entities to be created first before continuing

@Entity
@Table(name = "Booking")
public class Booking {
    
    @Id
    @Column(name = "id", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_datetime_id", referencedColumnName = "id")
    private BookingDateTime bookingDateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "berth_id", referencedColumnName = "id")
    private Berth berth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vessel_id", referencedColumnName = "id")
    private Vessel vessel;


    // @OneToOne(mappedBy = "ShippingRoute")
    // private ShippingRoute shippingRoute;

   

    @Column(name = "activity" , nullable=false)
    private String activity;

    @Column(name = "remarks")
    private String remarks;

    public Booking() {
    }
    

    public Booking(Long id, BookingDateTime bookingDateTime, Berth berth, String activity, String remarks) {
        this.id = id;
        this.bookingDateTime = bookingDateTime;
        this.berth = berth;
        this.activity = activity;
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vessel getVessel() {
        return vessel;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    // public Berth getBerth() {
    //     return berth;
    // }

    // public void setBerth(Berth berth) {
    //     this.berth = berth;
    // }

    // public ShippingRoute getShippingRoute() {
    //     return shippingRoute;
    // }

    // public void setShippingRoute(ShippingRoute shippingRoute) {
    //     this.shippingRoute = shippingRoute;
    // }

    // public DateTime getDateTime() {
    //     return dateTime;
    // }

    // public void setDateTime(DateTime dateTime) {
    //     this.dateTime = dateTime;
    // }

    // public Date getCreated_at() {
    //     return created_at;
    // }

    // public void setCreated_at(Date created_at) {
    //     this.created_at = created_at;
    // }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BookingDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(BookingDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public Berth getBerth() {
        return berth;
    }

    public void setBerth(Berth berth) {
        this.berth = berth;
    }
    



}
