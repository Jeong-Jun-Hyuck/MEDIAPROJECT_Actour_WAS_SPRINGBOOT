package com.actour.api.dao;

public class RegisterResultModel {
    boolean result;
    String message;

    public RegisterResultModel(boolean result, String message) {
		super();
		this.result = result;
		this.message = message;
	}

	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
