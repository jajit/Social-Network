package project;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import DSA.DoubleOrderedList;

public class FriendList {
	private DoubleOrderedList<String> list = new DoubleOrderedList<String>();
	private String path2Friends = "friends.txt";
	private PersonList Plist = new PersonList();
	
	public void initFriends() throws IOException{
		File input = new File(path2Friends);
		if(!input.exists()){
			input.createNewFile();
			PrintWriter wrt = new PrintWriter(input);
			wrt.println("friend1,friend2");
			wrt.close();
		}else{
			updateFriends(input);
		}
	}
	public void updateFriends(File input) throws IOException {
		Scanner read = new Scanner(input);
		String data;
		String[] tokens;
		read.nextLine();
		Plist.initialize();
		while (read.hasNextLine()){
			data = read.nextLine();
			System.out.println(data);
			tokens = data.split(",");
			if (Plist.contains(new Person(tokens[0])) && Plist.contains(new Person(tokens[1]))){
				list.add(data);
			}
		}
		read.close();
		PrintWriter wrt = new PrintWriter(new File (path2Friends));
		wrt.println("friend1,friend2");
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()){
			wrt.println(itr.next());
		}
		wrt.close();
	}

}
