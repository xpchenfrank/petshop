package com.shopping.petshop.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HomeBannerDAO extends JpaRepository<HomeBanner, Long> {

    List<HomeBanner> findAllByShopId(long shopId);

    /**
     * 当前有效的活动banner
     * @param shopId
     * @return
     */
    @Query(value = "from HomeBanner where shopId = :shopId " +
            "and (startTime is null or startTime <= current_date) " +
            "and (endTime is null or endTime >= current_date) ")
    List<HomeBanner> findAllEffectNowByShopId(long shopId);

}
