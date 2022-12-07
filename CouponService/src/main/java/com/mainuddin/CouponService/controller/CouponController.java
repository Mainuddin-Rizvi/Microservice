package com.mainuddin.CouponService.controller;

import com.mainuddin.CouponService.model.Coupon;
import com.mainuddin.CouponService.repos.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
public class CouponController {

    @Autowired
    CouponRepository couponRepository;

    @RequestMapping(value = "/coupons",method = RequestMethod.POST)
    public Coupon createCoupon(@RequestBody Coupon coupon){
        return couponRepository.save(coupon);
    }

    @RequestMapping(value = "/coupons/{code}",method = RequestMethod.GET)
    public Coupon createCoupon(@PathVariable("code") String code){
        return couponRepository.findByCode(code);
    }
}
