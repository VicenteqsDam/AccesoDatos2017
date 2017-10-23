package es.fempa.accesodatos.app.simple.model.pojo;

import java.io.Serializable;

public class FilterForm implements Serializable {

    private static final long serialVersionUID = 8241001782647539626L;
    private String text;

    public String getText() {
        return this.text;
    }

    public void setText(String _text) {
        this.text = _text;
    }

}
