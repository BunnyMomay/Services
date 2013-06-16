/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thjug.base;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import com.thjug.restws.Echo;
import com.thjug.restws.Signin;
import com.thjug.restws.Status;

/**
 *
 * @author nuboat
 */
public class ServletContextListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		final Injector injector = Guice.createInjector(new JerseyServletModule() {
			@Override
			protected void configureServlets() {
				bind(Echo.class);
				bind(Status.class);
				bind(Signin.class);
				bind(ServletContainer.class).in(Singleton.class);
				serve("/rest/*").with(GuiceContainer.class);
			}
		}, new JpaPersistModule("dbUnit"));

		injector.getInstance(JPAInitializer.class);
		return injector;
	}
}
