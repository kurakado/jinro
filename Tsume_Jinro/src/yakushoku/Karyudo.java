package yakushoku;

import system.Queue;

public class Karyudo extends Charactor {
	public Karyudo(){
		this("");
	}
	
	public Karyudo(String namae){
		super();
		uranai_result="村人";
		reinou_result="村人";
		jinei="村人";
		yaku="狩人";
	}
	
	public void guard(Charactor cha){
		Queue.push(this,"guard",cha);
	}
}
