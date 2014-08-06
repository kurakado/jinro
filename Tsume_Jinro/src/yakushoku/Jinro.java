package yakushoku;

import system.Queue;

public class Jinro extends Charactor {
	public Jinro(){
		this("");
	}
	
	public Jinro(String namae){
		super(namae);
		uranai_result="人狼";
		reinou_result="人狼";
		jinei="人狼";
		yaku="人狼";
	}
	
	@Override
	public boolean bited(){
		boolean result=false;
		return result;
	}

	protected void bite(Charactor cha){
		Queue.push(this,"bite",cha);
	}
}
