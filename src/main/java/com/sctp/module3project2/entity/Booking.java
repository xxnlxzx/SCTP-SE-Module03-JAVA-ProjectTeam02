package com.sctp.module3project2.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "bookings")
public class Booking{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String vessel;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "datetime_id", referencedColumnName = "id")
  private BookingDateTime datetime;


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public String getVessel() {
    return vessel;
  }


  public void setVessel(String vessel) {
    this.vessel = vessel;
  }


  public BookingDateTime getDatetime() {
    return datetime;
  }


  public void setDatetime(BookingDateTime datetime) {
    this.datetime = datetime;
  }


  public Booking(Long id, String vessel, BookingDateTime datetime) {
    super();
    this.id = id;
    this.vessel = vessel;
    this.datetime = datetime;
  }


  public Booking() {}
}
