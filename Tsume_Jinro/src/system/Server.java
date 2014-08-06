package system;

import java.util.ArrayList;

import object.Village;

public class Server {
	static private ArrayList<Village> village_list=new ArrayList<Village>(1);
//	static private Village[] village_list;
	static private int village_number;
	
	public static ArrayList<Village> get_village_list(){
		return village_list;
	}
	
	public static int add_village(Village _village){
		village_list.add(_village);
		village_number++;
		return village_number;
	}
	
	public static int get_number(Village vill){
		return 0;
	}
	
}
