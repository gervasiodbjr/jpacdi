package com.gdbjr.jpacdi.domain.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gdbjr.jpacdi.domain.qualifier.JpaCDI;

public class EntityManagerProducer {

	@Produces
	@ApplicationScoped
	@JpaCDI
	public EntityManagerFactory getCadastroEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("jpaCDI");
	}
	
	@Produces
	@RequestScoped
	@JpaCDI
	public EntityManager getCadastroEntityManager(@JpaCDI EntityManagerFactory factory) {
		return factory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes @Any EntityManager manager) {
		if(manager.isOpen())
			manager.close();
	}

}
