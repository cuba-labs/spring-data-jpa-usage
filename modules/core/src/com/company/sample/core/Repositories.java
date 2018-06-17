package com.company.sample.core;

import com.haulmont.cuba.core.Persistence;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component("sample_Repositories")
public class Repositories {

    @Inject
    private Persistence persistence;

    public <T> T get(Class<T> repositoryClass) {
        SpringDataEntityManager em = new SpringDataEntityManager(persistence.getEntityManager());
        JpaRepositoryFactory repositoryFactory = new JpaRepositoryFactory(em);
        return repositoryFactory.getRepository(repositoryClass);
    }
}
