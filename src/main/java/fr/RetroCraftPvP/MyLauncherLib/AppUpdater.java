package fr.RetroCraftPvP.MyLauncherLib;

import java.awt.Desktop;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.trxyy.alternative.alternative_api_ui.base.IScreen;

public class AppUpdater extends IScreen{
	
	public boolean update=false;
	private String File="";
	public String url,username,password;

	public AppUpdater(int Launcher_version,String API_version,string db) {
		try {
			Connection con=DriverManager.getConnection(url,username,password);@SuppressWarnings("unused")
			Statement statement=con.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from "+db+" where id > "+Launcher_version);int id=0;String Name="";
			while (resultSet.next()) {id=resultSet.getInt("id");Name=resultSet.getString("Name");
			File=resultSet.getString("File");}if(id>Launcher_version) {update=true;System.out.println("une update est disponnible : " + Name + " v" + id);
			
			}else if(id==Launcher_version){update=false;}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void OpenUpdate() {try {Desktop.getDesktop().browse(new URL(File).toURI());}catch (Exception e) {e.printStackTrace();}}
	
}
