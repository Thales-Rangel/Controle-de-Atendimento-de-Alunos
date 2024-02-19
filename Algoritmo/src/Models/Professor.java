package Models;

import java.util.ArrayList;

import Interfaces.Authenticable;
import Interfaces.RecebemDisciplinas;
import Interfaces.RecebemSolicitations;
import Sistem.Disciplane;
import Sistem.Solicitation;

public class Professor extends User implements Authenticable, RecebemDisciplinas, RecebemSolicitations{
	
	ArrayList<Disciplane> disciplanes = new ArrayList<Disciplane>();
	
	
	
	public Professor(String name, int matriculation, String password) {
		super(name, matriculation, password);
	}

	public void setPassword(int matriculation, String password, String newPassword) {
		if(authencate(matriculation, password)) {
			this.password = newPassword;
		}
	}

	public Disciplane getDisciplane(int i) {
		return this.disciplanes.get(i);
	}

	public void addDisciplane(Disciplane d) {
		if(d.thereIsALimit()) {
			this.disciplanes.add(d);
			d.addProfessor(this);
		}
	}
	
	public void removeDisciplane(Disciplane d) {
		this.disciplanes.remove(d);
	}
	
	public boolean hasDisciplane(Disciplane d) {
		int cont = 0;
		for(int i = 0; i < this.disciplanes.size(); i++) {
			if(disciplanes.get(i) == d) {
				break;
			} else {
				cont++;
			}
		}
		
		if(cont == disciplanes.size()) {
			return false;
		}else {
			return true;
		}
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
	
	public int getSizeDisciplanes() {
		return this.disciplanes.size();
	}

	@Override
	public void addSolicitation(Solicitation s) {
		// TODO Auto-generated method stub
		this.solicitations.add(s);
		
		if(s.isAnswered()) {
			this.respSolicitations.add(s);
		} else {
			this.notRespSolicitations.add(s);
		}
		
	}

	@Override
	public void atualizaSolicitations() {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.notRespSolicitations.size(); i++) {
			if(notRespSolicitations.get(i).isAnswered()) {
				this.respSolicitations.add(notRespSolicitations.get(i));
				this.notRespSolicitations.remove(i);
			}
		}
	}

}
