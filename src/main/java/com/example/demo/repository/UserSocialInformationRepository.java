package com.example.demo.repository;

import com.example.demo.entity.UserSocialInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSocialInformationRepository extends JpaRepository<UserSocialInformation, Long> {
    Page<UserSocialInformation> findAll(Pageable pageable);
}