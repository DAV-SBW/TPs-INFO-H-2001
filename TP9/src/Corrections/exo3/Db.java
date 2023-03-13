package Corrections.exo3;

import java.sql.*;
import java.util.ArrayList;

 
public class Db
{
	private String sTempDb = "park.db";
	private String sJdbc = "jdbc:sqlite";
	private String sDbUrl = sJdbc + ":" + sTempDb;  	//which will produce a legitimate Url for SqlLite JDBC : jdbc:sqlite:hello.db
	private int iTimeout = 30;
	private String sMakeTable = "CREATE TABLE if not exists wanderer (id numeric, posx numeric, posy numeric)";
	private String sDropTable = "DROP TABLE wanderer";
	private String sMakeSelect = "SELECT * from wanderer";
 
        // create a database connection
    public Db(){
    	create();
    }
    
    public void update(String query){
    	Connection conn;
		try {
			conn = DriverManager.getConnection(sDbUrl);
			Statement stmt = conn.createStatement();
			stmt.setQueryTimeout(iTimeout);
            stmt.executeUpdate( query );
            try { stmt.close(); } catch (Exception ignore) {}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    }
    
    public ArrayList<String> query(){
    	ArrayList<String> results = new ArrayList<String>();
    	Connection conn;
		try {
			conn = DriverManager.getConnection(sDbUrl);
			Statement stmt = conn.createStatement();
			stmt.setQueryTimeout(iTimeout);
            ResultSet rs = stmt.executeQuery(sMakeSelect);
            try {
                while(rs.next())
                    {
                        String sResult = rs.getString("id");
                        results.add(sResult);
                        sResult = rs.getString("posx");
                        results.add(sResult);
                        sResult = rs.getString("posy");
                        results.add(sResult);
                    }
            } finally {
                try { rs.close(); } catch (Exception ignore) {}
                try { stmt.close(); } catch (Exception ignore) {}
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
    }
    
    
    public void insert(int n, int posx, int posy){
    	String makeInsert = "INSERT INTO wanderer VALUES("+String.valueOf(n)+","+String.valueOf(posx)+","+String.valueOf(posy)+")";
    	update(makeInsert);
    }
    
    public void create(){
    	update(sMakeTable);
    }
    
    public void clean(){
    	update(sDropTable);
    }
 
}
