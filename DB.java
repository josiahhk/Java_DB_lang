/*
Elijah Gonzales 725000232
Josiah Hamid-Khani 725003646
Joseph Hernandez 825002632
CSCE 313-505
October 16, 2018
DB.java
*/


import java.util.*;
import java.io.*;
import java.lang.String;
public class DB{
	ArrayList<Table> db = new ArrayList<>();
	Deque<Table> stack = new ArrayDeque<Table>();
	public Stack s = new Stack();
	public ArrayList<Table> getDB(){return db;}
	
	public void createCommand(String name,  ArrayList<Attribute> h){
		Table t1 = new Table(name, h);
		db.add(t1);	
	}
	
	
	//adds a table to the database
	public void addTable(Table t){
		db.add(t);
	}
	
	
	//shows all tables in the database
	public void showAllTables(){
		for(int i = 0; i < db.size(); i++){
			System.out.println(db.get(i).getName()+":");
			db.get(i).showCommand();
			System.out.println();
		}
	}

	
	//shows a table, specified by its name
	public void showTables(String relation){
		for(int i = 0; i < db.size(); i++){
			if(db.get(i).getName().equals(relation)){
				System.out.println(db.get(i).getName()+":");
				db.get(i).showCommand();
				return;
			}
		}
		System.out.println("Table not found: "+relation);
	}

	//assigns a name to whatever item is in the stack and adds that new relation to the db
	//Overwrites old db values if the name is the same
	public void query(String relationName, String relation2){
		
		Table t3 = null;
		for(int i = 0; i < db.size(); i++)
			if((db.get(i).getName()).equals(relation2)){
				t3  = db.get(i);
				t3.setName(relationName);
				t3.header = db.get(i).header;
			}
			
		if(t3 == null){
		
			boolean isDup = false;
			if(stack.size() == 0){
				System.out.println("Stack is empty: query");
				return;
			}
		
		
		for(int i = 0; i < db.size(); i++)
			if(db.get(i).getName().equals(relationName)){
				db.set(i, stack.pop());
				isDup = true;
			}
		if(isDup == false){
			Table t2 = stack.pop();
			Table t1 = new Table(relationName, t2.header);
			t1.setRows(t2.getRows());
			addTable(t1);
		}
	}
	}
		
	
	//inserts an arrayList of objects (a row basically) into a table, whose name is given by n
	public void insertCommand(String n, ArrayList<String> r){
		for(int i = 0; i < db.size(); i++)
			if(db.get(i).getName().equals(n))
				db.get(i).insertComSafe(r);
	}
	
	
	/*basically select but with columns. Takes a string for the name of the first table
	a string for the name of the new projected table, and a list of strings containing the
	names of the attributes you want to project into the new table
	*/
	public void projectQuery(ArrayList<String> col, String relation1){
		ArrayList<Attribute> newHead = new ArrayList<>();
		ArrayList<Integer> index = new ArrayList<>();
		Table t1 = null; 
		int size = 0;
		for(int i = 0; i < db.size(); i++)
			if(db.get(i).getName().equals(relation1))
				t1 = db.get(i);
		if(t1 == null)
			if(stack.size() != 0)
				t1 = stack.pop();
			else{
				System.out.println("Nothing in stack: project");
				return;
			}
		
		for(int i = 0; i < t1.header.size(); i++)
			for(int j = 0; j < col.size(); j++){
				if(t1.header.get(i).getName().equals(col.get(j))){
					newHead.add(t1.header.get(i));
					index.add(i);
					break;
				}
			}
			
		if(newHead.size() > 0){
			Table t2 = new Table("", newHead);
			for(int j = 0; j < t1.rows.size(); j++){
				ArrayList<String> newTable = new ArrayList<>();
				for(int i = 0; i < newHead.size(); i++){ //correct
					newTable.add(t1.rows.get(j).get(index.get(i)));
				}
				t2.insertComSafe(newTable);
			}
			stack.push(t2);
		}
			
	}	
	

