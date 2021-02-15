package com.rewards.demo.service;


import com.rewards.demo.model.GenerateReportRequest;
import com.rewards.demo.model.GenerateReportResponse;
import com.rewards.demo.model.PurchaseInfo;
import com.rewards.demo.model.PurchaseModel;
import com.rewards.demo.repository.PurchaseRewardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseInfoService {

    @Autowired
    PurchaseRewardsRepository purchaseRewardsRepository;

    public PurchaseModel savePurchaseInfo(PurchaseInfo purchaseInfo){
        PurchaseModel purchaseModel = new PurchaseModel();

        Date date = formatDate(purchaseInfo.getDate());
        purchaseModel.setPurchaseDate(date);
        purchaseModel.setUserId(purchaseInfo.getUserId());
        purchaseModel.setPurchaseInfo(purchaseInfo.getPurchaseInfo());
        purchaseModel.setPrice(purchaseInfo.getPrice());

        if(purchaseInfo.getPrice() <= 100){
            long rewards = Float.valueOf(purchaseInfo.getPrice() - 50).longValue();
            if(rewards <= 0){
                purchaseModel.setRewardsEarned(0l);
            }else {
                purchaseModel.setRewardsEarned(rewards);
            }
        }
        if(purchaseInfo.getPrice() > 100){
            long rewards = Float.valueOf((2*(purchaseInfo.getPrice().longValue() - 100) + 1 * 50)).longValue();
            purchaseModel.setRewardsEarned(rewards);
        }
        return purchaseRewardsRepository.save(purchaseModel);

    }

    private Date formatDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date formattedDate;
        try {
            formattedDate = dateFormat.parse(date);
            System.out.println(date.toString()); // Wed Dec 04 00:00:00 CST 2013

            return formattedDate;
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GenerateReportResponse generateReport(GenerateReportRequest reportRequest) {

        Date fromDate = formatDate(reportRequest.getFromDate());
        Date toDate = formatDate(reportRequest.getToDate());
        List<PurchaseModel> rewards = purchaseRewardsRepository.fetchRewards(fromDate, toDate, reportRequest.getUserId());
        long totalRewards = 0;
        for(PurchaseModel pm: rewards){
            totalRewards = totalRewards+pm.getRewardsEarned();
        }

        System.out.println("Rewards earned are "+rewards);
        GenerateReportResponse response = new GenerateReportResponse();
        response.setPurchasesMade(rewards);
        response.setTotalRewardsEarned(totalRewards);
        return response;
    }
}
