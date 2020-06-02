package com.covid19.covid19info.models;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Summary implements Serializable {

    @JsonProperty("NewConfirmed") private String newConfirmed;
    @JsonProperty("TotalConfirmed") private String totalConfirmed;
    @JsonProperty("NewDeaths") private String newDeaths;
    @JsonProperty("TotalDeaths") private String totalDeaths;
    @JsonProperty("NewRecovered") private String newRecovered;
    @JsonProperty("TotalRecovered") private String totalRecovered;

    public Summary() { }

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
}
