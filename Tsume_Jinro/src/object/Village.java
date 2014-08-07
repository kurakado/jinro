package object;

import java.util.ArrayList;

import system.Server;



public class Village {
	public ArrayList<Sankasha> sankasha=new ArrayList<Sankasha>();
	public ArrayList<String> chat=new ArrayList<String>();
	public int number=0;
	public String name="";
	private int max_sankasha=0;
	private int max_uranaishi=0;
	private int max_reinousha=0;
	private int max_kyoyusha=0;
	private int max_karyudo=0;
	private int max_murabito=0;
	private int max_kyojin=0;
	private int max_jinro=0;
	private int max_youko=0;
	private int fig_sankasha=0;
	private int fig_uranaishi=0;
	private int fig_reinousha=0;
	private int fig_kyoyusha=0;
	private int fig_karyudo=0;
	private int fig_murabito=0;
	private int fig_kyojin=0;
	private int fig_jinro=0;
	private int fig_youko=0;
	
	public Village(String _name,int[] _max){
		name=_name;
		number=Server.add_village(this);
		max_sankasha=_max[0];
		max_uranaishi=_max[1];
		max_reinousha=_max[2];
		max_kyoyusha=_max[3];
		max_karyudo=_max[4];
		max_murabito=_max[5];
		max_kyojin=_max[6];
		max_jinro=_max[7];
		max_youko=_max[8];
	}
	

	public boolean sanka(Sankasha person){
		if (max_sankasha>fig_sankasha){
			fig_sankasha++;
			System.out.println("dbg:"+person.name);
			sankasha.add(person);
		}else{
			return false;
		}
		
		
		if((person.kibo_yaku=="村人" && max_murabito==fig_murabito)
				|| (person.kibo_yaku=="占い師" && max_uranaishi==fig_uranaishi)
				|| (person.kibo_yaku=="霊能者" && max_reinousha==fig_reinousha)
				|| (person.kibo_yaku=="人狼" && max_jinro==fig_jinro)
				|| (person.kibo_yaku=="共有者" && max_kyoyusha==fig_kyoyusha)
				|| (person.kibo_yaku=="妖狐" && max_youko==fig_youko)
				|| (person.kibo_yaku=="狩人" && max_karyudo==fig_karyudo)
				|| (person.kibo_yaku=="狂人" && max_kyojin==fig_kyojin)
				|| (person.kibo_yaku=="無し")
				){
			person.yaku="無職";
			System.out.println("dbg:mushoku");
		} else {
			person.yaku=person.kibo_yaku;
				if(person.kibo_yaku=="村人"){
					fig_murabito++;
				}else if (person.kibo_yaku=="占い師"){
					fig_uranaishi++;
				}else if (person.kibo_yaku=="霊能者"){
					fig_reinousha++;
				}else if (person.kibo_yaku=="人狼"){
					fig_jinro++;
				}else if (person.kibo_yaku=="共有者"){
					fig_kyoyusha++;
				}else if (person.kibo_yaku=="妖狐"){
					fig_youko++;
				}else if (person.kibo_yaku=="狩人"){
					fig_karyudo++;
				}else if (person.kibo_yaku=="狂人"){
					fig_kyojin++;
				}
			System.out.println("dbg:"+person.yaku);
		}
		
		return true;
	}
	
	public boolean dattai(Sankasha person){
		boolean result = sankasha.contains(person);
		if (result==false){
			System.out.println("存在しない参加者です。");
			return false;
		}
		result = sankasha.remove(person);
		if (result==false){
			return false;
		}
		return true;
	}
	
}
