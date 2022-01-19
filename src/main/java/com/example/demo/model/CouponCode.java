package com.example.demo.model;

import com.example.demo.dto.CouponCodeDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Random;


@Table(name = "Coupon_Code")
@Entity
@Getter
@NoArgsConstructor
//@AllArgsConstructor
public class CouponCode {
    @Id
//    @GeneratedValue
//    private String id;
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Size
    private String codeName;
    @Size(min = 6, max = 6, message = "Code must be of 6 characters")
    @Pattern(regexp = "[a-zA-Z]{3}[0-9]{3}")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String code;
    @Column(unique=true)
    @Pattern(regexp = "[a-zA-Z]{3}[0-9]{3}")
    private String code1;
    private LocalDateTime effectiveFrom;
    private LocalDateTime effectiveTo;
    private Boolean status;
    private String description;
    @Pattern(regexp = "^(.+)@(.+)$", message = "Invalid Email")
    private String email;
    @URL(regexp = "(\\b(https?|ftp|file)://)?[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]\n")
    private String url;



    public CouponCode(CouponCodeDTO couponCodeDTO) {
        this.id = couponCodeDTO.getId();
        this.codeName = couponCodeDTO.getCodeName();
        this.code = couponCodeDTO.getCode();
        this.code1 = couponCodeDTO.getCode1();
        this.effectiveFrom = couponCodeDTO.getEffectiveFrom();
        this.effectiveTo = couponCodeDTO.getEffectiveTo();
        this.status = couponCodeDTO.getStatus();
        this.description = couponCodeDTO.getDescription();
        this.email = couponCodeDTO.getEmail();
        this.url=couponCodeDTO.getUrl();
    }

}
