package yakushoku;

public class Youko extends Charactor {
	public Youko(){
		this("");
	}

	public Youko(String namae) {
		super(namae);
		uranai_result="村人";
		reinou_result="村人";
		jinei="妖狐";
		yaku="妖狐";
	}
	
	@Override
	public String get_uranai_result(){
		set_dead();
		return uranai_result;
	}
	
	@Override
	public boolean bited(){
		boolean result=false;
		return result;
	}
}
