package Models;

import java.util.ArrayList;

import Interfaces.Authenticable;
import Interfaces.RecebemSolicitations;
import Sistem.Solicitation;
import Sistem.Turma;

public class Student extends User implements Authenticable, RecebemSolicitations{
	
	private String password;
	private String address;
	
	private Turma identClass;
 	
	public Student(String name, int matriculation,String password, String address, Turma studentTurma) {
		super();
		this.name = name;
		this.matriculation = matriculation;
		this.password = password;
		this.address = address;
		
		//studentClass.addStudent(this);
		identClass = studentTurma;
	
	}
	
	public void setPassword(int matriculation, String password, String newPassword) {
		if(authencate(matriculation, password)) {
			this.password = newPassword;
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Turma getIdentClass() {
		return identClass;
	}

	public void setIdentClass(Turma identClass) {
		this.identClass = identClass;
	}

	@Override
	public boolean authencate(int matriculation, String password) {
		// TODO Auto-generated method stub
		if(this.matriculation == matriculation && this.password.equals(password)) {
			return true;
		}else {
			return false;	
		}
	}
	
	public void addSolicitation(Solicitation s) {
		this.solicitations.add(s);
		
		if(s.isAnswered()) {
			this.respSolicitations.add(s);
		} else {
			this.notRespSolicitations.add(s);
		}
	}
	
	public void atualizaSolicitations() {
		for(int i = 0; i < this.notRespSolicitations.size(); i++) {
			if(notRespSolicitations.get(i).isAnswered()) {
				this.respSolicitations.add(notRespSolicitations.get(i));
				this.notRespSolicitations.remove(i);
			}
		}
	}
	
	///// apenas para testes: /////
	
	public String getPassword() {
		return this.password;
	}

}
