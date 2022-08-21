package com.corporate.onlinesponsoredads.services;
import com.corporate.onlinesponsoredads.dto.CampaignDTO;
import java.util.List;

public interface CampaignService {
    CampaignDTO saveCampaign(CampaignDTO campaignDTO);
    List<CampaignDTO> getAllCampaigns();
    CampaignDTO getCampaignWithHighestBid();
}
