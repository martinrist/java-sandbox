package com.martinrist.sandbox.lang.innerClasses.tossing;

public class Result {

	private final String description;
	private final int value;

	public Result(String description, int value) {
		this.description = description;
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public int getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + value;
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
		Result other = (Result) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (value != other.value)
			return false;
		return true;
	}

}