	/*
	Adds all non-duplicate values from table t1 and table t2 to a new table whose name
	is given by a String
	*/
	public void union(String relation1, String relation2){
		Table t1 = null;
		Table t2 = null;
		for(int i = 0; i < db.size(); i++){
			if(db.get(i).name.equals(relation1))
				t1 = db.get(i);
			if(db.get(i).name.equals(relation2))
				t2 = db.get(i);
		}
		if(t1 == null){
			if(stack.size() != 0)
				t1 = stack.removeFirst();
			else{
				System.out.println("Table 1 not found in union");
				return;
			}
		}
		if(t2 == null){
			if(stack.size() != 0)
				t2 = stack.removeFirst();
			else{
				System.out.println("Table 2 not found in union");
				return;
			}
		}
	
			Table rtnTable = new Table("", t1.header);
			if(t1.header.size() != t2.header.size()){
				System.out.print("The given relations must have the same number of columns ");
				System.out.println("in order for union to be performed on them");
				return;
			}
			for(int i = 0; i < t1.header.size(); i++)
				if(!(t1.header.get(i).dt.equals(t2.header.get(i).dt))){
					System.out.println("The two relations must have the same attributes for union to be performed");
					return;
				}
			for(int i = 0; i < t1.rows.size(); i++)
				rtnTable.insertComSafe(t1.rows.get(i));
			for(int i = 0; i < t2.rows.size(); i++){
				boolean notDup = true;
				for(int j = 0; j < rtnTable.rows.size(); j++){
					if(t2.rows.get(i) == rtnTable.rows.get(j))
						notDup = false;
				}
					if(notDup)
						rtnTable.insertComSafe(t2.rows.get(i));
			}
			stack.push(rtnTable);
	}
	
	
	
	
	//Renames the attributes in a given table and completely overwrites the old tables
	public void rename(String relation1, ArrayList<String> s){
		Table t1 = null;
		for(int i = 0; i < db.size(); i++){
			if((db.get(i).getName()).equals(relation1))
				t1 = db.get(i);
		}
		if(t1 == null){
			if(stack.size() != 0)
				t1 = stack.pop();
			else{
				System.out.println("Stack does not have any items in it");
				System.out.println("Called from: rename");
				return;
			}
		}
		ArrayList<Attribute> temp = new ArrayList<>();
		for(int i = 0; i < t1.header.size(); i++){
			Attribute tempAtt = new Attribute(t1.header.get(i).getName(),t1.header.get(i).getDt(), 
			t1.header.get(i).getSize(), t1.header.get(i).getPK());
			temp.add(tempAtt);
		}
			
		Table t2 = new Table(t1.getName(), temp);		
		if(s.size() < t1.header.size())
			for(int i = 0; i < s.size(); i++)
				t2.header.get(i).setName(s.get(i));
		else{
			for(int i = 0; i < t1.header.size(); i++)
				t2.header.get(i).setName(s.get(i));
		}
		
		t2.setRows(t1.getRows());
		stack.push(t2);
	}
	
