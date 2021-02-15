package com.rewards.demo.repository;

import com.rewards.demo.model.PurchaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PurchaseRewardsRepository
        extends JpaRepository<PurchaseModel, Long> {

    @Query("SELECT pm from PurchaseModel pm where pm.userId=:userId and pm.purchaseDate BETWEEN :fromDate AND :toDate")
    public List<PurchaseModel> fetchRewards(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("userId") String userId);
}
