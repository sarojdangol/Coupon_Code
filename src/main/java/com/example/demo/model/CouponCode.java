package com.example.demo.model;

import com.example.demo.view.CouponCodeDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "Coupon_Code")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size
    private String codeName;
    @Size(min = 6, max = 6, message = "Code must be of 6 characters")
    @Pattern(regexp = "[a-zA-Z]{3}[0-9]{3}")
    private String code;

    private LocalDateTime effectiveFrom;

    private LocalDateTime effectiveTo;
    private Boolean status;
    private String description;

    public CouponCode(CouponCodeDTO couponCodeDTO) {
        this.id = couponCodeDTO.getId();
        this.codeName = couponCodeDTO.getCodeName();
        this.code = couponCodeDTO.getCode();
        this.effectiveFrom = couponCodeDTO.getEffectiveFrom();
        this.effectiveTo = couponCodeDTO.getEffectiveTo();
        this.status = couponCodeDTO.getStatus();
        this.description = couponCodeDTO.getDescription();
    }


}
