package com.example.demo.view;

import com.example.demo.model.CouponCode;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CouponCodeDTO extends  ErrorMessage {
    private int id;
    private String codeName;
    private String code;
    private LocalDateTime effectiveFrom;
    private LocalDateTime effectiveTo;
    private Boolean status;
    private String description;

    public CouponCodeDTO(String code,String name){
        this.setErrorCode(code);
        this.setMessage(name);
    }
public CouponCodeDTO(CouponCode couponCode){
    this.id= couponCode.getId();
    this.codeName= couponCode.getCodeName();
    this.code= couponCode.getCode();
//    if(couponCode.getEffectiveFrom().isBefore(couponCode.getEffectiveTo())){
        this.effectiveFrom=couponCode.getEffectiveFrom();
//    }
   this.effectiveTo=couponCode.getEffectiveTo();
    this.status =couponCode.getStatus();
    this.description =couponCode.getDescription();

}

}
