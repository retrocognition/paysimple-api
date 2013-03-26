package com.retro.paysimple.core;


/**
 * paysimple address object
 * 
 * <tt>{
        "StreetAddress1": "123 Simple Street",
        "StreetAddress2": null,
        "City": "Denver",
        "StateCode": "CO",
        "ZipCode": "80202",
        "Country": "US"
    }</tt>
 * @author mark@retrocognition.us
 *
 */
public class Address extends PaySimpleObject {
    // serializable
    private static final long serialVersionUID = 894006862497333627L;
    
    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private String stateCode;
    private String zipCode;
    private String country;
    
    public String getStreetAddress1() {
        return streetAddress1;
    }
    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }
    public String getStreetAddress2() {
        return streetAddress2;
    }
    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStateCode() {
        return stateCode;
    }
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
