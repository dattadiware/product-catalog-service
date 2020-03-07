
package com.mycart.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mycart.dto.BrandDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;

	private String name;

	private String description;

	public static Brand from(BrandDto dto) {
		return Brand.builder().name(dto.getName()).description(dto.getDescription()).build();
	}
}
