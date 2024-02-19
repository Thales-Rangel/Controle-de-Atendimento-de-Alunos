package Models;

import Interfaces.Authenticable;

public class Admin implements Authenticable {
	
	private int matriculation = 1001;
	private String password = "admin";

	public Admin() {
		// TODO Auto-generated constructor stub
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

}
