package com.corporate.onlinesponsoredads.services.impl;
import com.corporate.onlinesponsoredads.converter.CampaignConverter;
import com.corporate.onlinesponsoredads.dto.CampaignDTO;
import com.corporate.onlinesponsoredads.entity.CampaignEntity;
import com.corporate.onlinesponsoredads.repository.CampaignRepository;
import com.corporate.onlinesponsoredads.services.CampaignService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    private CampaignConverter campaignConverter;

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public CampaignDTO saveCampaign(CampaignDTO campaignDTO) {
        // Check Campaign name is unique
        // TODO !!!

        CampaignEntity sample = new CampaignEntity();
        sample.setName(campaignDTO.getName());
        Date currentDateTime = new Date();
        campaignDTO.setStartingDate(currentDateTime);
        CampaignEntity campaignEntity = campaignConverter.convertDTOtoEntity(campaignDTO);
        campaignEntity = campaignRepository.save(campaignEntity);
        CampaignDTO dto = campaignConverter.convertEntitytoDTO(campaignEntity);
        return dto;
    }

    @Override
    public List<CampaignDTO> getAllCampaigns() {
        List<CampaignEntity> all = (List<CampaignEntity>) campaignRepository.findAll();
        List<CampaignDTO> relevant = new ArrayList<CampaignDTO>();
        // Convert
        for (CampaignEntity ce : all) {
            CampaignDTO dto = campaignConverter.convertEntitytoDTO(ce);
            relevant.add(dto);
        }
        return relevant;
    }

    @Override
    public CampaignDTO getCampaignWithHighestBid() throws Exception {
        // Get the highest Campaign available
        var campaignEntity = campaignRepository.findTopByOrderByBidDesc();
        if (campaignEntity == null) {
            throw new Exception("NO CAMPAIGNS AVAILABLE!");
        }
        return campaignConverter.convertEntitytoDTO(campaignEntity);
    }

    @Override
    public CampaignDTO getCampaignByName(String name) throws Exception {
        var campaignEntity = campaignRepository.findFirstByName(name);
        if (campaignEntity == null) {
            return null;
        }
        return campaignConverter.convertEntitytoDTO(campaignEntity);
    }
}
