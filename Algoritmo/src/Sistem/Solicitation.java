package Sistem;

import Models.Professor;
import Models.Student;

public class Solicitation {
	private Student request;
	private Professor requested;
	private String question;
	private String resp;
	
	private boolean answered = false;

	public Solicitation(Student request, Professor requested, String question) {
		super();
		this.request = request;
		this.requested = requested;
		this.question = question;
		
		request.addSolicitation(this);
		requested.addSolicitation(this);
	}

	public Student getRequest() {
		return request;
	}

	public void setRequest(Student request) {
		this.request = request;
		request.addSolicitation(this);
	}

	public Professor getRequested() {
		return requested;
	}

	public void setRequested(Professor requested) {
		this.requested = requested;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getResp() {
		return resp;
	}

	public void setResp(String resp) {
		this.resp = resp;
		this.setAnswered(true);
		this.request.atualizaSolicitations();
		this.requested.atualizaSolicitations();
	}

	public boolean isAnswered() {
		return answered;
	}

	public void setAnswered(boolean answered) {
		this.answered = answered;
	}
	
	

}
