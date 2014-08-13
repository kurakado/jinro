package object;

import yakushoku.Charactor;

public class Sankasha {
	private int id;
	private Account account;
	public String name;
	private String password;
	public String kibo_yaku;
	public String yaku;
	public Charactor cha;
	
	public Sankasha(String _name,String _password){
		this.setName(_name);
		this.setPassword(_password);
	}
	
	public Sankasha(String _name,String _password,String _kibo_yaku){
		this.setName(_name);
		this.setPassword(_password);
		this.setKibo_yaku(_kibo_yaku);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKibo_yaku() {
		return kibo_yaku;
	}

	public void setKibo_yaku(String kibo_yaku) {
		this.kibo_yaku = kibo_yaku;
	}

	public String getYaku() {
		return yaku;
	}

	public void setYaku(String yaku) {
		this.yaku = yaku;
	}

	public Charactor getCha() {
		return cha;
	}

	public void setCha(Charactor cha) {
		this.cha = cha;
	}


}
