package com.mycart.service;

import static  com.mycart.common.SearchType.valueOf;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mycart.common.ProductSpecificationBuilder;
import com.mycart.domain.Product;
import com.mycart.repository.ProductRepository;
import com.mycart.response.ProductResponse;
import com.mycart.vo.ProductVO;

import model.SearchResult;


@Service
public class ProductSearchService extends SearchResult<Product> {

	@Autowired
	private ProductRepository repositry;

	public ProductResponse getProductByCrieteria(final String crieteria) throws Exception{

		ProductSpecificationBuilder builder = new ProductSpecificationBuilder();
		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
		Matcher matcher = pattern.matcher(crieteria + ",");

		while (matcher.find()) {
			builder.as(valueOf(matcher.group(1).toUpperCase()), matcher.group(2), matcher.group(3));
		}
		Specification<Product> spec = builder.build();

		Collection<Product> products = repositry.findAll(spec);
		
		Collection<ProductVO> productVOs = products.stream().map(ProductVO::from).collect(Collectors.toList());
		return ProductResponse.from(productVOs);

	}

}
