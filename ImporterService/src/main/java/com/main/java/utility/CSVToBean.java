package com.main.java.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.main.java.modelObject.Product;


public class CSVToBean {
	private static final String FILE_LOCATION = "D://Personal//FileUpload//dataExample.csv";
	
	public static Map<String, List<Product>> processCSV() {
		String thisLine;
		String[] splitLine;
		String uuid, name, description, provider, available, measurementUnit;
		Map<String, List<Product>> productMap = new LinkedHashMap<>();
		int lineNum = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(FILE_LOCATION))) {
			while((thisLine = br.readLine())!=null) {
				if(lineNum == 0)
					lineNum++;
				else {
					splitLine = thisLine.split(",");
					uuid = splitLine[0];
					name = splitLine[1];
					description = splitLine[2];
					provider = splitLine[3];
					available = splitLine[4];
					measurementUnit = splitLine[5];
					
					Product product = new Product(uuid, name, description, provider, available, measurementUnit);
					
					if(null != productMap.get(uuid))
						productMap.get(uuid).add(product);
					else {
						 List<Product> productList = new LinkedList<>();
						 productList.add(product);
						 productMap.put(uuid, productList);
					}
					lineNum++;
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return productMap;
	}
}
