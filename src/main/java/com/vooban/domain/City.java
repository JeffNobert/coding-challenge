package com.vooban.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by jnobert on 2016-11-23.
 */
@Entity
@Table(name = "Cities")
public class City implements Comparable<City>
{

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

    @Transient
    private float score;

    private City() { }

    public City(int id)
    {
        this.id = id;
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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }


    public String getFullName()
    {
        return this.getName() + ", " + this.getStateprov() + ", " + this.getCountry();
    }

    @Override
    public int compareTo(City city) {
        return this.getScore() < city.getScore() ? -1
                : this.getScore() > city.getScore() ? 1
                : 0;
    }
}
