package project;

import java.io.*;
import java.util.*;

import javax.swing.DefaultListModel;

import DSA.DoubleOrderedList;

public class PersonList {
	public int count;
	private DoubleOrderedList<Person> list = 
			new DoubleOrderedList<Person>();
	private String path2File = "people.txt";
	
	public void initialize() throws IOException{
		File input = new File(path2File);
		if(!input.exists()){
			input.createNewFile();
			PrintWriter wrt = new PrintWriter(input);
			wrt.println("idperson,name,lastname,birthdate,"
					+"gender,birthplace,home,studiedat,"
					+"workplaces,films,groupcode");
			wrt.close();
		}else{
			updateList(input);
		}
		
	}
	private void addPerson(Person P){
		if (!contains(P)){
			list.add(P);
			count++;
		}
	}
	public void updateList(File inputFile) throws FileNotFoundException{
		Scanner read = new Scanner(inputFile);
		read.nextLine();
		String data;
		while(read.hasNextLine()){
			data = read.nextLine();
			addPerson(createPerson(data));
		}
		read.close();
		PrintWriter wrt = new PrintWriter(new File (path2File));
		wrt.println("idperson,name,lastname,birthdate,"
				+"gender,birthplace,home,studiedat,"
				+"workplaces,films,groupcode");
		Iterator<Person> itr = list.iterator();
		while(itr.hasNext()){
			wrt.println(itr.next().print());
		}
		wrt.close();
	}

	private Person createPerson(String input) {
		/*Split the input*/
		String[] Data = input.split(",");
		String identifier = Data[0];
		String name = Data[1];
		String[] surnames = Data[2].split("-");
		String[] birth= Data[3].split("-");
		int birthDay = Integer.valueOf(birth[0]);
		int birthMonth = Integer.valueOf(birth[1]);
		int birthYear = Integer.valueOf(birth[2]);
		String gender = Data[4];
		String birthplace = Data[5];
		String home = Data[6];
		String[] Studied = Data[7].split(";");
		String[] work = Data[8].split(";");
		String[] films = Data[9].split(";");
		String groupCode = Data[10];
		
		/*Create the person*/
		Person P = new Person(identifier);
		P.setBirthdate(birthDay, birthMonth, birthYear);
		P.setBirthplace(birthplace);
		P.setGender(gender);
		P.setGroupCode(groupCode);
		P.setHome(home);
		P.setMovies(films);
		P.setName(name);
		P.setStudiedAt(Studied);
		P.setSurnames(surnames);
		P.setWorkedAt(work);	
		
		return P;
	}
	public DefaultListModel<String> populate(){
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		Iterator<Person> itr = list.iterator();
		while(itr.hasNext()){
			listModel.addElement(itr.next().toString());
		}
		return listModel;
	}
	public Person find (int Index) {
		Iterator<Person> itr = list.iterator();
		int i=0;
		while(itr.hasNext() && i<Index){
			itr.next();
			i++;
		}
		return itr.next();
	}
	public boolean contains(Person P){
		Iterator<Person> itr = list.iterator();
		boolean found =false;
		String other;
		while(itr.hasNext()&&!found){
			other = itr.next().getIdentifier();
			found = other.equals(P.getIdentifier());
		}
		return found;
	}
	
	
	
}
