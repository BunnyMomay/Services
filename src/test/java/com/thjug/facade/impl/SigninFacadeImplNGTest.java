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

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author nuboat
 */
public class SigninFacadeImplNGTest extends AbstractFacadeNGTest {

	@Test
	public void testAuthen() throws Exception {
		String username = "admin";
		String password = "password";
		SigninFacadeImpl instance = injector.getInstance(SigninFacadeImpl.class);

		boolean expResult = true;
		boolean result = instance.authen(username, password);
		assertEquals(result, expResult);
	}
}