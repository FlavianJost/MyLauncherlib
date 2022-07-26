package fr.RetroCraftPvP.MyLauncherLib;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import fr.trxyy.alternative.alternative_api.GameFolder;

public class Account {
	
	public static String chemein_skin_Head;
	public static String chemein_skin_Body;
	public static String chemein_skin_Structure;
	
	public static void Download_Skin_head(GameFolder gf,String name) {
		String link = "https://minotar.net/helm/" + name + "/100.png";
		File out = new File(gf.assetsDir+"/skin/"+name+"_Head.png");
		try {
			URL url = new URL(link);
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			double filesize = (double)http.getContentLengthLong();
			BufferedInputStream in = new BufferedInputStream(http.getInputStream());
			FileOutputStream fos = new FileOutputStream(out);
			BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
			byte[] buffer = new byte[1024];
			double download = 0.00;
			int read = 0;
			double percentDownloaded = 0.00;
			while((read = in.read(buffer,0,1024))>=0) {
				bout.write(buffer,0,read);
				download+=read;
				percentDownloaded=(download*100)/filesize;
				String percent = String.format("%.4f",percentDownloaded);
				System.out.println("Downloaded "+percent+"% of a file.");
			}
			bout.close();
			in.close();
			System.out.println("Download complete");;
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void Download_Skin_Body(GameFolder gf,String name) {
		String link = "https://minotar.net/armor/body/" + name + "/100.png";
		File out = new File(gf.assetsDir+"/skin/"+name+"_Body.png");
		try {
			URL url = new URL(link);
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			double filesize = (double)http.getContentLengthLong();
			BufferedInputStream in = new BufferedInputStream(http.getInputStream());
			FileOutputStream fos = new FileOutputStream(out);
			BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
			byte[] buffer = new byte[1024];
			double download = 0.00;
			int read = 0;
			double percentDownloaded = 0.00;
			while((read = in.read(buffer,0,1024))>=0) {
				bout.write(buffer,0,read);
				download+=read;
				percentDownloaded=(download*100)/filesize;
				String percent = String.format("%.4f",percentDownloaded);
				System.out.println("Downloaded "+percent+"% of a file.");
			}
			bout.close();
			in.close();
			System.out.println("Download complete");;
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void Download_Skin_User(GameFolder gf,String name) {
		String link = "https://minotar.net/skin/" + name;
		File out = new File(gf.assetsDir+"/skin/"+name+"_Struture.png");
		try {
			URL url = new URL(link);
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			double filesize = (double)http.getContentLengthLong();
			BufferedInputStream in = new BufferedInputStream(http.getInputStream());
			FileOutputStream fos = new FileOutputStream(out);
			BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
			byte[] buffer = new byte[1024];
			double download = 0.00;
			int read = 0;
			double percentDownloaded = 0.00;
			while((read = in.read(buffer,0,1024))>=0) {
				bout.write(buffer,0,read);
				download+=read;
				percentDownloaded=(download*100)/filesize;
				String percent = String.format("%.4f",percentDownloaded);
				System.out.println("Downloaded "+percent+"% of a file.");
			}
			bout.close();
			in.close();
			System.out.println("Download complete");;
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void Show_Skin_head(GameFolder gf,String name) {File f = new File(gf.assetsDir + "/skin/",name+"_Head.png");chemein_skin_Head = f.getPath();}
	public static void Show_Skin_Body(GameFolder gf,String name) {File f = new File(gf.assetsDir + "/skin/",name+"_Body.png");chemein_skin_Body = f.getPath();}
	public static void Show_UserSkin(GameFolder gf,String name) {File f = new File(gf.assetsDir + "/skin/",name+"_Struture.png");chemein_skin_Structure = f.getPath();}
	
}