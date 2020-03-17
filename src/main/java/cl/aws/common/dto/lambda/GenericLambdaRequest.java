package cl.aws.common.dto.lambda;

import java.io.Serializable;
import java.util.Map;

public class GenericLambdaRequest implements Serializable {
	private static final long serialVersionUID = 4439641647263036460L;
	
	private String command;
	private Map<String, String> attributes;
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Command: ").append(command);
		sb.append("\n");
		sb.append("Attributes: ").append(attributes);
		
		return sb.toString();
	}
}
