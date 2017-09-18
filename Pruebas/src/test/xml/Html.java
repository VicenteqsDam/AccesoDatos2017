package test.xml;

import java.io.Serializable;

public class Html implements Serializable {

	private static final long serialVersionUID = 8973727111576792114L;
	private Head head;
	private Body body;

	public Head getHead() {
		return this.head;
	}

	public void setHead(Head _head) {
		this.head = _head;
	}

	public Body getBody() {
		return this.body;
	}

	public void setBody(Body _body) {
		this.body = _body;
	}
}
