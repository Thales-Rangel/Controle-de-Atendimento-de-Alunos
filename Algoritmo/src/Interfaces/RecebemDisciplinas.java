package Interfaces;

import Sistem.Disciplane;

public interface RecebemDisciplinas {
	public void addDisciplane(Disciplane d);
	public void removeDisciplane(Disciplane d);
	
	public boolean hasDisciplane(Disciplane d);
	
	public int getSizeDisciplanes();
	
	public Disciplane getDisciplane(int index);

}
