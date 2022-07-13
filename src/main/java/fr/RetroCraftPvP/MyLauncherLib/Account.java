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
	
	/*public static String login;
	public static String password;
	public static String cut;
	public static String cut2;
	public static int print;
	public static int relayaccount;
	public static boolean update = false;
	public static GameAuth auth;
	//public static String decrypted_class;*/
	public static String chemein_skin_Head;
	public static String chemein_skin_Body;
	public static String chemein_skin_Structure;
	
	
	/*public static int valueCounter;
	public static boolean Setting_account;
	public static ObservableList<String> listp;
	public static String v1[];
	public static String v2[];
	public static String v3[];
	public static String v4[];
	public static String v5[];
	public static Path path=Paths.get("src/test/account.yml");

	/*public static void profile(Pane root, GameEngine engine , GameFolder gf, String login) throws NoSuchAlgorithmException, NoSuchPaddingException {
		try {
				List<String>lignes = Files.readAllLines(path);
				for (String ligne : lignes) {
					System.out.println(ligne);
				}
				byte[] Mbp=lignes.get(0).getBytes();
				password=new String(Mbp,Charset.defaultCharset());

			
			if(relayaccount == 1) {
				if(login.length() < 3) {
					new LauncherAlert("Connexion échouée", "La case du speudo doit contenir plus de 3 carateres.");
				}
				else if(login.length() > 3 && password.isEmpty()) {
					new LauncherAlert("Connexion échouée", "impossible de se connecter car le compte n'existe pas");
				}
				else if(login.length() > 3 && !password.isEmpty()) {
					GameAuth authp = new GameAuth(login, password, AccountType.MICROSOFT);
					if (authp.isLogged()) {
						update = true;
						auth = authp;
					}
					else {
						new LauncherAlert("Connexion échouée", "Identifiants incorrects.");
					}
				}
				else {
					new LauncherAlert("Connexion échouée", "La connexion a échouée.");
				}
			}
			
			//reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	
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