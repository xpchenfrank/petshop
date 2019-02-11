package com.shopping.petshop.home;

import com.shopping.petshop.config.ShopConstant;
import com.shopping.petshop.interceptors.ShopRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    @Autowired
    private HomeBannerDAO bannerDAO;
    @Autowired
    private HomeRecommendDAO recommendDAO;
    @Autowired
    private ShopRequestContext shopRequestContext;

    /**
     * 获得店铺所有banner
     * @return
     */
    public List<HomeBanner> getAllBanner() {
        return bannerDAO.findAllByShopId(shopRequestContext.getShopId());
    }

    /**
     * 获得店铺所有首页推荐
     * @return
     */
    public List<HomeRecommend> getAllRecommend() {
        return recommendDAO.findAllByShopId(shopRequestContext.getShopId());
    }

    /**
     * 获得所有当前需要显示的banner
     * @return
     */
    public List<HomeBanner> getNowBanner() {
        return bannerDAO.findAllEffectNowByShopId(shopRequestContext.getShopId());
    }

    /**
     * 获得所有当前需要显示的首页推荐
     * @return
     */
    public List<HomeRecommend> getNowRecommend() {
        return recommendDAO.findAllEffectNowByShopId(shopRequestContext.getShopId());
    }

}