	/*
	Takes 1 condition by way of lhs, rhs, and op, takes 1 table to update,
	a string to determine what attribute to update, and an object to update that attribute to
	*/
	public void updateQuery(String lhs, String rhs, String op, String relation1, String upName, String upTo){
		boolean left = false;
		boolean right = false;
		int leftColIndex = 0;
		int rightColIndex = 0;
		String typeLeft = "";
		String typeRight = "";
		int convertedLeftInt=0;
		int convertedRightInt=0;
		int convertedUpTo = 0;
		int updateIndex = 0;
		Table t = null;
		
		for(int i = 0; i < db.size(); i++){
			if(db.get(i).name.equals(relation1))
				t = db.get(i);
		}
		
		for(int i = 0; i < t.header.size(); i++)
			if(t.header.get(i).getName().equals(upName)){
				updateIndex = i;
			}
		
		for(int i = 0; i < t.header.size(); i++){
			if(t.header.get(i).getName().equals(lhs)){
				left = true;
				leftColIndex = i;
				typeLeft = t.header.get(leftColIndex).getDt();
			}
			if(t.header.get(i).getName().equals(rhs)){
				right = true;
				rightColIndex = i;
				typeRight = t.header.get(rightColIndex).getDt();
			}
		}
		if(left == true && right == true)
			if(!(typeLeft.equals(typeRight))){
				System.out.println("Cannot compare different types");
				return;
		}
		
		if(upTo.substring(0, 1).equals("1") || upTo.substring(0, 1).equals("2") || upTo.substring(0, 1).equals("3") ||
				upTo.substring(0, 1).equals("4") || upTo.substring(0, 1).equals("5") || upTo.substring(0, 1).equals("6") ||
				upTo.substring(0, 1).equals("7") || upTo.substring(0, 1).equals("8") ||upTo.substring(0, 1).equals("9")){
				convertedUpTo = Integer.parseInt(upTo);
		}		
		
		if(lhs.substring(0, 1).equals("1") || lhs.substring(0, 1).equals("2") || lhs.substring(0, 1).equals("3") ||
				lhs.substring(0, 1).equals("4") || lhs.substring(0, 1).equals("5") || lhs.substring(0, 1).equals("6") ||
				lhs.substring(0, 1).equals("7") || lhs.substring(0, 1).equals("8") ||lhs.substring(0, 1).equals("9")){
				convertedLeftInt = Integer.parseInt(lhs);
		}

		if(rhs.substring(0, 1).equals("1") || rhs.substring(0, 1).equals("2") || rhs.substring(0, 1).equals("3") ||
				rhs.substring(0, 1).equals("4") || rhs.substring(0, 1).equals("5") || rhs.substring(0, 1).equals("6") ||
				rhs.substring(0, 1).equals("7") || rhs.substring(0, 1).equals("8") || rhs.substring(0, 1).equals("9")){
				convertedRightInt = Integer.parseInt(rhs);
		}
		
		
		
		if(op.equals("==")){
			if(left == true && right == true){
				if(typeLeft.equals("INTEGER")){
					for(int j = t.rows.size()-1; j >=0; j--)
						if(Integer.parseInt(t.rows.get(j).get(leftColIndex)) == Integer.parseInt(t.rows.get(j).get(rightColIndex)))
							(t.rows.get(j)).set(updateIndex, upTo);
						
				}
			
				else{
					for(int j = 0; j < t.rows.size(); j++){
						if(((t.rows.get(j).get(leftColIndex))).equals((t.rows.get(j).get(rightColIndex))))
							t.rows.get(j).set(updateIndex, upTo);
					}
				}
			}
			else if(right == true){
				if(typeRight.equals("INTEGER")){
					for(int j = t.rows.size()-1; j >=0; j--)
						if(Integer.parseInt(t.rows.get(j).get(rightColIndex)) == convertedLeftInt)
							t.rows.get(j).set(updateIndex, upTo);
						
				}
				else{
					for(int j = 0; j < t.rows.size(); j++)
						if(t.rows.get(j).get(rightColIndex).equals(lhs))
							t.rows.get(j).set(updateIndex, upTo);
				}
			}
			else if(left == true){
				if(typeLeft.equals("INTEGER")){
					for(int j = t.rows.size()-1; j >=0; j--){
						if(Integer.parseInt(t.rows.get(j).get(leftColIndex)) == convertedRightInt){
							t.rows.get(j).set(updateIndex, upTo);
						}
					}
				}
				else{
					for(int j = 0; j < t.rows.size(); j++)
						if((t.rows.get(j).get(leftColIndex)).equals(rhs))
							t.rows.get(j).set(updateIndex, upTo);
				}
			}
		}
		else if(op.equals("!=")){
			if(left == true && right == true){
				if(typeLeft.equals("INTEGER")){
					for(int j = t.rows.size()-1; j >=0; j--)
						if(Integer.parseInt(t.rows.get(j).get(leftColIndex)) != Integer.parseInt(t.rows.get(j).get(rightColIndex)))
							(t.rows.get(j)).set(updateIndex, upTo);
						}
				else{
					for(int j = 0; j < t.rows.size(); j++){
						if(!((t.rows.get(j).get(leftColIndex))).equals((t.rows.get(j).get(rightColIndex))))
							t.rows.get(j).set(updateIndex, upTo);
					}
				}
			}
			else if(right == true){
				if(typeRight.equals("INTEGER")){
					for(int j = t.rows.size()-1; j >=0; j--)
						if(Integer.parseInt(t.rows.get(j).get(rightColIndex)) != convertedLeftInt)
							t.rows.get(j).set(updateIndex, upTo);
						
				}
				else{
					for(int j = 0; j < t.rows.size(); j++)
						if(!(t.rows.get(j).get(rightColIndex).equals(lhs)))
							t.rows.get(j).set(updateIndex, upTo);
				}
			}
			else if(left == true){
				if(typeLeft.equals("INTEGER")){
					for(int j = t.rows.size()-1; j >=0; j--){
						if(Integer.parseInt(t.rows.get(j).get(leftColIndex)) != convertedRightInt){
							t.rows.get(j).set(updateIndex, upTo);
						}
					}
				}
				else{
					for(int j = 0; j < t.rows.size(); j++)
						if(!(t.rows.get(j).get(leftColIndex)).equals(rhs))
							t.rows.get(j).set(updateIndex, upTo);
				}
			}			
		}
		else if(op.equals("<")){
			if(left == true && right == true){
				for(int j = t.rows.size()-1; j >=0; j--)
					if(Integer.parseInt(t.rows.get(j).get(leftColIndex)) < Integer.parseInt(t.rows.get(j).get(rightColIndex)))
						t.rows.get(j).set(updateIndex, upTo);
			}		
			else if(left == true){
				for(int j = t.rows.size()-1; j >=0; j--){
					if(Integer.parseInt(t.rows.get(j).get(leftColIndex)) < convertedRightInt)
						t.rows.get(j).set(updateIndex, upTo);
				}
			}
			else if(right == true){
				for(int j = t.rows.size()-1; j >=0; j--)
					if(Integer.parseInt(t.rows.get(j).get(rightColIndex)) < convertedLeftInt)
						t.rows.get(j).set(updateIndex, upTo);
		
						}		
		}
		else if(op.equals(">")){
			if(left == true && right == true){
				for(int j = t.rows.size()-1; j >=0; j--)
					if(Integer.parseInt(t.rows.get(j).get(leftColIndex)) > Integer.parseInt(t.rows.get(j).get(rightColIndex)))
						t.rows.get(j).set(updateIndex, upTo);
			}		
			else if(left == true){
				for(int j = t.rows.size()-1; j >=0; j--)
					if(Integer.parseInt(t.rows.get(j).get(leftColIndex)) > convertedRightInt)
						t.rows.get(j).set(updateIndex, upTo);
			}
			else if(right == true){
				for(int j = t.rows.size()-1; j >=0; j--)
					if(Integer.parseInt(t.rows.get(j).get(rightColIndex)) > convertedLeftInt)
						t.rows.get(j).set(updateIndex, upTo);
			}		
		}
		else if(op.equals("<=")){
			if(left == true && right == true){
				for(int j = t.rows.size()-1; j >=0; j--)
					if(Integer.parseInt(t.rows.get(j).get(leftColIndex)) <= Integer.parseInt(t.rows.get(j).get(rightColIndex)))
						t.rows.get(j).set(updateIndex, upTo);
			}		
			else if(left == true){
				for(int j = t.rows.size()-1; j >=0; j--)
					if(Integer.parseInt(t.rows.get(j).get(leftColIndex)) <= convertedRightInt)
						t.rows.get(j).set(updateIndex, upTo);
			}
			else if(right == true){
				for(int j = t.rows.size()-1; j >=0; j--)
					if(Integer.parseInt(t.rows.get(j).get(rightColIndex)) <= convertedLeftInt)
						t.rows.get(j).set(updateIndex, upTo);
			}		
		}
		else{
			if(left == true && right == true){
				for(int j = t.rows.size()-1; j >=0; j--)
					if(Integer.parseInt(t.rows.get(j).get(leftColIndex)) >= Integer.parseInt(t.rows.get(j).get(rightColIndex)))
						t.rows.get(j).set(updateIndex, upTo);
			}		
			else if(left == true){
				for(int j = t.rows.size()-1; j >=0; j--)
					if(Integer.parseInt(t.rows.get(j).get(leftColIndex)) >= convertedRightInt)
						t.rows.get(j).set(updateIndex, upTo);
			}
			else if(right == true){
				for(int j = t.rows.size()-1; j >=0; j--)
					if(Integer.parseInt(t.rows.get(j).get(rightColIndex)) >= convertedLeftInt)
						t.rows.get(j).set(updateIndex, upTo);
			}		
		}
	}

