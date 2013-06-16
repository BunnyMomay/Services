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
package com.thjug.service;

import com.thjug.entity.Account;
import com.thjug.entity.History;

/**
 *
 * @author @nuboat
 */
public class HistoryService extends AbstractService<History> {

	public HistoryService() {
		super(History.class);
	}

	public void keepLog(final String action, final Account account, final String result) {
		// TODO
	}

}
