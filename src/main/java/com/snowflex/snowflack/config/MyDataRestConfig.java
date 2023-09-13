package com.snowflex.snowflack.config;

import com.snowflex.snowflack.entity.Product;
import com.snowflex.snowflack.entity.ProductCategory;


import jakarta.persistence.EntityManager;

import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] theUnsupportedAction = { HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE };

        // disable Http methods for product : put , post and delete
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata,htppMethods) -> htppMethods.disable(theUnsupportedAction))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction));

        // disable Http methods for productCategory : put , post and delete
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata,htppMethods) -> htppMethods.disable(theUnsupportedAction))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction));

        // call an internal helper method
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        // expose entity ids
        //

        // - get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // - create an array of the entity types
        List<Class> entityClasses = new ArrayList<>();

        // - get the entity types for the entities
        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        // - expose the entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);

    }
}
