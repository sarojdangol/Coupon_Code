package com.example.demo.services.impl;

import com.example.demo.dto.CouponCodeDTO;
import com.example.demo.model.CouponCode;
import com.example.demo.repository.CouponCodeRepository;
import com.example.demo.services.CouponCodeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CouponCodeServicesImpl implements CouponCodeServices {

    @Autowired
    private CouponCodeRepository couponCodeRepository;

    @Override
    public CouponCodeDTO addCouponCode(CouponCodeDTO couponCodeDTO) {

        CouponCodeDTO savedCouponCodeDTO = null;
        if (couponCodeDTO.getEffectiveFrom().isAfter(couponCodeDTO.getEffectiveTo())) {
            System.out.println("Cannot add this.");
            return new CouponCodeDTO("001", "You are not authorized");
        } else {

            CouponCode couponCode = new CouponCode(couponCodeDTO);
            CouponCode savedCode = couponCodeRepository.save(couponCode);
            savedCouponCodeDTO = new CouponCodeDTO(savedCode);
            return savedCouponCodeDTO;
        }


    }


    @Override
    public CouponCodeDTO updateCouponCode(CouponCodeDTO couponCodeDTO) {
        CouponCode couponCode = new CouponCode(couponCodeDTO);
        CouponCode updatedCoupon = couponCodeRepository.save(couponCode);
        CouponCodeDTO updatedCouponCodeDTO = new CouponCodeDTO(updatedCoupon);
        return updatedCouponCodeDTO;
    }

    @Override
    public List<CouponCodeDTO> findAll() {
        List<CouponCode> couponCodes = couponCodeRepository.fetchAll();//query
//        couponCodeRepository.findById(1);
        //effective from to effect to active list
        List<CouponCodeDTO> couponCodeDTOS = new ArrayList<>();
        couponCodes.forEach(couponCode -> {
            CouponCodeDTO couponCodeDTO = new CouponCodeDTO(couponCode);
            couponCodeDTOS.add(couponCodeDTO);
        });
        return couponCodeDTOS;
//        for (CouponCode couponCode : couponCodes) {
//            CouponCodeDTO couponCodeDTO = new CouponCodeDTO(couponCode);
//            couponCodeDTOS.add(couponCodeDTO);
//
//        }


    }

    @Override
    public Optional<CouponCode> findById(int id) {

        Optional<CouponCode> couponCodeOptional = couponCodeRepository.fetchById(id);
        if (couponCodeOptional.isEmpty()) {
            return null;
        } else {
            return couponCodeRepository.fetchById(id);
        }
    }


    @Override
    public List<CouponCodeDTO> findByStatus(Boolean status) {

        List<CouponCode> couponCodes = couponCodeRepository.fetchAll();
        List<CouponCodeDTO> couponCodeDTOS = new ArrayList<>();
        for (CouponCode couponCode : couponCodes) {
            if (couponCode.getStatus().equals(status)) {
                CouponCodeDTO couponCodeDTO = new CouponCodeDTO(couponCode);
                couponCodeDTOS.add(couponCodeDTO);

            }
        }

        return couponCodeDTOS;
    }

    @Override
    public List<CouponCodeDTO> findActiveList() {
CouponCodeDTO dateTime=new CouponCodeDTO();
        List<CouponCode> couponCodes = couponCodeRepository.findActiveList(dateTime.getEffectiveFrom(),dateTime.getEffectiveTo());
        List<CouponCodeDTO> couponCodeDTOS = new ArrayList<>();
//        LocalDateTime date = LocalDateTime.now();
        couponCodes.forEach(couponCode -> {
            CouponCodeDTO couponCodeDTO = new CouponCodeDTO(couponCode);
//            if (couponCodeDTO.getEffectiveFrom().isBefore(date) && couponCodeDTO.getEffectiveTo().isAfter(date)) {
                couponCodeDTOS.add(couponCodeDTO);
//            }
        });

        return couponCodeDTOS;
    }


}

