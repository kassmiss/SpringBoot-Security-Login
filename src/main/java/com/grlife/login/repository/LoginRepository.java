package com.grlife.login.repository;

import com.grlife.login.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<UserInfo, Long> {


}
