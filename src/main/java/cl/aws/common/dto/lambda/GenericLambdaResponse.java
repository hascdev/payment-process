package cl.aws.common.dto.lambda;

import java.io.Serializable;

public class GenericLambdaResponse implements Serializable {
	private static final long serialVersionUID = 7791680690692085780L;
	
	public static final Integer CODE_ERROR = -1;
	public static final Integer CODE_OK = 1;
	public static final Integer CODE_OK_MSG = 2;
	
	private Integer code;
	private String message;
	private Object object;
	
	public GenericLambdaResponse() {
		this.code = CODE_OK;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}	
}
