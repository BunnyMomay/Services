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
package com.thjug.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author @nuboat
 */
@Entity
@Table(name = "HISTORY")
public class History implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "id")
	@SequenceGenerator(name = "history_seq_gen", sequenceName = "history_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_seq_gen")
	private Integer id;
	@Column(name = "accountid")
	private Integer accountid;
	@Size(max = 512)
	@Column(name = "actionlog")
	private String actionlog;
	@Column(name = "created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Column(name = "updated")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;
	@Column(name = "updateby")
	private Integer updateby;

	public History() {
	}

	public History(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(final Integer accountid) {
		this.accountid = accountid;
	}

	public String getActionlog() {
		return actionlog;
	}

	public void setActionlog(final String actionlog) {
		this.actionlog = actionlog;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(final Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(final Date updated) {
		this.updated = updated;
	}

	public Integer getUpdateby() {
		return updateby;
	}

	public void setUpdateby(final Integer updateby) {
		this.updateby = updateby;
	}

	@Override
	public int hashCode() {
		return (id != null ? id.hashCode() : 0);
	}

	@Override
	public boolean equals(final Object object) {
		// Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof History)) {
			return false;
		}
		final History other = (History) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "History[ id=" + id + " ]";
	}
}
