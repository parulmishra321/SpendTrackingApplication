package com.example.SpendTrackingApplication.model;

import com.example.SpendTrackingApplication.entity.ParentEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Document(collection = "purchases")
public class Purchase extends ParentEntity
{
    @Id
    private String purchaseId;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
    private String userId;

//    @OneToMany
//    @JoinColumn(name = "product_id")
    private String productId;

    private String address;

    private String deliveryStatus;

    public Purchase(){
    }

    public Purchase(String purchaseId, String userId, String productId, String address, String deliveryStatus) {
        this.purchaseId = purchaseId;
        this.userId = userId;
        this.productId = productId;
        this.address = address;
        this.deliveryStatus = deliveryStatus;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
