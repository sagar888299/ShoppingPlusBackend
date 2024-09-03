package com.ShoppingPlusBackend.ShoppingPlusBackend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchased_seq")
    @SequenceGenerator(name = "purchased_seq", initialValue = 10000)
    private Long purchasedId;

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "order_id", nullable = false)
    private String orderId;
    
    @Column(name = "price", nullable = false)
    private Long price;
    
    @Column(name = "status", nullable = false)
    private String status;
    
    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "product_name", nullable = false)
    private String productName;
    
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image", nullable = false)
    private String image;
    
    @Column(name = "ordered_date", nullable = false)
    private LocalDate orderedDate;

    @Column(name = "shipping_date", nullable = false)
    private LocalDate shippingDate;


    // Constructors, Getters, and Setters

    public Order() {}

    public Order(Long purchasedId, String customerId, String address, String orderId, String name, String productName,
			String description, String image, LocalDate orderedDate, LocalDate shippingDate, Long quantity, Long price, String status) {
		super();
		this.purchasedId = purchasedId;
		this.customerId = customerId;
		this.address = address;
		this.orderId = orderId;
		this.name = name;
		this.productName = productName;
		this.description = description;
		this.image = image;
		this.orderedDate = orderedDate;
		this.shippingDate = shippingDate;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}


	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getPurchasedId() {
        return purchasedId;
    }

    public void setPurchasedId(Long purchasedId) {
        this.purchasedId = purchasedId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(LocalDate orderedDate) {
        this.orderedDate = orderedDate;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }
}
