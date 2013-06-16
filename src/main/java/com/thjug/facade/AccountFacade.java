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
package com.thjug.facade;

import com.thjug.entity.Account;

/**
 *
 * @author @nuboat
 */
//@ImplementedBy(value = AccountFacadeImpl.class)
public interface AccountFacade {

	public Account create(final Account account) throws Exception;

	public Account update(final Account account) throws Exception;

	public void remove(final Integer accountid) throws Exception;
}
