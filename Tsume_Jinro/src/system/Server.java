package system;

import java.util.HashMap;

import object.Village;

public class Server {
	static private HashMap<Integer,Village> village_list=new HashMap<Integer,Village>(1);
//	static private Village[] village_list;
	static private int village_number=0;
	
	public static HashMap<Integer,Village> get_village_list(){
		return village_list;
	}
	
	public static int add_village(Village _village){
		village_number++;
		village_list.put(village_number,_village);
		return village_number;
	}
	
	public static int get_number(Village vill){
		return 0;
	}
	
}
