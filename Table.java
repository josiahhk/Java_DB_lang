/*
Elijah Gonzales 725000232
Josiah Hamid-Khani 725003646
Joseph Hernandez 825002632
CSCE 313-505
October 16, 2018
Table.java
*/
import java.util.*;
import java.lang.*;
import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Table{
	//the attributes
	ArrayList<Attribute> header = new ArrayList<>(); 
	//the table itself
	ArrayList<ArrayList<String>> rows = new ArrayList<>();
	//name of the relation
	String name;
	
	public ArrayList<ArrayList<String>> getRows(){return rows;}
	public void setRows(ArrayList<ArrayList<String>> r){rows = r;}
	public String getName(){return name;}
	public void setName(String r){name = r;}
	
	public Table(String n, ArrayList<Attribute> h){
		name = n;
		header = h;

	}

	//inserts a row into the table. This function implements varchars and primary keys
	void insertCom(ArrayList<String> r){
		if(r.size() > header.size())
			for(int i = header.size(); i < r.size(); i++)
				r.remove(i);
		
		if(r.size() < header.size()){
			System.out.println("Must insert a row of same size as the database");
			return;
		}
		
		//implementing varchar size checking
		int vSize = 0;
		for(int i = 0; i < header.size(); i++){
			if(!(header.get(i).getDt().equals("INTEGER"))){
				vSize = header.get(i).getSize();
				if(((String)r.get(i)).length() >  vSize)
					r.set(i, ((String)r.get(i)).substring(0, vSize));
			}
		}
		//implementing primary key checking
		/*
		boolean isDup = false;
		for(int i = 0; i < header.size(); i++){
			if(header.get(i).getPK() == true){
				for(int j = 0; j < rows.size(); j++)
					if(r.get(i).equals(rows.get(j).get(i)))
						isDup = true;
			}
		}
		
		if(isDup != true)
			rows.add(r);
		*/
		//else System.out.println("This row was not added due to a duplicate primary key");
	}	
	
	//does not check for duplicate items (primary keys). Is union compatible.
	void insertComSafe(ArrayList<String> r){
		//for union compatibility
		int vSize = 0;
		for(int i = 0; i < header.size(); i++){
			if(!(header.get(i).getDt().equals("INTEGER"))){
				vSize = header.get(i).getSize();
				if(((String)r.get(i)).length() >  vSize)
					r.set(i, ((String)r.get(i)).substring(0, vSize));
			}
		}
		rows.add(r);
	}

	//shows the table
	void showCommand(){
		for(int i = 0; i < rows.size(); i++){
			for(int j = 0; j < rows.get(i).size(); j++){
				System.out.print(rows.get(i).get(j) + "  ");
			}
				System.out.println();
		}
	}
	
	//performs selection on the table (written before the database)		
	public Table selectQuer(String lhs, String rhs, String op){
		Table t = new Table("", this.header);
		boolean left = false;
		boolean right = false;
		int leftColIndex = 0;
		int rightColIndex = 0;
		String typeLeft = "";
		String typeRight = "";
		int convertedLeftInt=0;
		int convertedRightInt=0;
		for(int i = 0; i < header.size(); i++){
			if(header.get(i).getName().equals(lhs)){
				left = true;
				leftColIndex = i;
				typeLeft = header.get(leftColIndex).getDt();
			}
			if(header.get(i).getName().equals(rhs)){
				right = true;
				rightColIndex = i;
				typeRight = header.get(rightColIndex).getDt();
			}
		}
		if(left == true && right == true)
			if(!(typeLeft.equals(typeRight))){
			System.out.println("Cannot compare different types");
			return null;
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
					for(int j = 0; j < rows.size(); j++)
						if(Integer.parseInt(rows.get(j).get(leftColIndex)) == Integer.parseInt(rows.get(j).get(rightColIndex)))
							t.insertCom(rows.get(j));
				}
				else{
					for(int j = 0; j < rows.size(); j++){
						if(((rows.get(j).get(leftColIndex))).equals((rows.get(j).get(rightColIndex))))
							t.rows.add(rows.get(j));
					}
				}
			}
			else if(right == true){
				if(typeRight.equals("INTEGER")){
					for(int j = 0; j < rows.size(); j++)
						if(Integer.parseInt(rows.get(j).get(rightColIndex)) == convertedLeftInt)
							t.rows.add(rows.get(j));
				}
				else{
					for(int j = 0; j < rows.size(); j++)
						if(rows.get(j).get(rightColIndex).equals(lhs))
							t.rows.add(rows.get(j));
				}
			}
			else if(left == true){
				if(typeLeft.equals("INTEGER")){
					for(int j = 0; j < rows.size(); j++){
						if(Integer.parseInt(rows.get(j).get(leftColIndex)) == convertedRightInt){
							t.rows.add(rows.get(j));
						}
					}
				}
				else{
					for(int j = 0; j < rows.size(); j++)
						if(((String)rows.get(j).get(leftColIndex)).equals(rhs))
							t.rows.add(rows.get(j));
				}
			}			
		}
		else if(op.equals("!=")){
			if(left == true && right == true){
				if(typeLeft.equals("INTEGER")){
					for(int j = 0; j < rows.size(); j++)
						if(Integer.parseInt(rows.get(j).get(leftColIndex)) != Integer.parseInt(rows.get(j).get(rightColIndex)))
							t.rows.add(rows.get(j));	
				}
				else{
					for(int j = 0; j < rows.size(); j++){
						if(!(((String)(rows.get(j).get(leftColIndex))).equals((String)(rows.get(j).get(rightColIndex)))))
							t.rows.add(rows.get(j));
					}
				}
			}
			else if(right == true){
				if(typeRight.equals("INTEGER")){
					for(int j = 0; j < rows.size(); j++)
						if(Integer.parseInt(rows.get(j).get(rightColIndex)) != convertedLeftInt)
							t.rows.add(rows.get(j));
				}
				else{
					for(int j = 0; j < rows.size(); j++)
						if(!((String)rows.get(j).get(rightColIndex)).equals(lhs))
							t.rows.add(rows.get(j));
				}
			}
			else if(left == true){
				if(typeLeft.equals("INTEGER")){
					for(int j = 0; j < rows.size(); j++)
						if(Integer.parseInt(rows.get(j).get(leftColIndex)) != convertedRightInt)
							t.rows.add(rows.get(j));
				}
				else{
					for(int j = 0; j < rows.size(); j++)
						if(!((String)rows.get(j).get(leftColIndex)).equals(rhs))
							t.rows.add(rows.get(j));
				}
			}			
		}
		else if(op.equals("<")){
			if(left == true && right == true){
				for(int j = 0; j < rows.size(); j++)
					if(Integer.parseInt(rows.get(j).get(leftColIndex)) < Integer.parseInt(rows.get(j).get(rightColIndex)))
						t.rows.add(rows.get(j));
			}		
			else if(left == true){
				for(int j = 0; j < rows.size(); j++)
					if(Integer.parseInt(rows.get(j).get(leftColIndex)) < convertedRightInt)
						t.rows.add(rows.get(j));
			}
			else if(right == true){
				for(int j = 0; j < rows.size(); j++)
					if(Integer.parseInt(rows.get(j).get(rightColIndex)) < convertedLeftInt)
						t.rows.add(rows.get(j));
		}		
	}
		else if(op.equals(">")){
			if(left == true && right == true){
				for(int j = 0; j < rows.size(); j++)
					if(Integer.parseInt(rows.get(j).get(leftColIndex)) > Integer.parseInt(rows.get(j).get(rightColIndex)))
						t.rows.add(rows.get(j));
			}		
			else if(left == true){
				for(int j = 0; j < rows.size(); j++)
					if(Integer.parseInt(rows.get(j).get(leftColIndex)) > convertedRightInt)
						t.rows.add(rows.get(j));
			}
			else if(right == true){
				for(int j = 0; j < rows.size(); j++)
					if(Integer.parseInt(rows.get(j).get(rightColIndex)) > convertedLeftInt)
						t.rows.add(rows.get(j));
		}		
	}
		else if(op.equals("<=")){
			if(left == true && right == true){
				for(int j = 0; j < rows.size(); j++)
					if(Integer.parseInt(rows.get(j).get(leftColIndex)) <= Integer.parseInt(rows.get(j).get(rightColIndex)))
						t.rows.add(rows.get(j));	
			}		
			else if(left == true){
				for(int j = 0; j < rows.size(); j++)
					if(Integer.parseInt(rows.get(j).get(leftColIndex)) <= convertedRightInt)
						t.rows.add(rows.get(j));
			}
			else if(right == true){
				for(int j = 0; j < rows.size(); j++)
					if(Integer.parseInt(rows.get(j).get(rightColIndex)) <= convertedLeftInt)
						t.rows.add(rows.get(j));
		}		
	}
		else{
			if(left == true && right == true){
				for(int j = 0; j < rows.size(); j++)
					if(Integer.parseInt(rows.get(j).get(leftColIndex)) >= Integer.parseInt(rows.get(j).get(rightColIndex)))
						t.rows.add(rows.get(j));
			}		
			else if(left == true){
				for(int j = 0; j < rows.size(); j++)
					if(Integer.parseInt(rows.get(j).get(leftColIndex)) >= convertedRightInt)
						t.rows.add(rows.get(j));
			}
			else if(right == true){
				for(int j = 0; j < rows.size(); j++)
					if(Integer.parseInt(rows.get(j).get(rightColIndex)) >= convertedLeftInt)
						t.rows.add(rows.get(j));
			}		
		}	
			return t;
	}

	//performs deletion on the table (written before the database)
	public void deleteCom(String lhs, String rhs, String op){
		boolean left = false;
		boolean right = false;
		int leftColIndex = 0;
		int rightColIndex = 0;
		String typeLeft = "";
		String typeRight = "";
		int convertedLeftInt=0;
		int convertedRightInt=0;
		for(int i = 0; i < header.size(); i++){
			if(header.get(i).getName().equals(lhs)){
				left = true;
				leftColIndex = i;
				typeLeft = header.get(leftColIndex).getDt();
			}
			if(header.get(i).getName().equals(rhs)){
				right = true;
				rightColIndex = i;
				typeRight = header.get(rightColIndex).getDt();
			}
		}
		if(left == true && right == true)
			if(!(typeLeft.equals(typeRight))){
				System.out.println("Cannot compare different types");
				return;
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
					for(int j = rows.size()-1; j >=0; j--)
						if(Integer.parseInt(rows.get(j).get(leftColIndex)) == Integer.parseInt(rows.get(j).get(rightColIndex)))
							rows.remove(j);
				}
				else{
					for(int j = rows.size()-1; j >=0; j--){
						if(((rows.get(j).get(leftColIndex))).equals((rows.get(j).get(rightColIndex))))
							rows.remove(j);
					}
				}
			}
			else if(right == true){
				if(typeRight.equals("INTEGER")){
					for(int j = rows.size()-1; j >=0; j--)
						if(Integer.parseInt(rows.get(j).get(rightColIndex)) == convertedLeftInt)
							rows.remove(j);
				}
				else{
					for(int j = rows.size()-1; j >=0; j--)
						if(rows.get(j).get(rightColIndex).equals(lhs))
							rows.remove(j);
		
				}
			}
			else if(left == true){
				if(typeLeft.equals("INTEGER")){
					for(int j = rows.size()-1; j >=0; j--){
						if(Integer.parseInt(rows.get(j).get(leftColIndex)) == convertedRightInt){
							rows.remove(j);
						}
					}
				}
				else{
					for(int j = rows.size()-1; j >=0; j--){
						if((rows.get(j).get(leftColIndex)).equals(rhs))
							rows.remove(j);
					}
				}
			}			
		}
		else if(op.equals("!=")){
			if(left == true && right == true){
				if(typeLeft.equals("INTEGER")){
					for(int j = rows.size()-1; j >=0; j--)
						if(Integer.parseInt(rows.get(j).get(leftColIndex)) != Integer.parseInt(rows.get(j).get(rightColIndex)))
							rows.remove(j);	
				}
				else{
					for(int j = rows.size()-1; j >=0; j--){
						if(!(((rows.get(j).get(leftColIndex))).equals((rows.get(j).get(rightColIndex)))))
							rows.remove(j);
					}
				}
			}
			else if(right == true){
				if(typeRight.equals("INTEGER")){
					for(int j = rows.size()-1; j >=0; j--)
						if(Integer.parseInt(rows.get(j).get(rightColIndex)) != convertedLeftInt)
							rows.remove(j);
				}
				else{
					for(int j = rows.size()-1; j >=0; j--)
						if(!(rows.get(j).get(leftColIndex)).equals(rhs))
							rows.remove(j);
				}
			}
			else if(left == true){
				if(typeLeft.equals("INTEGER")){
					for(int j = rows.size()-1; j >=0; j--)
						if(Integer.parseInt(rows.get(j).get(leftColIndex)) != convertedRightInt)
							rows.remove(j);
				}
				else{
					for(int j = rows.size()-1; j >=0; j--)
						if(!(rows.get(j).get(leftColIndex)).equals(rhs))
							rows.remove(j);
				}
			}			
		}
		else if(op.equals("<")){
			if(left == true && right == true){
				for(int j = rows.size()-1; j >=0; j--)
					if(Integer.parseInt(rows.get(j).get(leftColIndex)) < Integer.parseInt(rows.get(j).get(rightColIndex)))
						rows.remove(j);
			}		
			else if(left == true){
				for(int j = rows.size()-1; j >=0; j--){
					if(Integer.parseInt(rows.get(j).get(leftColIndex)) < convertedRightInt)
						rows.remove(j);
				}
			}
			else if(right == true){
				for(int j = rows.size()-1; j >=0; j--)
					if(Integer.parseInt(rows.get(j).get(rightColIndex)) < convertedLeftInt)
						rows.remove(j);
			}		
		}
		else if(op.equals(">")){
			if(left == true && right == true){
				for(int j = rows.size()-1; j >=0; j--)
					if(Integer.parseInt(rows.get(j).get(leftColIndex)) > Integer.parseInt(rows.get(j).get(rightColIndex)))
						rows.remove(j);
			}		
			else if(left == true){
				for(int j = rows.size()-1; j >=0; j--)
					if(Integer.parseInt(rows.get(j).get(leftColIndex)) > convertedRightInt)
						rows.remove(j);
			}
			else if(right == true){
				for(int j = rows.size()-1; j >=0; j--)
					if(Integer.parseInt(rows.get(j).get(rightColIndex)) > convertedLeftInt)
						rows.remove(j);
			}		
		}
		else if(op.equals("<=")){
			if(left == true && right == true){
				for(int j = rows.size()-1; j >=0; j--)
					if(Integer.parseInt(rows.get(j).get(leftColIndex)) <= Integer.parseInt(rows.get(j).get(rightColIndex)))
						rows.remove(j);	
			}		
			else if(left == true){
				for(int j = rows.size()-1; j >=0; j--)
					if(Integer.parseInt(rows.get(j).get(leftColIndex)) <= convertedRightInt)
						rows.remove(j);
			}
			else if(right == true){
				for(int j = rows.size()-1; j >=0; j--)
					if(Integer.parseInt(rows.get(j).get(rightColIndex)) <= convertedLeftInt)
						rows.remove(j);
			}		
		}
		else{
			if(left == true && right == true){
				for(int j = rows.size()-1; j >=0; j--)
					if(Integer.parseInt(rows.get(j).get(leftColIndex)) >= Integer.parseInt(rows.get(j).get(rightColIndex)))
						rows.remove(j);
			}		
			else if(left == true){
				for(int j = rows.size()-1; j >=0; j--)
					if(Integer.parseInt(rows.get(j).get(leftColIndex)) >= convertedRightInt)
						rows.remove(j);
			}
			else if(right == true){
				for(int j = rows.size()-1; j >=0; j--)
					if(Integer.parseInt(rows.get(j).get(rightColIndex)) >= convertedLeftInt)
						rows.remove(j);
			}		
		}
	}


	public void write(String relationName){
		File file = new File(relationName += ".db");
		FileWriter fr = null;
		String newLine = System.getProperty("line.separator");
		try {
			fr = new FileWriter(file);
			for(int i = 0; i < header.size(); i++)
				fr.write(header.get(i).getName() + " ");
			fr.write("\r\n");
			for(int i = 0; i < header.size(); i++)
				fr.write(header.get(i).getDt() + " ");
			fr.write("\r\n");
			for(int i = 0; i < header.size(); i++)
				fr.write(header.get(i).getSize() + " ");
			fr.write("\r\n");
			for(int i = 0; i < header.size(); i++)
				fr.write(header.get(i).getPK() + " ");
			fr.write("\r\n");
			for(int i = 0; i < rows.size(); i++){
				for(int j = 0; j < rows.get(i).size(); j++)
					fr.write(rows.get(i).get(j) + " ");
					fr.write("\r\n");
			}
            //fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
			}
		}
	}
	


}