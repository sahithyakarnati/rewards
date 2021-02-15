package com.rewards.demo.web;


import com.rewards.demo.model.GenerateReportRequest;
import com.rewards.demo.model.GenerateReportResponse;
import com.rewards.demo.model.PurchaseInfo;
import com.rewards.demo.model.PurchaseModel;
import com.rewards.demo.service.PurchaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RewardController {

    @Autowired
    PurchaseInfoService purchaseInfoService;

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseModel> purchase(@RequestBody PurchaseInfo purchaseInfo){
        PurchaseModel response = purchaseInfoService.savePurchaseInfo(purchaseInfo);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/generateReport")
    public ResponseEntity<GenerateReportResponse> generateReport(@RequestBody GenerateReportRequest reportRequest){
        GenerateReportResponse response = purchaseInfoService.generateReport(reportRequest);
        return ResponseEntity.ok(response);
    }
}
