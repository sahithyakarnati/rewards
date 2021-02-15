package com.rewards.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="PURCHASE_MODEL")
public class PurchaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "purchase_info")
    private String purchaseInfo;
    @Column(name = "price")
    private Float price;
    @Column(name = "purchase_date")
    private Date purchaseDate;
    @Column(name = "rewards_earned")
    private Long rewardsEarned;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPurchaseInfo() {
        return purchaseInfo;
    }

    public void setPurchaseInfo(String purchaseInfo) {
        this.purchaseInfo = purchaseInfo;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date date) {
        this.purchaseDate = date;
    }

    public Long getRewardsEarned() {
        return rewardsEarned;
    }

    public void setRewardsEarned(Long rewardsEarned) {
        this.rewardsEarned = rewardsEarned;
    }
}
