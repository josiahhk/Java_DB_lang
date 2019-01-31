/*
Elijah Gonzales 725000232
Josiah Hamid-Khani 725003646
Joseph Hernandez 825002632
CSCE 313-505
October 16, 2018
Attribute.java
*/
public class Attribute{
	String name;
	String dt;
	int size;
	boolean isPrimKey;
	
	
	public Attribute(String n, String d, int s, boolean b){
		name = n;
		dt = d;
		if(d == "INTEGER")
			size = 0;
		else size = s;
		isPrimKey = b;
	}
	
	public Attribute(String n, String d, String s){
		name = n;
		dt = d;
		size = Integer.parseInt(s);
		isPrimKey = false;
	}


	public Attribute(String n, String d){
		name = n;
		dt = d;
		size = 0;
		isPrimKey = false;
	}
	
	public Attribute(){
		name = "";
		dt = "VARCHAR";
		size = 0;
		isPrimKey = false;
	}
	
	
	
	public String getDt(){return dt;}
	public int getSize(){return size;}
	public String getName(){return name;}
	public boolean getPK(){return isPrimKey;}
	public void setName(String s){name = s;}
	public void setDT(String s){dt = s;}
	public void setSize(String s){size = Integer.parseInt(s);}
	public void setPrimKey(boolean b){isPrimKey = b;}
}