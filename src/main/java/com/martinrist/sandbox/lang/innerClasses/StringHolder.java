package com.martinrist.sandbox.lang.innerClasses;

public class StringHolder {

	private final String contents;

	public StringHolder(String contents) {
		this.contents = contents;
	}

	public String getContents() {
		return this.contents;
	}

	@Override
	public int hashCode() {
		return contents.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StringHolder other = (StringHolder) obj;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return contents;
	}

}
