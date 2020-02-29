
package com.mycart.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mycart.domain.Brand;

public interface BrandRepository extends CrudRepository<Brand, Long> {

    Optional<Brand> findOneByName(String name);
    Optional<Brand> findOneByBrandId(Long brandId);
    Collection<Brand> findAll();
    
    void deleteByBrandId(Long brandId);

}