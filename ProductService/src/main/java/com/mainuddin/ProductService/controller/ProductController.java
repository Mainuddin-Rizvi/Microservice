package com.mainuddin.ProductService.controller;

import com.mainuddin.ProductService.dto.Coupon;
import com.mainuddin.ProductService.model.Product;
import com.mainuddin.ProductService.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/productapi")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${couponService.url}")
    private String couponServiceUrl;

    @RequestMapping(value = "/products",method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product){
        Coupon coupon = restTemplate.getForObject(couponServiceUrl+product.getCouponCode(),Coupon.class);
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return productRepository.save(product);
    }

    public Product sendErrorResponse(@RequestBody Product product){
        return product;
    }
}
