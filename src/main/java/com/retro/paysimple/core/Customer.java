package com.retro.paysimple.core;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * {
        "MiddleName": null,
        "AltEmail": null,
        "AltPhone": null,
        "MobilePhone": null,
        "Fax": null,
        "Website": null,
        "BillingAddress": {
            "StreetAddress1": "123 Simple Street",
            "StreetAddress2": null,
            "City": "Denver",
            "StateCode": "CO",
            "ZipCode": "80202",
            "Country": "US"
        },
        "ShippingSameAsBilling": true,
        "ShippingAddress": null,
        "Company": null,
        "Notes": null,
        "FirstName": "Tom",
        "LastName": "Simple",
        "Email": "tsimple@paysimple.com",
        "Phone": "3216549870",
        "Id": 0
}

 * @author mark@retrocognition.us
 *
 */
public class Customer extends PaySimpleObject {
    // serializable
    private static final long serialVersionUID = -1406486204016987436L;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String altEmail;
    private String phone;
    private String mobilePhone;
    private String altPhone;
    private String fax;
    private String company;
    private String notes;
    private String website;
    @JsonSerialize(as=Address.class)
    private Address billingAddress;
    @JsonSerialize(as=Address.class)
    private Address shippingAddress;
    private Boolean shippingSameAsBilling;
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAltEmail() {
        return altEmail;
    }
    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public String getAltPhone() {
        return altPhone;
    }
    public void setAltPhone(String altPhone) {
        this.altPhone = altPhone;
    }
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public Address getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
    public Address getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public Boolean getShippingSameAsBilling() {
        return shippingSameAsBilling;
    }
    public void setShippingSameAsBilling(Boolean shippingSameAsBilling) {
        this.shippingSameAsBilling = shippingSameAsBilling;
    }
}
