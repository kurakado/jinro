package system;

import object.Village;

public class Server {
	static private Village[] village_list;
	
	public static Village[] get_village_list(){
		return village_list;
	}
	
	public static boolean add_village(Village _village){
		village_list[village_list.length]=_village;
		return true;
	}
	
}
