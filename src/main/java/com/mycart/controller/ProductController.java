
package com.mycart.controller;

import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mycart.dto.ProductDto;

import com.mycart.response.ProductResponse;
import com.mycart.service.ProductService;
import com.mycart.vo.ProductVO;

@RestController
@Validated
@RequestMapping(value = "/mycart/product")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ProductVO getProduct(@Positive @PathVariable final Long id) throws Exception {
		return this.service.getProduct(id);

	}

	@GetMapping("/all")
	@ResponseStatus(code = HttpStatus.OK)
	public ProductResponse getAllProduct() throws Exception {
		return this.service.getAllProduct();

	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProductResponse addProducts(@RequestBody @NotNull Collection<ProductDto> productDtos) throws Exception {
		return this.service.addProducts(productDtos);

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteProduct(@Positive @PathVariable final Long id) throws Exception {
		this.service.deleteProduct(id);
	}

}
