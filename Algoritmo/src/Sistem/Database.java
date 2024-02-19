package Sistem;

import java.util.ArrayList;

import Models.Admin;
import Models.Professor;
import Models.Student;
import Sistem.Disciplane;
import Sistem.Turma;

public class Database {
	
	public static ArrayList<Turma> turmas = new ArrayList<Turma>();
	public static ArrayList<Disciplane> disciplanes = new ArrayList<Disciplane>();
	public static ArrayList<Student> students = new ArrayList<Student>();
	public static ArrayList<Professor> professors = new ArrayList<Professor>();
	public static ArrayList<Admin> admins = new ArrayList<>();
	
	public static void exemplos() {
		turmas.add(new Turma("INFO2M",32));
		turmas.add(new Turma("ADM3M", 28));
		turmas.add(new Turma("INFO1VA", 38));
		turmas.add(new Turma("ADM1M", 20));
		
		turmas.get(0).addStudent(new Student("Thales Rangel", 3001, "senha1","Caiçara do Rio dos Ventos", turmas.get(0)));
		turmas.get(0).addStudent(new Student("Aluno2", 3002, "senha2","Santana", turmas.get(0)));
		turmas.get(1).addStudent(new Student("The La Mancha", 3003, "senha3", "Lajes", turmas.get(1)));
		turmas.get(1).addStudent(new Student("Aluno 4", 3004, "senha4", "Lajes", turmas.get(1)));
		turmas.get(2).addStudent(new Student("Aluno5",3005, "senha5", "Caiçara", turmas.get(2)));
		turmas.get(2).addStudent(new Student("Aluno6",3006, "senha6", "Suburbio de Lajes", turmas.get(2)));
		turmas.get(3).addStudent(new Student("MP4", 3007,"senha7", "Fin de mundo", turmas.get(3)));
		
		Professor p1 = new Professor("Prof1", 2001, "senhaP1");
		Professor p2 = new Professor("Prof2", 2002, "senhaP2");
		Professor p3 = new Professor("Prof3", 2003, "senhaP3");
		Professor p4 = new Professor("Prof4", 2004, "senhaP4");

		professors.add(p1);
		professors.add(p2);
		professors.add(p3);
		professors.add(p4);
		
		disciplanes.add(new Disciplane("Informática", 5));
		disciplanes.add(new Disciplane("Física", 4));
		disciplanes.add(new Disciplane("PEOO", 1));
		
		turmas.get(0).addDisciplane(disciplanes.get(0));
		professors.get(0).addDisciplane(disciplanes.get(0));
		professors.get(2).addDisciplane(disciplanes.get(0));
		
		turmas.get(0).addDisciplane(disciplanes.get(1));
		turmas.get(1).addDisciplane(disciplanes.get(1));
		turmas.get(2).addDisciplane(disciplanes.get(1));
		turmas.get(3).addDisciplane(disciplanes.get(1));
		professors.get(1).addDisciplane(disciplanes.get(1));
		professors.get(3).addDisciplane(disciplanes.get(1));
		
		turmas.get(0).addDisciplane(disciplanes.get(2));
		turmas.get(2).addDisciplane(disciplanes.get(2));
		professors.get(2).addDisciplane(disciplanes.get(2));
		
		admins.add(new Admin());
		
		Solicitation s1 = new Solicitation(students.get(0), professors.get(0), "Qnt é 1+2?");
		professors.get(0).solicitations.get(0).setResp("É dois, burro!!");
		
		Solicitation s2 = new Solicitation(students.get(0), professors.get(2), "Oq é verbo?");
		
		new Solicitation(students.get(0), professors.get(0), "Qnt é 6/12?");
	}

}
