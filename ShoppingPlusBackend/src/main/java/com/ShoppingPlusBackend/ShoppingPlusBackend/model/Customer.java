package com.ShoppingPlusBackend.ShoppingPlusBackend.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "email" ,unique = true)
    private String email;
    
    @Column(name = "locality")
    private String locality;
    
    @Column(name = "image")
    private String image;

    @Column(name = "pin_code")
    private String pinCode;

    // Getters and setters

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String phoneNumber, String name, String addressLine1, String addressLine2, String city,
			String state, String email, String locality, String image, String pinCode, String gender) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.email = email;
		this.locality = locality;
		this.image = image;
		this.pinCode = pinCode;
		this.gender = gender;
	}

	public Customer(String phoneNumber2, String name2) {
		// TODO Auto-generated constructor stub
	}

	public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
    
}
