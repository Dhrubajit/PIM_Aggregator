package com.main.java.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.main.java.modelObject.Product;
import com.main.java.proxy.AggregatorProxyService;
import com.main.java.utility.CSVToBean;


@Controller
public class UploadController {

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "D://Personal//FileUpload//";
    
    //List<Product> listProduct;
    Map<String, List<Product>> productMap;
    
    @Autowired
    AggregatorProxyService aggregatorProxyService;
    
    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            //this.listProduct= CSVToBean.CSVToBeanConverter();
            this.productMap = CSVToBean.processCSV();
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/uploadStatus";
    }
    
    
    
    @PostMapping("/callAggregator")
	public String callAggregator() {
		String message= aggregatorProxyService.saveProducts(this.productMap);
		System.out.println(message);
		System.out.println("Dhrubajit");
		return "redirect:/uploadStatus";
	}
    
    
    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}