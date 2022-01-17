package com.example.demo.services.impl;

import com.example.demo.view.CouponCodeDTO;
import com.example.demo.model.CouponCode;
import com.example.demo.repository.CouponCodeRepository;
import com.example.demo.services.CouponCodeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CouponCodeServicesImpl implements CouponCodeServices {

    @Autowired
    private CouponCodeRepository couponCodeRepository;

    @Override
    public CouponCodeDTO addCouponCode(CouponCodeDTO couponCodeDTO)  {

        CouponCode couponCode = new CouponCode(couponCodeDTO);
        CouponCode savedCode = couponCodeRepository.save(couponCode);
        CouponCodeDTO savedCouponCodeDTO = new CouponCodeDTO(savedCode);
        return savedCouponCodeDTO;
    }
    //        if(couponCodeDTO.getEffectiveFrom().isAfter(couponCodeDTO.getEffectiveTo())){
//            throw new Exception();
//        }
//new function
    //set couponcode.set();
    //        if(couponCodeDTO.getEffectiveFrom().isAfter(couponCodeDTO.getEffectiveTo())){
//            throw new Exception();
//        }
//        if(){
//
//        }
;

    @Override
    public CouponCodeDTO updateCouponCode(CouponCodeDTO couponCodeDTO) {
        CouponCode couponCode = new CouponCode(couponCodeDTO);
        CouponCode updatedCoupon = couponCodeRepository.save(couponCode);
        CouponCodeDTO updatedCouponCodeDTO = new CouponCodeDTO(updatedCoupon);
        return updatedCouponCodeDTO;
    }

    @Override
    public List<CouponCodeDTO> findAll() {
        List<CouponCode> couponCodes = couponCodeRepository.findAll();
        List<CouponCodeDTO> couponCodeDTOS = new ArrayList<>();
        for (CouponCode couponCode : couponCodes) {
            CouponCodeDTO couponCodeDTO = new CouponCodeDTO(couponCode);
            couponCodeDTOS.add(couponCodeDTO);

        }
        return couponCodeDTOS;

    }

    @Override
    public Boolean setActivate(CouponCodeDTO couponCodeDTO) {
        return true;
    }

    @Override
    public List<CouponCodeDTO> findByStatus(Boolean status) {

            List<CouponCode> couponCodes = couponCodeRepository.findAll();
            List<CouponCodeDTO> couponCodeDTOS = new ArrayList<>();
            for (CouponCode couponCode : couponCodes) {
                if (couponCode.getStatus().equals(status)) {
                CouponCodeDTO couponCodeDTO = new CouponCodeDTO(couponCode);
                couponCodeDTOS.add(couponCodeDTO);

            }
        }
        return couponCodeDTOS;
    }
}

