package com.example.demo.proxy;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CouponProxy {
	private Long id;
	private String code;
	private BigDecimal discount;
	private String expDate;

}
