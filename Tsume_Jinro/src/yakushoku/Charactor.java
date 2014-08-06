package yakushoku;

public abstract class Charactor {
	public static int count_Human = 0;
	//生死判定フラグ
	int dead;
	//CN
	String name;
	//占い判定
	String uranai_result="";
	//霊能判定
	String reinou_result="";
	//陣営
	String jinei="";
	//役職名
	public String yaku="";
	
	//コンストラクタ
	protected Charactor(String namae){
		name=namae;
		set_alive();
		count_Human++;
	}
	
	protected Charactor() {
		this("");
	}

	public void set_alive(){
		dead=0;
	}
	
	public boolean bited(){
		boolean result=true;
		set_dead();
		return result;
	}
	
	public void set_dead(){
		System.out.println(name + "is dead.");
		dead=1;
	}
	
	public int get_dead(){
		return dead;
	}
	
	public String get_uranai_result(){
		return uranai_result;
	}
	
	public String get_name(){
		return name;
	}
	
}
