package com.spdev.lindacaretest.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public abstract class AbstractModel implements Serializable {

	private static final long serialVersionUID = 7015902863493490874L;

	// _id is mapped with the default MongoDB ObjectId
	@Id
	private String _id;

	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		return prime * 1 + (_id == null ? 0 : _id.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		AbstractModel other = (AbstractModel) obj;
		if (_id == null) {
			if (other._id != null) {
				return false;
			}
		} else if (!_id.equals(other._id)) {
			return false;
		}
		return true;
	}

}
