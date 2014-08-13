package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
	public static boolean write(String file_name,String message){
		try{
			  File file = new File("c:¥¥tmp¥¥test.txt");
			  FileWriter filewriter = new FileWriter(file);
			}catch(IOException e){
			  System.out.println(e);
			}
		return true;
	}
}
