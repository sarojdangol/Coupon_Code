package com.example.demo.dto;

import com.example.demo.model.CouponCode;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CouponCodeDTO {
    private int id;
    private String codeName;
    private String code;
    private Date effectiveFrom;
    private Date effectiveTo;
    private Boolean status;
    private String description;

public CouponCodeDTO(CouponCode couponCode){
    this.id= couponCode.getId();
    this.codeName= couponCode.getCodeName();
    this.code= couponCode.getCode();
    this.effectiveFrom= couponCode.getEffectiveFrom();
    this.effectiveTo= couponCode.getEffectiveTo();
    this.status =couponCode.getStatus();
    this.description =couponCode.getDescription();

}

}
