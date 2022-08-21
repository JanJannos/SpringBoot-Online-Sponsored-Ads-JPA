package com.corporate.onlinesponsoredads.controller;

import com.corporate.onlinesponsoredads.dto.CampaignDTO;
import com.corporate.onlinesponsoredads.dto.ProductDTO;
import com.corporate.onlinesponsoredads.services.CampaignService;
import com.corporate.onlinesponsoredads.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/online-sponsored-ads/api/v1")
public class OnlineSponsoredAdsController {
    // http://localhost:8080/online-sponsored-ads/api/v1/health

    @Autowired
    private ProductService productService;

    @Autowired
    private CampaignService campaignService;

    @GetMapping("/health")
    public String SayHello() {
        return "Backend is up!";
    }

    // Handle Campaigns

    @GetMapping("/campaigns")
    public ResponseEntity<List<CampaignDTO>> getAllCampaigns() {
        List<CampaignDTO> allCampaigns = campaignService.getAllCampaigns();
        ResponseEntity<List<CampaignDTO>> res = new ResponseEntity<>(allCampaigns , HttpStatus.OK);
        return res;
    }

    @PostMapping("/campaigns")
    public ResponseEntity<CampaignDTO> saveCampaign(@RequestBody CampaignDTO campaignDTO) throws Exception {
        if (this.campaignService.getCampaignByName(campaignDTO.getName()) != null) {
//            throw new Exception("CAMPAIGN Name already exists!!!");
            throw new IllegalArgumentException("The value is already exists!");
        }
        campaignDTO = campaignService.saveCampaign(campaignDTO);
        ResponseEntity<CampaignDTO> responseEntity = new ResponseEntity<>(campaignDTO , HttpStatus.CREATED);
        return responseEntity; // return 201
    }

    // Handle Products

    @PostMapping("/products")
    public ResponseEntity<ProductDTO> saveProperty(@RequestBody ProductDTO productDTO) {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        productDTO.setSerialNumber(uuidAsString);
        productDTO = productService.saveProduct(productDTO);
        ResponseEntity<ProductDTO> responseEntity = new ResponseEntity<>(productDTO , HttpStatus.CREATED);
        return responseEntity; // return 201
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> listProps = productService.getAllProducts();
        ResponseEntity<List<ProductDTO>> res = new ResponseEntity<>(listProps , HttpStatus.OK);
        return res;
    }

    @GetMapping("/serve-ads")
    public ResponseEntity<ProductDTO> serveAds(@RequestParam("category") String category) throws Exception {
        // get campaign with highest value
        var campaignDTO = campaignService.getCampaignWithHighestBid();
        if (campaignDTO == null) {
            throw new Exception("NO MATCHING PRODUCTS TO CATEGORY!");
        }

        // split to string array of product codes
        var productCodes = campaignDTO.getProductCodes().split(",");
        Long productCode = Long.parseLong(productCodes[0]);

        // Get Product with Highest bid that is listed in the Campaign
        var productBid = productService.getProductByCategoryAndId(category , productCode);
        ResponseEntity<ProductDTO> res = new ResponseEntity<>(productBid , HttpStatus.OK);
        return res;
    }
}
