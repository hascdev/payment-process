package cl.payment.process;

import java.io.Serializable;

public class Payment implements Serializable {

	private static final long serialVersionUID = 7189325933727391054L;
	
	private String subject;
    private String currency;
    private Double amount;
    private Url url;

    public Payment() { }

    public Payment(String currency) {
        this.currency = currency;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
	public Url getUrl() {
		return url;
	}

	public void setUrl(Url url) {
		this.url = url;
	}

	@Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
		sb.append("Subject: ").append(subject);
		sb.append("\n");
		sb.append("Currency: ").append(currency);
		sb.append("\n");
		sb.append("Amount: ").append(amount);
		sb.append("\n");
		return sb.toString();
    }
	
	
}
