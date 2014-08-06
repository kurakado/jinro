package yakushoku;

import system.Queue;

public class Uranaishi extends Charactor {

	public  Uranaishi(){
		this("");
	}
	
	public Uranaishi(String namae){
		super(namae);
		uranai_result="村人";
		reinou_result="村人";
		jinei="村人";
		yaku="占い師";
	}
	
	public String uranai(Charactor cha){
		Queue.push(this,"uranai",cha);
		return cha.get_uranai_result();
	}
	
}
