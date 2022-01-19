package com.example.demo.dto;

import com.example.demo.model.CouponCode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import net.bytebuddy.utility.RandomString;

import java.time.LocalDateTime;
import java.util.Random;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
public class CouponCodeDTO extends ErrorMessage {
    private String id;
    private String codeName;
//    @JsonIgnore
//    @JsonIgnoreProperties(value = "code")
    private String code;
    private LocalDateTime effectiveFrom;
    private LocalDateTime effectiveTo;
    private Boolean status;
    private String description;
    private String email;

    public CouponCodeDTO(String code, String name) {
        this.setErrorCode(code);
        this.setMessage(name);
    }

    public CouponCodeDTO() {

        this.email = email;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String randomAlphaNumeric = "";
        char[] alpha = new char[3];
        Random random = new Random();
        for(int i=0;i<3; i++){
            alpha[i]=characters.charAt(random.nextInt(characters.length()));
        }
        String numbers="0123456789";
        char[] numeric= new char[3];
        for(int i=0;i<3;i++){
            numeric[i]=numbers.charAt(random.nextInt(numbers.length()));
        }
        for(int i=0;i<3;i++){
            randomAlphaNumeric+=alpha[i];
        }
        for (int i=0;i<3;i++){
            randomAlphaNumeric+=numeric[i];
        }
        this.code=randomAlphaNumeric;

    }


    public CouponCodeDTO(CouponCode couponCode) {
        this.id = couponCode.getId();
        this.codeName = couponCode.getCodeName();
        this.code = couponCode.getCode();
        this.effectiveFrom = couponCode.getEffectiveFrom();
        this.effectiveTo = couponCode.getEffectiveTo();
        this.status = couponCode.getStatus();
        this.description = couponCode.getDescription();
        this.email = couponCode.getEmail();

    }

}
