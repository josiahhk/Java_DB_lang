/*
Elijah Gonzales 725000232
Josiah Hamid-Khani 725003646
Joseph Hernandez 825002632
CSCE 313-505
October 10, 2018
DBTester.java
*/
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
public class DBTester{
	public static void main(String[] args) throws FileNotFoundException{
	
	/*	
	I tested exitCommand, I just didn't leave it in here because it would stop
	the program from running
	Varchars are implemented in insertCom in the table class (I've tested them too, 
	they work).
	*/
	try{
	Attribute a1 = new Attribute("name", "VARCHAR", 20, false);
	Attribute a2 = new Attribute("kind", "VARCHAR", 8, false);
	Attribute a3 = new Attribute("years", "INTEGER", 0, false);
	
	ArrayList<Attribute> aList = new ArrayList<Attribute>();
	aList.add(a1);
	aList.add(a2);
	aList.add(a3);
	
	DB dataBase = new DB();
	
	Table t3;
	ArrayList<Object> r1 = new ArrayList<Object>();
	r1.add("Joe");
	r1.add("Joe");
	r1.add(4);
	ArrayList<Object> r2 = new ArrayList<Object>();
	r2.add("Spot");
	r2.add("dog");
	r2.add(10);
	ArrayList<Object> r3 = new ArrayList<Object>();
	r3.add("Doug");
	r3.add("dog");
	r3.add(7);
	ArrayList<Object> r4 = new ArrayList<Object>();
	r4.add("Smug");
	r4.add("dog");
	r4.add(7);
	ArrayList<Object> r5 = new ArrayList<Object>();
	r5.add("Tweety");
	r5.add("bird");
	r5.add(7);
	ArrayList<Object> r6 = new ArrayList<Object>();
	r6.add("Tweety");
	r6.add("bird");
	r6.add(8);
	
	System.out.println("=============Create Test===============");
	System.out.println("Showing all tables in database before create (none)");
	dataBase.showAllTables();
	dataBase.createCommand("animals", aList);
	System.out.println("After create command");
	dataBase.showAllTables();
	System.out.println("================Insert Test=============");
	dataBase.insertCommand("animals", r1);
	dataBase.showTables("animals");
	dataBase.insertCommand("animals", r2);
	dataBase.insertCommand("animals", r3);
	System.out.println("After two more inserts");
	dataBase.showTables("animals");
	dataBase.createCommand("dogs", aList);
	dataBase.insertCommand("dogs", r4);
	dataBase.insertCommand("dogs", r5);
	System.out.println("================Project Test==============");
	ArrayList<String> att = new ArrayList<>();
	att.add("name");
	att.add("years");
	dataBase.projectQuery(att, "animals", "projectedTable");
	dataBase.showTables("projectedTable");
	/*
	System.out.println("==================Union Test===============");
	dataBase.union("animals", "dogs", "daa");
	dataBase.showTables("daa");
	
	System.out.println("===================Rename Test=================");
	ArrayList<String> s = new ArrayList<>();
	s.add("animals");
	s.add("age");
	System.out.println("Before rename");
	System.out.println(dataBase.db.get(1).header.get(0).getName() +" "+dataBase.db.get(1).header.get(1).getName() );
	dataBase.rename("dogs", s);
	System.out.println("After rename");
	System.out.println(dataBase.db.get(1).header.get(0).getName() +" "+dataBase.db.get(1).header.get(1).getName() );
	System.out.println("==================Update Test===================");
	dataBase.showTables("animals");
	dataBase.updateQuery("kind", "dog", "==", "animals", "years", 20);
	dataBase.showTables("animals");
	System.out.println("==================Product Test==================");
	dataBase.productQuery("animals", "dogs", "prodTest");
	dataBase.showTables("prodTest");
	System.out.println("==================Difference Test=================");
	*/
	//dataBase.showAllTables();
	dataBase.open("prodTest");
	//dataBase.showAllTables();
	

	dataBase.differenceQuery("prodTest", "dogs" ,"diffTest");
	dataBase.showTables("diffTest");
	System.out.println("=================Delete Test====================");
	dataBase.showTables("animals");
	dataBase.deleteCommand("kind", "dog", "==", "animals");
	dataBase.showTables("animals");
	
	System.out.println("==================Selection Test================");
	dataBase.showTables("daa");
	dataBase.selectQuery("years", "20", "==", "selectTest", "daa");
	dataBase.showTables("selectTest");
	System.out.println("==================Write Test===================");
	System.out.println("Look for file \"animals.db\"");
	dataBase.writeCommand("animals");
	
	
	}
	catch (FileNotFoundException ex){
	System.out.println(ex.toString());
	throw ex;
	}
	
	}
	
}
