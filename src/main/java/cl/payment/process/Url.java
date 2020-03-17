package cl.payment.process;

import java.io.Serializable;

public class Url implements Serializable {

	private static final long serialVersionUID = 7189325933727391054L;
	
	private String back;
    private String cancel;
    private String picture;
    private String notify;

    public Url() { }
    
    

	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}

	public String getCancel() {
		return cancel;
	}

	public void setCancel(String cancel) {
		this.cancel = cancel;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getNotify() {
		return notify;
	}

	public void setNotify(String notify) {
		this.notify = notify;
	}

}
