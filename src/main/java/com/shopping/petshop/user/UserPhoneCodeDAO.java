package com.shopping.petshop.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPhoneCodeDAO extends JpaRepository<UserPhoneCode, Long> {

    Optional<UserPhoneCode> findByPhone(String phone);

}
