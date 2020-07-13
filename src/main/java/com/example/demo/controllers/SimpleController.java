package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Product;

@Controller
//@RestController
public class SimpleController {

	ArrayList<Product> allProducts = new ArrayList<>();

	@GetMapping("/hello") // url address->localhost:8080/hello
	public String getHello() {
		System.out.println("Hello controller working");
		return "hello-page";// hello-page.html
	}

	@GetMapping("/helloString") // url address->localhost:8080/helloString
	public String getHelloString(Model model) {
		// create an inner obbject -> Object innerObject = "My name is Karina!"
		model.addAttribute("innerObject", "My name is Karina!");
		return "hello-string-page";// hello-string-page.html
	}

	@GetMapping("/showOneProduct") // url address->localhost:8080/showOneProduct
	public String getShowOneProduct(Model model) {
		Product myProduct = new Product("apple", 0.56f);
		model.addAttribute("innerObject", myProduct);
		return "show-one-product-page";// show-one-product-page.html

	}

	@GetMapping("/showAllProducts") // url address->localhost:8080/showAllProducts
	public String getShowAllProducts(Model model) {
		allProducts.add(new Product("bread", 1.99f));
		allProducts.add(new Product("window", 56.67f));
		allProducts.add(new Product("window", 56.67f));

		model.addAttribute("innerObject", allProducts);

		return "show-all-products-page";// show-all-products-page.html

	}

	@GetMapping("/showOneProductParam") // url address->localhost:8080/showOneProductParam?id=5
	public String getShowOneProductParam(@RequestParam(name = "id") int id, Model model) {
		if (id > 0) {
			for (Product prod : allProducts) {
				if (prod.getId() == id)
					model.addAttribute("innerObject", prod);
			}

			return "show-one-product-page";// show-one-product-page.html
		} else
			return "error";

	}

	@GetMapping("/showAllProducts/{id}") // url address->localhost:8080/showAllProducts/2
	public String getShowAllProductsId(@PathVariable(name = "id") int id, Model model) {
		if (id > 0) {
			for (Product prod : allProducts) {
				if (prod.getId() == id)
					model.addAttribute("innerObject", prod);
			}

			return "show-one-product-page";// show-one-product-page.html
		} else
			return "error";
	}
	
	
	
	@GetMapping("/insertOneProduct")// url address->localhost:8080/insertOneProduct
	public String getInsertOneProduct(Product product)//it's empty product for data input
	{
		return "insert-one-product-page";//insert-one-product-page.html
	}
	
	@PostMapping("/insertOneProduct")//it will call when submit button will be pressed
	public String postInsertOneProduct(Product product)
	{
		System.out.println(product);
		
		allProducts.add(new Product(product.getTitle(), product.getPrice()));
		return "redirect:/showAllProducts";
		
	}
	
	
	@GetMapping("/showOneProductJson")// url address->localhost:8080/showOneProductJson
	public @ResponseBody Product getShowOneProductJson()
	{
		return allProducts.get(0);
	}
	
	
	
	
	

}
