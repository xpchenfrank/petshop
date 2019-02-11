package com.shopping.petshop.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface HomeRecommendDAO extends JpaRepository<HomeRecommend, Long> {

    List<HomeRecommend> findAllByShopId(long shopId);

    /**
     * 当前有效的所有首页推荐
     * @param shopId
     * @return
     */
    @Query(value = "from HomeRecommend where shopId = :shopId " +
            "and (startTime is null or startTime <= current_date) " +
            "and (endTime is null or endTime >= current_date) ")
    List<HomeRecommend> findAllEffectNowByShopId(long shopId);

}
