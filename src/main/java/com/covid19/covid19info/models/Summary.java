package com.covid19.covid19info.models;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
public class Summary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("NewConfirmed")
    private String newConfirmed;

    @JsonProperty("TotalConfirmed")
    private String totalConfirmed;

    @JsonProperty("NewDeaths")
    private String newDeaths;

    @JsonProperty("TotalDeaths")
    private String totalDeaths;

    @JsonProperty("NewRecovered")
    private String newRecovered;

    @JsonProperty("TotalRecovered")
    private String totalRecovered;

    private final String date;

    public Summary() {
        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date d = new Date(System.currentTimeMillis());
        date = formatter.format(d);
    }

    public String getNewConfirmed() {
        return newConfirmed;
    }

    public void setNewConfirmed(String newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public String getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public String getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        this.newDeaths = newDeaths;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(String newRecovered) {
        this.newRecovered = newRecovered;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }
}
