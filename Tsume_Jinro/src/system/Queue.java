package system;

import yakushoku.Charactor;

public class Queue {
	static private String[] name;
	static private String[] action;
	static private String[] target;
	static public int length=0;
	Queue(){}
	
	public static void push(Charactor cha,String _action,Charactor _target){
		name[name.length ]= cha.get_name();
		action[action.length  ]=_action;
		target[target.length]=_target.get_name();
		length++;
	}
	
	public static String[] get(int fig){
		String[] set=new String[3];
		set[0]=name[fig-1];
		set[1]=action[fig-1];
		set[2]=target[fig-1];
		return set;
	}
}
