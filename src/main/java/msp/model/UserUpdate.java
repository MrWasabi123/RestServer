package msp.model;

public class UserUpdate {
	
	 private String nickname;
	 public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getStudies() {
		return studies;
	}
	public void setStudies(String studies) {
		this.studies = studies;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	private String studies;
	 private String subject;
	 private String plan;
}
