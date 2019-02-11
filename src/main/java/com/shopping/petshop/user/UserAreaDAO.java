package com.shopping.petshop.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserAreaDAO extends JpaRepository<UserArea, Long> {

    List<UserArea> findAllByUserId(String userId);

    @Query("from UserArea where userId = :userId and default = true")
    UserArea findDefaultUserArea(String userId);

    /**
     * 把某用户的默认地址标记清空
     * @param userId
     */
    @Query(value = "update UserArea set default = false where userId = :userId")
    void updateToNoDefault(String userId);

}
