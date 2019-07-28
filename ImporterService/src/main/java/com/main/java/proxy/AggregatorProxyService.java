package com.main.java.proxy;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.java.modelObject.Product;


@FeignClient(name="Aggregator")
public interface AggregatorProxyService {

	@RequestMapping("/saveProducts")
	public String saveProducts(Map<String, List<Product>> productMap);
}
