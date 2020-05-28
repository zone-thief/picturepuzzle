package cn.homework.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;


public class RankingList {
	/*
	private User currentUser;

	public RankingList(User currentUser) {
		super();
		this.currentUser = currentUser;
	}
	*/
	public ArrayList<User> readUserList() throws IOException {
		ArrayList<User> userList = new ArrayList<User>();
		
		FileReader fr = new FileReader("RankingList.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String curStr = "";
		while( (curStr = br.readLine()) != null) {
			//curStr = 用户名 分数
			String[] strArr = curStr.split(" ");
			
			User TempUser = new User(strArr[0], Integer.parseInt(strArr[1]));
			
			userList.add(TempUser);
		}
		
		br.close();
		fr.close();
		
		return userList;
	}
	
	
	public void writeUserList(ArrayList<User> userList) throws IOException {
		FileWriter fw = new FileWriter("RankingList.txt", false);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(User u : userList) {
			bw.write(u.getUsername() + " " + u.getScore() + "\n");
		}
		
		
		bw.close();
		fw.close();
	}
	
	
	

	
	
}
