package com.example.demo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	
	public void saveProducts(Map<String, List<Product>> productMap) {
		for (Entry<String, List<Product>> entry : productMap.entrySet()) {
			if (entry.getValue().size() == 1) {
				// insert call
				Product product = entry.getValue().get(0);
				product.setCreateddate(new Date());
				product.setLastmodifieddate(new Date());
				productRepository.save(product);
			}
			else {
				List<Product> productList = entry.getValue();

				// insert call
				Product product0 = productList.get(0);
				product0.setCreateddate(new Date());
				product0.setLastmodifieddate(new Date());
				Product savedProduct = productRepository.save(product0);

				for (int index = 1; index < productList.size(); index++) {
					// update call
					Product product1 = productList.get(index);
					savedProduct.setUuid(product1.getUuid());
					savedProduct.setName(product1.getName());
					savedProduct.setDescription(product1.getDescription());
					savedProduct.setProvider(product1.getProvider());
					savedProduct.setAvailable(product1.getAvailable());
					savedProduct.setMessuermentunit(product1.getMessuermentunit());
					savedProduct.setLastmodifieddate(new Date());
					productRepository.save(savedProduct);
				}
			}
		}
	}
	
	
	public Product updateProductWithID(Product product, Integer id) {
		Product updatedProduct = productRepository.findById(id).get();
		if (updatedProduct == null)
			return product;

		updatedProduct.setUuid(product.getUuid());
		updatedProduct.setName(product.getName());
		updatedProduct.setDescription(product.getDescription());
		updatedProduct.setProvider(product.getProvider());
		updatedProduct.setAvailable(product.getAvailable());
		updatedProduct.setMessuermentunit(product.getMessuermentunit());
		updatedProduct.setLastmodifieddate(new Date());

		productRepository.save(updatedProduct);
		return updatedProduct;
	}

	
	public Iterable<Product> getAllProduct() {
		Iterable<Product> allProducts = productRepository.findAll();
		return allProducts;
	}

	
	public Map<String, List<Product>> getAllProductsByDate(String dateIdentifier) {
	    Date date;
	    Map<String, List<Product>> productsByUpdatedStatus = new HashMap<>();
	    List<Product> modifiedProducts = new ArrayList<>();
	    List<Product> unmodifiedProducts = new ArrayList<>();
	    
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateIdentifier);
			List<Product> productsByDate = productRepository.findAllByCreateddate(date);
		    for(Product product : productsByDate) {
		    	if(product.getCreateddate().equals(product.getLastmodifieddate()))
		    		unmodifiedProducts.add(product);
		    	else
		    		modifiedProducts.add(product);
		    }
		    productsByUpdatedStatus.put("MODIFIED", modifiedProducts);
		    productsByUpdatedStatus.put("UNMODIFIED", unmodifiedProducts);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return productsByUpdatedStatus;
	}

}
