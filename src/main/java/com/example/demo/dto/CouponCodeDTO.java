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
    private String code;
    private String code1;
    private LocalDateTime effectiveFrom;
    private LocalDateTime effectiveTo;
    private Boolean status;
    private String description;
    private String email;
    private String url;

    public CouponCodeDTO(String code, String name) {
        this.setErrorCode(code);
        this.setMessage(name);
    }

    public CouponCodeDTO() {
//        this.code=generateAlphaNumeric(6);
        this.code = generateCode();
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public void setCode(String code) {
//        this.code = generateAlphaNumeric(6);
        this.code = generateCode();
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public void setEffectiveFrom(LocalDateTime effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public void setEffectiveTo(LocalDateTime effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CouponCodeDTO(CouponCode couponCode) {
        this.id = couponCode.getId();
        this.codeName = couponCode.getCodeName();
        this.code = couponCode.getCode();
        this.code1 = couponCode.getCode1();
        this.effectiveFrom = couponCode.getEffectiveFrom();
        this.effectiveTo = couponCode.getEffectiveTo();
        this.status = couponCode.getStatus();
        this.description = couponCode.getDescription();
        this.email = couponCode.getEmail();
        this.url = couponCode.getUrl();

    }

    public static String generateAlphaNumeric(int length) {
        int leftLimit = 48;
        int rightLimit = 122;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String generateCode() {
        this.email = email;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String randomAlphaNumeric = "";
        char[] alpha = new char[3];
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            alpha[i] = characters.charAt(random.nextInt(characters.length()));
        }
        String numbers = "0123456789";
        char[] numeric = new char[3];
        for (int i = 0; i < 3; i++) {
            numeric[i] = numbers.charAt(random.nextInt(numbers.length()));
        }
        for (int i = 0; i < 3; i++) {
            randomAlphaNumeric += alpha[i];
        }
        for (int i = 0; i < 3; i++) {
            randomAlphaNumeric += numeric[i];
        }
        return randomAlphaNumeric;
    }

}
