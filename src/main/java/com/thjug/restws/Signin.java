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
package com.thjug.restws;

import com.google.inject.Inject;
import com.thjug.facade.SigninFacade;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author @nuboat
 */
@Path("/signin")
public final class Signin {

	private static final Logger LOG = LoggerFactory.getLogger(Signin.class);
	@Inject
	private SigninFacade facade;

	@POST
	public final Response getJson(
			@FormParam("username") final String username,
			@FormParam("password") final String password) {

		LOG.info("Username: {} Password: {}", username, password);
		String result;
		try {
			result = (facade.authen(username, password)) ? "pass" : "fail";
		} catch (final Exception e) {
			LOG.error(e.getMessage(), e);
			result = e.getMessage();
		}
		return Response.status(200).entity(result).build();
	}

}
