package Models;

import java.util.ArrayList;

import Sistem.Solicitation;

public abstract class User {
	
	protected String name;
	protected int matriculation;
	protected String password;
	
	public ArrayList<Solicitation> solicitations = new ArrayList<Solicitation>();
	public ArrayList<Solicitation> respSolicitations = new ArrayList<>();
	public ArrayList<Solicitation> notRespSolicitations = new ArrayList<>();
	
	public User(String name, int matriculation, String password) {
		super();
		this.name = name;
		this.matriculation = matriculation;
		this.password = password;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMatriculation() {
		return matriculation;
	}

	public void setMatriculation(int matriculation) {
		this.matriculation = matriculation;
	}

	public String getPassword() {
		return password;
	}

	public abstract void setPassword(int matriculation, String password, String newPassword);

}
