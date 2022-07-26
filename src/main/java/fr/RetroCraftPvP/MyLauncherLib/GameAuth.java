package fr.RetroCraftPvP.MyLauncherLib;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.trxyy.alternative.alternative_api.GameEngine;
import fr.trxyy.alternative.alternative_api.GameFolder;
import fr.trxyy.alternative.alternative_api.utils.FontLoader;
import fr.trxyy.alternative.alternative_api.utils.config.LauncherConfig;
import fr.trxyy.alternative.alternative_api_ui.components.LauncherButton;
import fr.trxyy.alternative.alternative_api_ui.components.LauncherImage;
import fr.trxyy.alternative.alternative_api_ui.components.LauncherLabel;
import fr.trxyy.alternative.alternative_api_ui.components.LauncherPasswordField;
import fr.trxyy.alternative.alternative_api_ui.components.LauncherTextField;
import fr.RetroCraftPvP.MyLauncherLib.AccountType;
import fr.trxyy.alternative.alternative_auth.account.Session;
import fr.trxyy.alternative.alternative_auth.base.AuthConstants;
import fr.trxyy.alternative.alternative_auth.base.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class GameAuth {
	/**
	 * Is player authed ?
	 */
	public boolean isAuthenticated = false;
	/**
	 * The session
	 */
	private Session session = new Session();
	
	public static GameFolder gf;
	
	private LauncherButton closeButton,reduceButton;
	private LauncherConfig config;
	private GameEngine gameEngine;
	/** LOGIN */
	private LauncherTextField usernameField;
	private LauncherPasswordField passwordField;
	private LauncherButton loginButton,microsoftButton,LoginButtonb;
	private LauncherLabel LoginLabel;
	
	private String username="",uuId="",token="",url="",u="",p="",db="";
	private Font customFont = FontLoader.loadFont("Comfortaa-Regular.ttf", "Comfortaa", 18F);
	private fr.trxyy.alternative.alternative_api_ui.base.IScreen IScreen;
	
	public boolean panel=false,mb=false,lg=false;

	@SuppressWarnings("static-access")
	public GameAuth(String Speudo, String url,String u,String p,String db,GameFolder gf, AccountType type) {
		this.url=url;this.u=u;this.p=p;this.db=db;
		AuthConstants.displayCopyrights();
		if (type.equals(AccountType.CUSTOMIZE)) {
			this.gf=gf;this.connectCustom(url,u,p,db,Speudo);
		}
	}
	
	public void connectCustom(String url,String u,String p,String db,String Speudo) {
		try {
			Connection con=DriverManager.getConnection(url,u,p);@SuppressWarnings("unused")
			String email="",pwd="",User="",UUID="",MinTken="";@SuppressWarnings("unused")
			int id;
			
			Statement statement=con.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from "+db+" where MinSpeudo = '"+Speudo+"'");
			while (resultSet.next()) {id=resultSet.getInt("id");email=resultSet.getString("Email");
			pwd=resultSet.getString("Mbp");User=resultSet.getString("MinSpeudo");
			UUID=resultSet.getString("MinID");MinTken=resultSet.getString("MinTken");}
			this.setSession(User, MinTken, UUID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Customizer(Pane root, final GameEngine engine, GameFolder gamefolder,File f) {
		this.config = new LauncherConfig(engine);
		this.config.loadConfiguration();
		
		this.closeButton = new LauncherButton(root);
		this.closeButton.setInvisible();
		this.closeButton.setBounds(gameEngine.getWidth() - 50, -3, 40, 20);
		LauncherImage closeImage = new LauncherImage(root, IScreen.loadImage(gameEngine, "close.png"));
		closeImage.setSize(40, 20);
		this.closeButton.setGraphic(closeImage);
		this.closeButton.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
		/** ===================== BOUTON REDUIRE ===================== */
		this.reduceButton = new LauncherButton(root);
		this.reduceButton.setInvisible();
		this.reduceButton.setBounds(gameEngine.getWidth() - 91, -3, 40, 20);
		LauncherImage reduceImage = new LauncherImage(root, IScreen.loadImage(gameEngine, "reduce.png"));
		reduceImage.setSize(40, 20);
		this.reduceButton.setGraphic(reduceImage);
		this.reduceButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Stage stage = (Stage) ((LauncherButton) event.getSource()).getScene().getWindow();
				stage.setIconified(true);
			}
		});
		/** ===================== CASE PSEUDONYME ===================== */
		this.usernameField = new LauncherTextField(root);
		this.usernameField.setBounds(this.gameEngine.getWidth() - 540, this.gameEngine.getHeight() - 105, 220, 20);
		this.setFontSize(14.0F);
		this.usernameField.setFont(this.customFont);
		this.usernameField.addStyle("-fx-background-color: rgb(230, 230, 230);");
		this.usernameField.addStyle("-fx-text-fill: black;");
		this.usernameField.addStyle("-fx-border-radius: 0 0 0 0;");
		this.usernameField.addStyle("-fx-background-radius: 0 0 0 0;");
		this.usernameField.setVoidText("Addresse Mail");
		/** ===================== CASE MOT DE PASSE ===================== */
		this.passwordField = new LauncherPasswordField(root);
		this.passwordField.setBounds(this.gameEngine.getWidth() - 540, this.gameEngine.getHeight() - 70, 220, 20);
		this.setFontSize(14.0F);
		this.passwordField.setFont(this.customFont);
		this.passwordField.addStyle("-fx-background-color: rgb(230, 230, 230);");
		this.passwordField.addStyle("-fx-text-fill: black;");
		this.passwordField.addStyle("-fx-border-radius: 0 0 0 0;");
		this.passwordField.addStyle("-fx-background-radius: 0 0 0 0;");
		this.passwordField.setVoidText("Mot de passe");
		/** ===================== BOUTON DE CONNEXION ===================== */
		this.loginButton = new LauncherButton("S'inscrire", root);
		this.setFontSize(12.5F);
		this.loginButton.setFont(this.customFont);
		this.loginButton.setBounds(this.gameEngine.getWidth() - 300, this.gameEngine.getHeight() - 85, 90, 20);
		this.loginButton.addStyle("-fx-background-color: rgb(230, 230, 230);");
		this.loginButton.addStyle("-fx-text-fill: black;");
		this.loginButton.addStyle("-fx-border-radius: 0 0 0 0;");
		this.loginButton.addStyle("-fx-background-radius: 0 0 0 0;");
		this.loginButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				usernameField.setVisible(false);
				passwordField.setVisible(false);
				microsoftButton.setVisible(false);
				try {
					Connection con=DriverManager.getConnection(url,u,p);
					Statement statement=con.createStatement();
					System.out.println(usernameField.getText());System.out.println(passwordField.getText());
					statement.execute(""+db+"`(`Email`, `Mbp`, `MinSpeudo`, `MinId`, `MinTken`) VALUES ('"+usernameField.getText()+"','"+passwordField.getText()+"','"+username+"','"+uuId+"','"+token+"')");
					@SuppressWarnings("unused")
					boolean test_file=f.exists();
					if(test_file==true) {
						config.updateValue("username", username);panel=true;
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		this.microsoftButton = new LauncherButton(root);
		LauncherImage mcaImage = new LauncherImage(root, IScreen.loadImage(gameEngine, "microsoft.png"));
		mcaImage.setSize(20, 20);
		this.microsoftButton.setGraphic(mcaImage);
		this.microsoftButton.setBounds(this.gameEngine.getWidth() - 500, this.gameEngine.getHeight() - 35, 150, 20);
		this.microsoftButton.setText("Associer � Microsoft");
		this.microsoftButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mb=true;
			}
		});
		
		this.LoginLabel=new LauncherLabel(root);
		this.LoginLabel.setFont(this.customFont);
		this.LoginLabel.setBounds(this.gameEngine.getWidth()-285, this.gameEngine.getHeight()-50, 90, 20);
		this.LoginLabel.addStyle("-fx-text-fill: black;");
		this.LoginLabel.setText("Se connecter");
		
		this.LoginButtonb=new LauncherButton(root);
		this.LoginButtonb.setFont(this.customFont);
		this.LoginButtonb.setBounds(this.gameEngine.getWidth()-285, this.gameEngine.getHeight()-50, 60, 0);
		this.LoginButtonb.setInvisible();
		this.LoginButtonb.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				usernameField.setVisible(false);
				passwordField.setVisible(false);
				microsoftButton.setVisible(false);
				loginButton.setVisible(false);
				LoginLabel.setVisible(false);
				LoginButtonb.setVisible(false);lg=true;
			}
		});
	}
	
	private void setFontSize(float size) {
		this.customFont = FontLoader.loadFont("Comfortaa-Regular.ttf", "Comfortaa", size);
	}
	
	public void setSession(String user, String token, String id) {
		this.session.setUsername(user);
		this.session.setToken(token);
		this.session.setUuid(id);
		this.isAuthenticated = true;
		Logger.log("Connected Successfully !");
	}
	
	public boolean isLogged() {
		return this.isAuthenticated;
	}
	
	public Session getSession() {
		return this.session;
	}
	
}
