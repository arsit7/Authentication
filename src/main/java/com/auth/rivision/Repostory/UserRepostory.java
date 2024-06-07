package com.auth.rivision.Repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.rivision.model.User;

@Repository
public interface UserRepostory extends JpaRepository<User, Long> {

    
	User findByUserName(String userName);
}
