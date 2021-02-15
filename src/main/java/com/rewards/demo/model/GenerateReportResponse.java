package com.rewards.demo.model;

import java.util.ArrayList;
import java.util.List;

public class GenerateReportResponse {
    private List<PurchaseModel> purchasesMade = new ArrayList<>();
    private Long totalRewardsEarned;

    public List<PurchaseModel> getPurchasesMade() {
        return purchasesMade;
    }

    public void setPurchasesMade(List<PurchaseModel> purchaseModelList) {
        this.purchasesMade = purchaseModelList;
    }

    public Long getTotalRewardsEarned() {
        return totalRewardsEarned;
    }

    public void setTotalRewardsEarned(Long totalRewardsEarned) {
        this.totalRewardsEarned = totalRewardsEarned;
    }
}
