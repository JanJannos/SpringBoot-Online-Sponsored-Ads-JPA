package com.corporate.onlinesponsoredads.repository;

        import com.corporate.onlinesponsoredads.entity.CampaignEntity;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;

        import javax.transaction.Transactional;
        import java.util.List;

public interface CampaignRepository extends CrudRepository<CampaignEntity, Long> {
        // SELECT * FROM CAMPAIGNS_TABLE order by BID DESC LIMIT 1
        // @Query("SELECT t FROM CampaignEntity t ORDER BY t.bid DESC")
        // List<CampaignEntity> findFirstByOrderByBid();
        // @Query("SELECT t FROM CampaignEntity t ORDER BY t.bid DESC")
         CampaignEntity findTopByOrderByBidDesc();
}
