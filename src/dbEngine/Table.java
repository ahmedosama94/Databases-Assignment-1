package dbEngine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

import exceptions.DBAppException;

@SuppressWarnings("serial")
public class Table implements Serializable {

	private static File metadata = new File("Metadata.csv");

	public Table(String strTableName,
			Hashtable<String,String> htblColNameType,
			Hashtable<String,String>htblColNameRefs,
			String strKeyColName)throws DBAppException{
		writeMetadata(strTableName, htblColNameType, htblColNameRefs, strKeyColName);
	}

	// This method needs to be re-written
	public void writeMetadata(String strTableName,
			Hashtable<String,String> htblColNameType,
			Hashtable<String,String>htblColNameRefs,
			String strKeyColName) throws DBAppException{
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(metadata,true));

			Enumeration<String> e = htblColNameType.keys();

			Enumeration<String> d = htblColNameRefs.keys();
			while(e.hasMoreElements()){
				// Table Name, Column Name, Column Type, Key, Indexed, References
				String key = e.nextElement();
				writer.append(strTableName + ",");
				writer.append(key + ",");
				writer.append(htblColNameType.get(key) + ",");
				if(key==strKeyColName){

					writer.append("True" + ",");
					writer.append("True" + ",");
				}
				else{
					writer.append("False" + ",");
					writer.append("False" + ",");
				}
				while(d.hasMoreElements()){
					String key2 =d.nextElement();
					if(key==key2){
						writer.append(htblColNameRefs.get(key) + ",");
					}
				}
				writer.append('\n');
			}


			writer.flush();
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}    

	}

	public static File getMetaData() {
		return metadata;
	}

	public static void main(String [] args){
//		Hashtable<String, String> x = new Hashtable<String, String>();
//		x.put("name","string");
//		x.put("id", "int");
//		x.put("deptname","string");
//		Hashtable<String, String> y = new Hashtable<String, String>();
//		y.put("deptname","department");
//		try {
//			Table game =new Table("game2", x, y, "id");
//		} catch (DBAppException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}

