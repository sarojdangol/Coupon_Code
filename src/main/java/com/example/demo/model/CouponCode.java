package com.example.demo.model;

import com.example.demo.dto.CouponCodeDTO;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "Coupon_Code")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CouponCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size
    private String codeName;
    @Size(min= 6, max = 6, message = "Code must be of 6 characters")
    @Pattern(regexp = "[a-zA-Z]{3}[0-9]{3}")
    private String code;
    @Past
    private Date effectiveFrom;
    @Future
    private Date effectiveTo;
    private Boolean status;
    private String description;

    public CouponCode(CouponCodeDTO couponCodeDTO) {
this.id=couponCodeDTO.getId();
this.codeName=couponCodeDTO.getCodeName();
this.code=couponCodeDTO.getCode();
this.effectiveFrom=couponCodeDTO.getEffectiveFrom();
this.effectiveTo=couponCodeDTO.getEffectiveTo();
this.status =couponCodeDTO.getStatus();
this.description =couponCodeDTO.getDescription();
    }


}
