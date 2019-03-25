package jersey.rest.model;

import java.io.Serializable;

public class ErrorMessage implements Serializable {

	private static final long serialVersionUID = -6486778598281957808L;

	private String message;
	
	public ErrorMessage() {
		this("");
	}
	
	public ErrorMessage(String message) {
		setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
