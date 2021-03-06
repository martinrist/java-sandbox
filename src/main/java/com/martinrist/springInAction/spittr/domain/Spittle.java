package com.martinrist.springInAction.spittr.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Date;

/**
 * Domain object that represents a 'Spittle', a message with an id, timestamp
 * and location (in the form of a latitude and longitude.
 */
public class Spittle {

    private Long id;
    private String message;
    private Date time;
    private Double latitude;
    private Double longitude;

    public Spittle() {}

    public Spittle(String message, Date time) {
        this(null, message, time);
    }

    public Spittle(Long id, String message, Date time) {
        this(id, message, time, 0.0, 0.0);
    }

    public Spittle(Long id, String message, Date time, Double latitude, Double longitude) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, new String[] {"id", "time"});
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, new String[] {"id", "time"});
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

