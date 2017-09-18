package test.xml;

import java.io.Serializable;

public class Div implements Serializable {
	
	private static final long serialVersionUID = -8220841005326868008L;
	private String value;
	private String style;

	public String getValue() {
		return this.value;
	}

	public void setValue(String _value) {
		this.value = _value;
	}

	public String getStyle() {
		return this.style;
	}

	public void setStyle(String _style) {
		this.style = _style;
	}

}
