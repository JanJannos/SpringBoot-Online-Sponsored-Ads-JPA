package com.corporate.onlinesponsoredads.controller;

import com.corporate.onlinesponsoredads.dto.CampaignDTO;
import com.corporate.onlinesponsoredads.dto.ProductDTO;
import com.corporate.onlinesponsoredads.services.CampaignService;
import com.corporate.onlinesponsoredads.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    @PostMapping("/campaigns")
    public ResponseEntity<CampaignDTO> saveCampaign(@RequestBody CampaignDTO campaignDTO) {
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
    public List<ProductDTO> serveAds(@RequestParam("category") String category) {
        // loop on all the campaigns
//        List<CampaignDTO> listCampaignDTO = campaignService.getAllCampaigns();
//        System.out.println("$$$$$$$$$$$$$$$$$$$$$$ ===============>>>> : " + listCampaignDTO.size());
//        List<ProductDTO> listOfProducts = productService.getAllProducts();
//        List<ProductDTO> productsList = listOfProducts.stream().filter(p -> p.getCategory().toLowerCase() == category.toLowerCase()).collect(Collectors.toList());
//        return productsList;

        var camp = campaignService.getCampaignWithHighestBid();
        System.out.println("$$$$$$$$$$$$$$$$$ ==============>>>>> Filtered ======>>> " + camp);
        return null;
    }
}
