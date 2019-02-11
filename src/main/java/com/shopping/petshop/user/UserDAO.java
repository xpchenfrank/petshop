package com.shopping.petshop.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, String> {

    User findUserByName(String name);

}
