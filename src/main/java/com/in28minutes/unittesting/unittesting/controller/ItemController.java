package com.in28minutes.unittesting.unittesting.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.model.Item;

@RestController
public class ItemController {
	
	@Autowired
	private ItemBusinessService businessService;

	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		Item item = businessService.retreiveHardcodedItem();
		
		return item;
	}
	
	@GetMapping("/all-items-from-database")
	public List<Item> retrieveAllItems() {
		return businessService.retrieveAllItems();
	}
	
	@RequestMapping(value = "/version", method = RequestMethod.GET)
	 public String versionInformation() {
	     return readGitProperties();
	 }
	
	private String readGitProperties() {
	     ClassLoader classLoader = getClass().getClassLoader();
	     InputStream inputStream = classLoader.getResourceAsStream("git.properties");
	     try {
	         return readFromInputStream(inputStream);
	     } catch (IOException e) {
	         e.printStackTrace();
	         return "Version information could not be retrieved";
	     }
	 }

	Map<String,String> dataMap= new HashMap<String,String>();
	 private String readFromInputStream(InputStream inputStream)
			 throws IOException {
			     StringBuilder resultStringBuilder = new StringBuilder();
			     try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			         String line;
			         while ((line = br.readLine()) != null) {
			             resultStringBuilder.append(line).append("\n");
			             }
			     }
			     return resultStringBuilder.toString();
			 }
	 
}
