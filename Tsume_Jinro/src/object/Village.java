package object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import system.Server;



@SuppressWarnings("serial")
public class Village implements Serializable {
	public int sankasha_id=0;
	private Sankasha GM;
	public HashMap<Integer,Sankasha> sankasha=new HashMap<Integer,Sankasha>();
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
	
	public Sankasha getGM() {
		return GM;
	}

	public void setGM(Sankasha gM) {
		GM = gM;
	}
	
	public int getNumber(){
		return this.number;
	}
	


	public int getSankasha_id() {
		return sankasha_id;
	}

	public void setSankasha_id(int sankasha_id) {
		this.sankasha_id = sankasha_id;
	}

	public HashMap<Integer, Sankasha> getSankasha() {
		return sankasha;
	}

	public void setSankasha(HashMap<Integer, Sankasha> sankasha) {
		this.sankasha = sankasha;
	}

	public ArrayList<String> getChat() {
		return chat;
	}

	public void setChat(ArrayList<String> chat) {
		this.chat = chat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMax_sankasha() {
		return max_sankasha;
	}

	public void setMax_sankasha(int max_sankasha) {
		this.max_sankasha = max_sankasha;
	}

	public int getMax_uranaishi() {
		return max_uranaishi;
	}

	public void setMax_uranaishi(int max_uranaishi) {
		this.max_uranaishi = max_uranaishi;
	}

	public int getMax_reinousha() {
		return max_reinousha;
	}

	public void setMax_reinousha(int max_reinousha) {
		this.max_reinousha = max_reinousha;
	}

	public int getMax_kyoyusha() {
		return max_kyoyusha;
	}

	public void setMax_kyoyusha(int max_kyoyusha) {
		this.max_kyoyusha = max_kyoyusha;
	}

	public int getMax_karyudo() {
		return max_karyudo;
	}

	public void setMax_karyudo(int max_karyudo) {
		this.max_karyudo = max_karyudo;
	}

	public int getMax_murabito() {
		return max_murabito;
	}

	public void setMax_murabito(int max_murabito) {
		this.max_murabito = max_murabito;
	}

	public int getMax_kyojin() {
		return max_kyojin;
	}

	public void setMax_kyojin(int max_kyojin) {
		this.max_kyojin = max_kyojin;
	}

	public int getMax_jinro() {
		return max_jinro;
	}

	public void setMax_jinro(int max_jinro) {
		this.max_jinro = max_jinro;
	}

	public int getMax_youko() {
		return max_youko;
	}

	public void setMax_youko(int max_youko) {
		this.max_youko = max_youko;
	}

	public int getFig_sankasha() {
		return fig_sankasha;
	}

	public void setFig_sankasha(int fig_sankasha) {
		this.fig_sankasha = fig_sankasha;
	}

	public int getFig_uranaishi() {
		return fig_uranaishi;
	}

	public void setFig_uranaishi(int fig_uranaishi) {
		this.fig_uranaishi = fig_uranaishi;
	}

	public int getFig_reinousha() {
		return fig_reinousha;
	}

	public void setFig_reinousha(int fig_reinousha) {
		this.fig_reinousha = fig_reinousha;
	}

	public int getFig_kyoyusha() {
		return fig_kyoyusha;
	}

	public void setFig_kyoyusha(int fig_kyoyusha) {
		this.fig_kyoyusha = fig_kyoyusha;
	}

	public int getFig_karyudo() {
		return fig_karyudo;
	}

	public void setFig_karyudo(int fig_karyudo) {
		this.fig_karyudo = fig_karyudo;
	}

	public int getFig_murabito() {
		return fig_murabito;
	}

	public void setFig_murabito(int fig_murabito) {
		this.fig_murabito = fig_murabito;
	}

	public int getFig_kyojin() {
		return fig_kyojin;
	}

	public void setFig_kyojin(int fig_kyojin) {
		this.fig_kyojin = fig_kyojin;
	}

	public int getFig_jinro() {
		return fig_jinro;
	}

	public void setFig_jinro(int fig_jinro) {
		this.fig_jinro = fig_jinro;
	}

	public int getFig_youko() {
		return fig_youko;
	}

	public void setFig_youko(int fig_youko) {
		this.fig_youko = fig_youko;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean sanka(Sankasha person){
		if (max_sankasha>fig_sankasha){
			fig_sankasha++;
			person.setId(sankasha_id);
			sankasha_id++;
			System.out.println("dbg:"+person.name);
			sankasha.put(person.getId(),person);
		}else{
			return false;
		}
		
		
		if((person.kibo_yaku.equals("村人") &&  max_murabito<=fig_murabito)
				|| (person.kibo_yaku.equals("占い師") && max_uranaishi<=fig_uranaishi)
				|| (person.kibo_yaku.equals("霊能者") && max_reinousha<=fig_reinousha)
				|| (person.kibo_yaku.equals("人狼") && max_jinro<=fig_jinro)
				|| (person.kibo_yaku.equals("共有者") && max_kyoyusha<=fig_kyoyusha)
				|| (person.kibo_yaku.equals("妖狐") && max_youko<=fig_youko)
				|| (person.kibo_yaku.equals("狩人") && max_karyudo<=fig_karyudo)
				|| (person.kibo_yaku.equals("狂人") && max_kyojin<=fig_kyojin)
				|| (person.kibo_yaku.equals("無し"))
				){
			person.yaku="無職";
			System.out.println("dbg:mushoku");
		} else {
			person.yaku=person.kibo_yaku;
				if(person.kibo_yaku=="村人"){
					System.out.println("dbg:村人");
					fig_murabito++;
				}else if (person.kibo_yaku.equals("占い師")){
					System.out.println("dbg:占い師");
					fig_uranaishi++;
				}else if (person.kibo_yaku.equals("霊能者")){
					System.out.println("dbg:霊能者");
					fig_reinousha++;
				}else if (person.kibo_yaku.equals("人狼")){
					System.out.println("dbg:人狼");
					fig_jinro++;
				}else if (person.kibo_yaku.equals("共有者")){
					System.out.println("dbg:共有者");
					fig_kyoyusha++;
				}else if (person.kibo_yaku.equals("妖狐")){
					System.out.println("dbg:妖狐");
					fig_youko++;
				}else if (person.kibo_yaku.equals("狩人")){
					System.out.println("dbg:狩人");
					fig_karyudo++;
				}else if (person.kibo_yaku.equals("狂人")){
					System.out.println("dbg:狂人");
					fig_kyojin++;
				}
			System.out.println("dbg:"+person.yaku);
		}
		
		return true;
	}
	
	public boolean dattai(Sankasha person){
		boolean result = sankasha.containsKey(person);
		if (result==false){
			System.out.println("存在しない参加者です。");
			return false;
		}
		Sankasha result_remove =sankasha.remove(person.getId());
		if (result_remove==null){
			return false;
		}
		return true;
	}
}