	/*
	Maps every tuple/row of t1 onto one tuple/row of t2 for every value in 
	t2, stores in new relation whose name is given by a String
	*/
	public void productQuery(String relation1, String relation2){
		Table t1 = null;
		Table t2 = null;
		for(int i = 0; i < db.size(); i++){
			if(db.get(i).name.equals(relation1))
				t1 = db.get(i);
			if(db.get(i).name.equals(relation2))
				t2 = db.get(i);
		}
		if(t1 == null){
			if(stack.size() != 0)
				t1 = stack.pop();
			else{
				System.out.println("Stack does not have any items in it");
				System.out.println("Called from: product");
				return;
			}
		}		
		if(t2 == null){
			if(stack.size() != 0)
				t2 = stack.pop();
			else{
				System.out.println("Stack does not have any items in it");
				System.out.println("Called from: product");
				return;
			}
		}
		
		ArrayList<Attribute> rtnAL = new ArrayList<>();
		for(int i = 0; i < t2.header.size(); i++){
			Attribute tempAtt = new Attribute(t2.header.get(i).getName(), t2.header.get(i).getDt(), 
			t2.header.get(i).getSize(), t2.header.get(i).getPK());
			rtnAL.add(tempAtt);
		}
		for(int i = 0; i < t1.header.size(); i++){
			Attribute tempAtt = new Attribute(t1.header.get(i).getName(), t1.header.get(i).getDt(), 
			t1.header.get(i).getSize(), t1.header.get(i).getPK());
			rtnAL.add(tempAtt);
		}
		
		Table rtnTable = new Table("", rtnAL);
		for(int i = 0; i < t2.rows.size(); i++){
			for(int j = 0; j < t1.rows.size(); j++){
				ArrayList<String> tempRow = new ArrayList<>();
				for(int k = 0; k < t2.rows.get(i).size(); k++){
					tempRow.add(t2.rows.get(i).get(k)); 
				}
				for(int k = 0; k < t1.rows.get(j).size(); k++){
					tempRow.add(t1.rows.get(j).get(k));
				}
			rtnTable.insertComSafe(tempRow);	
			}	
		}
		stack.push(rtnTable);
	}
	
