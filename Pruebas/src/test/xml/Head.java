package test.xml;

import java.io.Serializable;

public class Head implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String value;

	public String getValue() {
		return this.value;
	}

	public void setValue(String _value) {
		this.value = _value;
	}
}
