package com.example.demo.repository;

import com.example.demo.model.CouponCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponCodeRepository extends JpaRepository<CouponCode,Integer> {

}
