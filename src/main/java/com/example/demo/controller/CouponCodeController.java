package com.example.demo.controller;

import com.example.demo.view.CouponCodeDTO;
import com.example.demo.services.CouponCodeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/couponcode")
public class CouponCodeController {

    @Autowired
private CouponCodeServices couponCodeServices;

    @PostMapping
    public CouponCodeDTO addCoupon(@RequestBody CouponCodeDTO couponCodeDTO){
      return couponCodeServices.addCouponCode(couponCodeDTO);
    }

    @GetMapping
    public List<CouponCodeDTO> getAll(){
return couponCodeServices.findAll();
    }

    @GetMapping("/{status}")
    public List<CouponCodeDTO> getActivated(@PathVariable Boolean  status){
        return couponCodeServices.findByStatus(status);
    }


    @PutMapping
    public CouponCodeDTO updateCouponCode(@RequestBody CouponCodeDTO couponCodeDTO) {
        return couponCodeServices.updateCouponCode(couponCodeDTO);
    }

    
}