	/*
	This function compares two lists of objects to see if they are the same or not.
	Used in differenceQuery. Returns true if arrayLists are the same, false if not.
	*/
	public boolean compObj(ArrayList<String> o1, ArrayList<String> o2){
		int count = 0;
		ArrayList<Integer> index = new ArrayList<>();
		for(int i = 0; i < o1.size(); i++){
			for(int j = 0; j < o2.size(); j++){
				if(o1.get(i).equals(o2.get(j)))
					if(i == j){
						index.add(0);
						break;
					}	
			}
			index.add(1);
		}
		for(int i = 0; i < index.size(); i++)
			if(index.get(i) == 0)
				count++;
		if(count == o1.size())
			return true;
		else return false;
	}

	/*
	Takes all the values from t1 that aren't in t2 and stores them a in new table
	whose name is given by newName
	*/
	public void differenceQuery(String relation1, String relation2){
		Table t1 = null;
		Table t2 = null;
		for(int i = 0; i < db.size(); i++){
			if(db.get(i).name.equals(relation1))
				t1 = db.get(i);
			if(db.get(i).name.equals(relation2))
				t2 = db.get(i);
		}
		if(t1 == null)
			if(stack.size() != 0)
				t1 = stack.pop();
			else{
				System.out.println("Table 1 not found in difference");
				return;
			}
				
		if(t2 == null)
			if(stack.size() != 0)
				t2 = stack.pop();
			else{
				System.out.println("Table 2 not found in difference");
				return;
			}
			
		
		Table rtnTable = new Table("", t1.header);
		for(int i = 0; i < t1.rows.size(); i++){
			boolean good = true;
			for(int j = 0; j <t2.rows.size() ; j++){
				if(compObj(t1.rows.get(i), t2.rows.get(j))==true)
					good = false;
			}
			if(good ==true ){
				rtnTable.insertComSafe(t1.rows.get(i));
			}
			stack.push(rtnTable);
		}
	}	
	
