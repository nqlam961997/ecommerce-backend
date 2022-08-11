package com.lam.springbootsecommerce.config;

import com.lam.springbootsecommerce.entity.Country;
import com.lam.springbootsecommerce.entity.Product;
import com.lam.springbootsecommerce.entity.ProductCategory;
import com.lam.springbootsecommerce.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupportedActions = {HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT};

        // Disables http method
        disableHttpMethods(Product.class, config, theUnsupportedActions);
        disableHttpMethods(ProductCategory.class, config, theUnsupportedActions);
        disableHttpMethods(Country.class, config, theUnsupportedActions);
        disableHttpMethods(State.class, config, theUnsupportedActions);

        // call an internal helper method
        exposedIds(config);
    }

    private static void disableHttpMethods(Class theClass ,RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure(((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions)))
                .withCollectionExposure((((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))));
    }

    private void exposedIds(RepositoryRestConfiguration config) {
        // get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // create an array of entity type
        List<Class> entityClasses = new ArrayList<>();

        // get the entity type for the entities
        for (EntityType entityType: entities) {
            entityClasses.add(entityType.getJavaType());
        }

        // expose the entity ids for the  array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}
