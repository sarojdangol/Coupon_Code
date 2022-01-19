package com.example.demo.services;

import com.example.demo.dto.CouponCodeDTO;
import com.example.demo.model.CouponCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CouponCodeServices {
CouponCodeDTO addCouponCode(CouponCodeDTO couponCodeDTO);
CouponCodeDTO updateCouponCode(CouponCodeDTO couponCodeDTO);
List <CouponCodeDTO> findAll();
List <CouponCodeDTO> findByStatus(Boolean status);
Optional<CouponCode> findById(int id);
List<CouponCodeDTO> findActiveList();

}