	//exits from the code
	public void exitCommand(){
		System.exit(0);
	}
	
	
	//deletes values from the arrayList
	public void deleteCommand(String lhs, String rhs, String op, String relationName){
		for(int i = 0; i < db.size(); i++)
			if(db.get(i).getName().equals(relationName))
				db.get(i).deleteCom(lhs, rhs, op);
	}
	
	/*
	Selects values from a table (from) and puts them into  new table titled newRelation
	*/
	public void selectQuery(String lhs, String rhs, String op, String from){
		Table t1 = null;
		Table t2 = null;
		for(int i = 0; i < db.size(); i++)
			if(db.get(i).getName().equals(from)){
				t2 = db.get(i);
			}
		if(t2 == null)
			if(stack.size() != 0)
				t2 = stack.pop();
	
			t1 = t2.selectQuer(lhs, rhs, op);
			
			if(t1 == null){
				System.out.println("Relation is not valid: "+from);
				return;
			}
			stack.push(t1);
	}
	
	//write to "relationName".db
	public void writeCommand(String relationName){
		for(int i = 0; i < db.size(); i++)
			if(db.get(i).getName().equals(relationName))
				db.get(i).write(relationName);
	}
	
	//writes to filename.db and removes the relation from the db
	public void closeCommand(String filename){
		writeCommand(filename);
		for(int i = 0; i < db.size(); i++)
			if(filename.equals(db.get(i).getName()))
				db.remove(db.get(i));
	
	
	}
	
	//opens a file (filename without the extension) and adds that relation to the db
	public void open(String filename) throws FileNotFoundException{
		filename = filename+ ".db";
		File file = new File(filename);

		try{
			ArrayList<String> attN = new ArrayList<>();
			ArrayList<String> attD = new ArrayList<>();
			ArrayList<String> attS = new ArrayList<>();
			ArrayList<String> attP = new ArrayList<>();	
			ArrayList<Attribute> tempHeader = new ArrayList<>();
			Scanner sc = new Scanner(file);
			String attName = sc.nextLine();
			for(String retval: attName.split("\\s+")) 
				attN.add(retval);
			attName = sc.nextLine();
			for(String retval: attName.split("\\s+")) 
				attD.add(retval);
			attName = sc.nextLine();
			for(String retvalInt: attName.split("\\s+")) 
				attS.add(retvalInt);
			attName = sc.nextLine();
			for(String retval: attName.split("\\s+")) 
				attP.add(retval);
			for(int i = 0; i < attN.size(); i++){
				Attribute a = new Attribute(attN.get(i), attD.get(i), Integer.parseInt(attS.get(i)), Boolean.parseBoolean(attP.get(i)));
				tempHeader.add(a);
			}
			Table t1 = new Table(filename.substring(0, filename.length()-3), tempHeader);
			while (sc.hasNextLine()){
				String line = sc.nextLine();
				Scanner sc2 = new Scanner(line);
				ArrayList<String> rx = new ArrayList<>();
				while (sc2.hasNext()){
					String s = sc2.next();
					rx.add(s);
					//System.out.println(s);
				}
				t1.insertComSafe(rx);
			}
			addTable(t1);
		}
		catch (FileNotFoundException ex){
			System.out.println(ex.toString());
			throw ex;
		}
	}

	
	
	
}