package com.corporate.onlinesponsoredads.repository;

        import com.corporate.onlinesponsoredads.entity.CampaignEntity;
        import org.springframework.data.repository.CrudRepository;

public interface CampaignRepository extends CrudRepository<CampaignEntity, Long> {
         // @Query("SELECT t FROM CampaignEntity t ORDER BY t.bid DESC")
         CampaignEntity findTopByOrderByBidDesc();
         // CampaignEntity findFirstByBid
         //  CampaignEntity findFirstByStartingDate
}
