package com.fiberhome.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "TEST_CUSTOMER")
public class Customer {


    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "TEST_CUST_SEQ")
    @SequenceGenerator(sequenceName = "test_customer_seq",allocationSize = 1,name = "TEST_CUST_SEQ")
    @Id
    private int id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String email;

    @Column
    private String city;

    public Customer(){

    }

    public Customer(List list) {
//        this.id = (Integer) list.get(0);
        this.name = String.valueOf(list.get(0));
        this.email = String.valueOf(list.get(1));
        this.city = String.valueOf(list.get(2));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
