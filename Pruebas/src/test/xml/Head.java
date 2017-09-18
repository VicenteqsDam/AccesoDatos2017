package test.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Head implements Serializable {

	private static final long serialVersionUID = 1L;
	@XmlMixed
	private String value;

	public String getValue() {
		return this.value;
	}

	public void setValue(String _value) {
		this.value = _value;
	}
}
