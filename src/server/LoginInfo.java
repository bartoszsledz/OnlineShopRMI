package server;

import java.io.Serializable;

public class LoginInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String pass;

	public LoginInfo(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", pass=" + pass + "]";
	}

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginInfo other = (LoginInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}
	
	
}