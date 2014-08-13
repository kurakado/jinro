package object;

import java.io.File;

public class Account {
	private String id;
	private String password;
	private File user_file;
	
	public Account(String _id,String _password){
		id=_id;
		password=_password;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
	public File getUser_file() {
		return user_file;
	}

	public void setUser_file(File user_file) {
		this.user_file = user_file;
	}

	public boolean delete(){
		if(this.user_file==null){
			System.out.println("there is no user_file.");
			return false;
		}
		if(!(this.user_file.delete())){
			System.out.println(user_file.getAbsolutePath()+"could not be delete.");
			return false;
		}
		return true;
	}
}
