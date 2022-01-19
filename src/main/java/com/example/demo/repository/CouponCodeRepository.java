package com.example.demo.repository;

import com.example.demo.model.CouponCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CouponCodeRepository extends JpaRepository<CouponCode, String> {

    //    @Query( value = "SELECT * from Coupon_Code", nativeQuery = true)
    @Query("select c from CouponCode c order By c.id")
    List<CouponCode> fetchAll();

    @Query("select c from CouponCode c where c.id=:n")
    Optional<CouponCode> fetchById(@Param("n") int id);

    @Query("select c from CouponCode c where c.effectiveFrom<LOCALTIMESTAMP and LOCALTIMESTAMP<c.effectiveTo")
    List<CouponCode> findActiveList(@Param("effectiveFrom") LocalDateTime effectiveFrom, @Param("effectiveTo") LocalDateTime effectiveTo);

}
