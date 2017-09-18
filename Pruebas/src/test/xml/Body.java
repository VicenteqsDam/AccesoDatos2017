package test.xml;

import java.io.Serializable;
import java.util.ArrayList;

public class Body implements Serializable {
	
	private static final long serialVersionUID = 1208387430614040278L;
	private ArrayList<Div> divs;
	private String value;

	public Body() {
		this.divs = new ArrayList<Div>();
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String _value) {
		this.value = _value;
	}

	public ArrayList<Div> getDivs() {
		return this.divs;
	}

	public void setDivs(ArrayList<Div> _divs) {
		this.divs = _divs;
	}
}
