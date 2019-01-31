/*
Elijah Gonzales 725000232
Josiah Hamid-Khani 725003646
Joseph Hernandez 825002632
CSCE 313-505
October 10, 2018
TableTester.java

*/

import java.util.*;
import java.util.*;
import java.lang.*;
import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException;
public class TableTester{
	public static void main(String[] args){
	
	Attribute a1 = new Attribute("name", "VARCHAR", 20, true);
	Attribute a2 = new Attribute("kind", "VARCHAR", 8, true);
	Attribute a3 = new Attribute("years", "INTEGER", -1, false);
	
	ArrayList<Attribute> aList = new ArrayList<Attribute>();
	aList.add(a1);
	aList.add(a2);
	aList.add(a3);
	Table t1 = new Table("animals", aList);
	ArrayList<Object> r1 = new ArrayList<Object>();
	r1.add("Joe");
	r1.add("cat");
	r1.add(4);
	ArrayList<Object> r2 = new ArrayList<Object>();
	r2.add("Spot");
	r2.add("dog");
	r2.add(10);
	ArrayList<Object> r3 = new ArrayList<Object>();
	r3.add("Doug");
	r3.add("dog");
	r3.add(7);
	t1.insertCom(r1);
	t1.insertCom(r2);
	t1.insertCom(r3);
	Table t2;
	t2 = t1.selectQuery("dog", "kind", "age", "==");
	//t2.exit_command();
	//t1.deleteCommand("dog", "kind", "!=");
	//t1.showCommand();
	//t2.showCommand();
	try{t2.open("test.db");}
	catch(Exception e) {};
	//t1.showCommand();
	t2.showCommand();
	
	
	}
}
