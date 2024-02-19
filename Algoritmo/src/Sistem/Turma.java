package Sistem;

import java.util.ArrayList;

import Interfaces.RecebemDisciplinas;
import Models.Student;

public class Turma implements RecebemDisciplinas{
	
	private String name;
	private Student[] students;
	private ArrayList<Disciplane> disciplanes = new ArrayList<Disciplane>();

	public Turma(String name,int i) {
		super();
		this.name = name;
		this.students = new Student[i];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean getIfHasLimit() {
		int cont = 0;
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null) {
				cont++;
			}
		}
		if(cont == students.length) {
			return false;
		} else {
			return true;
		}
	}
	
	public void addStudent(Student s) {
		if(getIfHasLimit()) {
			for(int i = 0; i < students.length; i++) {
				if(students[i] == null) {
					students[i] = s;
					Database.students.add(s);
					break;
				}
			}
		}
	}
	
	public void removeStudent(Student s) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] == s) {
				students[i] = null;
			}
		}
	}
	
	public int getIndex(Student s) {
		int i;
		for(i = 0; i < students.length; i++) {
			if(students[i] == s) {
				break;
			}
		}
		
		return i;
	}
	
	public Student getStudent(int i) {
		return this.students[i];
	}
	
	public Disciplane getDisciplane(int i) {
		return disciplanes.get(i);
	}
	
	public void addDisciplane(Disciplane d) {
		disciplanes.add(d);
		d.addTurma(this);
	}
	
	public void removeDisciplane(Disciplane d) {
		disciplanes.remove(d);
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
	
	public int getLengthStudents() {
		return this.students.length;
	}
	
	public int getSizeStudents() {
		int cont = 0;
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null) {
				cont++;
			}
		}
		return cont;
	}
	
	public int getSizeDisciplanes() {
		return this.disciplanes.size();
	}
	
	//// Para testes ////
	public void list() {
		for(int i = 0; i < students.length; i ++) {
			if(students[i] != null) {
				System.out.println(students[i].getName()+" "+ students[i].getMatriculation()+" "+ students[i].getAddress());
			}
		}
	}

}
