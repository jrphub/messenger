package org.restful.api.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
    private String errMessage;
    private int errorCode;
    private String documentation;

    public ErrorMessage() {
	// no-arg construtor
    }

    public ErrorMessage(String errMessage, int errorCode, String documentation) {
	this.errMessage = errMessage;
	this.errorCode = errorCode;
	this.documentation = documentation;
    }

    public String getErrMessage() {
	return errMessage;
    }

    public int getErrorCode() {
	return errorCode;
    }

    public String getDocumentation() {
	return documentation;
    }

    public void setErrMessage(String errMessage) {
	this.errMessage = errMessage;
    }

    public void setErrorCode(int errorCode) {
	this.errorCode = errorCode;
    }

    public void setDocumentation(String documentation) {
	this.documentation = documentation;
    }

}
