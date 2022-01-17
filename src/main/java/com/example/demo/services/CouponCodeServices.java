package com.example.demo.services;

import com.example.demo.dto.CouponCodeDTO;

import java.util.List;

public interface CouponCodeServices {
CouponCodeDTO addCouponCode(CouponCodeDTO couponCodeDTO);
CouponCodeDTO updateCouponCode(CouponCodeDTO couponCodeDTO);
List <CouponCodeDTO> findAll();
List <CouponCodeDTO> findByStatus(Boolean status);

Boolean setActivate(CouponCodeDTO couponCodeDTO);

}
