package project;
import java.util.Iterator;

import DSA.DoubleOrderedList;

public class Person implements Comparable<Object>{
	private String identifier;
	private String name;
	private String fSurname;
	private String sSurname;
	private String gender;
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	private String birthplace;
	private String home;
	private DoubleOrderedList<String> studiedAt = new DoubleOrderedList<String>();
	private DoubleOrderedList<String> workedAt = new DoubleOrderedList<String>();
	private DoubleOrderedList<String> movies = new DoubleOrderedList<String>();
	private String groupCode = "G611630";
	
	
	public Person(String id) {		
		this.identifier = id;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurnames() {
		return fSurname + sSurname;
	}
	
	public void setSurnames(String[] surnames) {
		fSurname= surnames[0];
		if(surnames.length ==2)sSurname = surnames[1];
		else sSurname = "";
	}
	
	public String getBirthdate() {
		return birthDay + "-" + birthMonth + "-" + birthYear;
	}
	
	public void setBirthdate(int day, int month, int year) {
		birthDay=day; 
		birthMonth= month;
		birthYear= year;
	}
	
	public String getBirthplace() {
		return birthplace;
	}
	
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	
	public String getHome() {
		return home;
	}
	
	public void setHome(String home) {
		this.home = home;
	}
	
	public String getStudiedAt() {
		Iterator<String> itr = studiedAt.iterator();
		String Study = "";
		while(itr.hasNext()){
			Study+=itr.next();
			if(itr.hasNext()){
				Study+=", ";
			}
		}
		return Study;
	}
	
	public void setStudiedAt(String[] Studied) {
		for(int i=0; i<Studied.length; i++){
			this.studiedAt.add(Studied[i]);
		}
	}
	
	public String getWorkedAt() {
		Iterator<String> itr = workedAt.iterator();
		String Work = "";
		while(itr.hasNext()){
			Work+=itr.next();
			if(itr.hasNext()){
				Work+=", ";
			}
		}
		return Work;
	}
	
	public void setWorkedAt(String[] worked) {
		for(int i=0; i<worked.length; i++){
			this.workedAt.add(worked[i]);
		}
	}
	
	public String getMovies() {
		Iterator<String> itr = movies.iterator();
		String Films = "";
		while(itr.hasNext()){
			Films+=itr.next();
			if(itr.hasNext()){
				Films+=", ";
			}
		}
		return Films;
	}
	
	public void setMovies(String[] Films) {
		for(int i=0; i<Films.length; i++){
			this.movies.add(Films[i]);
		}
	}
	public void setGroupCode(String code){
		this.groupCode = code;
	}
	public String getGroupCode() {
		return groupCode;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public boolean equals(Object obj) {
		Person other = (Person) obj;
		return (this.identifier == other.identifier);
	}
		
	@Override
	public String toString() {
		return this.name + " " + this.fSurname + " " + this.sSurname + " (" + this.identifier + ")";
		
	}

	@Override
	public int compareTo(Object anobject) {
		Person otherPersonObject = (Person)anobject;
		if (this.equals(otherPersonObject))
			return 0;
		return (this.identifier.compareTo(otherPersonObject.identifier));
	}

	public String print() {
		if (sSurname == ""){
			return (this.identifier + "," + this.name + "," + this.fSurname +
					"," + this.birthDay + "-" + this.birthMonth 
					+ "-" + this.birthYear + "," + this.gender + "," + this.birthplace + "," 
					+ this.home + "," + this.getStudiedAt() + "," + this.getWorkedAt() + "," 
					+ this.getMovies() + "," + this.groupCode);
		}else{
			return (this.identifier + "," + this.name + "," + this.fSurname +
					"-" + this.sSurname  + "," + this.birthDay + "-" + this.birthMonth 
					+ "-" + this.birthYear + "," + this.gender + "," + this.birthplace + "," 
					+ this.home + "," + this.getStudiedAt() + "," + this.getWorkedAt() + "," 
					+ this.getMovies() + "," + this.groupCode);
		}
	}
}
	
