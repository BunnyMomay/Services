/*
 * Attribution
 * CC BY
 * This license lets others distribute, remix, tweak,
 * and build upon your work, even commercially,
 * as long as they credit you for the original creation.
 * This is the most accommodating of licenses offered.
 * Recommended for maximum dissemination and use of licensed materials.
 *
 * http://creativecommons.org/licenses/by/3.0/
 * http://creativecommons.org/licenses/by/3.0/legalcode
 */
package com.thjug.facade.impl;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.thjug.base.JPAInitializer;

/**
 *
 * @author @nuboat
 */
public abstract class AbstractFacadeNGTest {

	protected final Injector injector;

	public AbstractFacadeNGTest() {
		injector = Guice.createInjector(new JpaPersistModule("dbUnit"));
		injector.getInstance(JPAInitializer.class);
	}

}
