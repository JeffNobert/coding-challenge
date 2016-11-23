package com.vooban.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by jnobert on 2016-11-23.
 */
@Entity
@Table(name = "Cities")
public class City {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @NotNull
    @Column(name = "lat")
    private double latitude;

    @NotNull
    @Column(name = "long")
    private double longitude;

    @NotNull
    private String country;

    @NotNull
    private String stateprov;

    private City() { }

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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStateprov() {
        return stateprov;
    }

    public void setStateprov(String stateprov) {
        this.stateprov = stateprov;
    }
}
