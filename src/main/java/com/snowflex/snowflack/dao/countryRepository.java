package com.snowflex.snowflack.dao;

import com.snowflex.snowflack.entity.country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "countries", path ="countries")
public interface countryRepository extends JpaRepository<country, Integer> {
}
