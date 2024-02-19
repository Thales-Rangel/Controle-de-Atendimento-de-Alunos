package Sistem;

import java.util.ArrayList;

import Interfaces.RecebemDisciplinas;
import Models.Professor;

public class Disciplane {
	private String name;
	
	private Professor[] professors;
	private ArrayList<Turma> turmas = new ArrayList<Turma>();
	
	public Disciplane(String name, int i) {
		super();
		this.name = name;
		this.professors = new Professor[i];
	}
	
	public Disciplane() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean thereIsALimit() {
		int cont = 0;
		for(int i = 0; i < professors.length;i++) {
			if(professors[i] != null) {
				cont++;
			}
		}		
		if(cont == professors.length) {
			return false;
		} else {
			return true;
		}
	}
	
	public void addProfessor(Professor p) {
		if(thereIsALimit()) {
			for(int i = 0; i < professors.length; i ++) {
				if(professors[i] == null) {
					this.professors[i] = p;
					break;
				}
			}
		}
	}
	
	public Professor getProfessor(int i) {
		return this.professors[i];
	}
	
	public Turma getTurma(int i) {
		return this.turmas.get(i);
	}
	
	public void addTurma(Turma c) {
		this.turmas.add(c);
	}
	
	public void remove(RecebemDisciplinas rp) {
		this.turmas.remove(rp);
		
		for(int i = 0; i < this.professors.length; i++) {
			if(this.professors[i] == rp) {
				this.professors[i] = null;
			}
		}
	}
	
	public int getLengthProfessors() {
		return this.professors.length;
	}
	
	public int getSizeProfessors() {
		int cont = 0;
		for(int i = 0; i < professors.length; i++) {
			if(professors[i] != null) {
				cont++;
			}
		}
		return cont;
	}
	
	public int getSizeTurmas() {
		return this.turmas.size();
	}

}
