package com.example.demo.controller;

import com.example.demo.dto.CouponCodeDTO;
import com.example.demo.model.CouponCode;
import com.example.demo.services.CouponCodeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/status/{status}")
    public List<CouponCodeDTO> getActivated(@PathVariable Boolean  status){
        return couponCodeServices.findByStatus(status);
    }
    @GetMapping("/{id}")
    public Optional<CouponCode> getById(@PathVariable int id){

        Optional<CouponCode> couponCode= couponCodeServices.findById(id);
        if(couponCode.isEmpty()){
            return null;
        }
        else {
            return couponCodeServices.findById(id);
        }
    }


    @PutMapping
    public CouponCodeDTO updateCouponCode(@RequestBody CouponCodeDTO couponCodeDTO) {
        return couponCodeServices.updateCouponCode(couponCodeDTO);
    }

    @GetMapping("/activeList")
    public List<CouponCodeDTO> getActiveList(){

        return couponCodeServices.findActiveList();
    }


}
