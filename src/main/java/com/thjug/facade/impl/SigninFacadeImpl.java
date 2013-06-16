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

import com.thjug.facade.*;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.thjug.entity.Account;
import com.thjug.service.AccountService;
import com.thjug.service.HistoryService;
import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 *
 * @author @nuboat
 */
public class SigninFacadeImpl implements SigninFacade {

	@Inject
	AccountService accountService;
	@Inject
	HistoryService historyService;

	@Override
	@Transactional
	public boolean authen(final String username, final String password)
			throws Exception {
		final Account account = accountService.findByUsername(username.toUpperCase());
		final String cyphertext = new Sha256Hash(password).toHex();
		final boolean result = (cyphertext.equals(account.getPasswd())) ? true : false;

		historyService.keepLog("authen", account, Boolean.toString(result));
		return result;
	}
}
