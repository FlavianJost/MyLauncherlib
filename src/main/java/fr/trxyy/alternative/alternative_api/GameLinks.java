package fr.trxyy.alternative.alternative_api;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Trxyy
 */
public class GameLinks {

	/**
	 * The base url, ex: http://mywebsite.com/
	 */
	public String BASE_URL;
	/**
	 * The json url, ex: http://mywebsite.com/mc_version.json
	 */
	public String JSON_URL;
	/**
	 * The json name, 1.7.10.json for 1.7.10 version
	 */
	public String JSON_NAME;
	/**
	 * The base url of clustering, ex: http://mywebsite.com/
	 */
	public String BASE_URL2;
	/**
	 * The json url of clustering, ex: http://mywebsite.com/mc_version.json
	 */
	public String JSON_URL2;
	/**
	 * The json name of clustering, 1.7.10.json for 1.7.10 version
	 */
	public String JSON_NAME2;
	
	public boolean Clustering=false;
	/**
	 * The maintenance url, ex: http://mywebsite.com/status.cfg
	 */
	public String MAINTENANCE;
	/**
	 * The ignore list, ex: http://mywebsite.com/ignore.cfg
	 */
	public String IGNORE_LIST;
	/**
	 * The delete list, ex: http://mywebsite.com/delete.cfg
	 */
	public String DELETE_LIST;
	/**
	 * The custom files url, ex: http://mywebsite.com/files/
	 */
	public String CUSTOM_FILES_URL;

	/**
	 * The Constructor
	 * @param baseUrl The base url
	 * @param jsonName The json name (1.7.10.json for 1.7.10 version)
	 */
	
	public GameLinks(String baseUrl, String jsonName) {
		if (baseUrl.endsWith("/")) {
			this.BASE_URL = baseUrl;
		} else {
			this.BASE_URL = baseUrl + "/";
		}
		this.JSON_URL = baseUrl + jsonName;
		this.JSON_NAME = jsonName;
		this.IGNORE_LIST = baseUrl + "ignore.cfg";
		this.DELETE_LIST = baseUrl + "delete.cfg";
		this.CUSTOM_FILES_URL = baseUrl + "files/";
		this.MAINTENANCE = baseUrl + "status.cfg";
	}
	
	public GameLinks(String baseUrl, String jsonName,String baseUrl2, String jsonName2,boolean Cluster) {
		if (baseUrl.endsWith("/")) {
			this.BASE_URL = baseUrl;
		} else {
			this.BASE_URL = baseUrl + "/";
		}
		if(baseUrl2 !=null ) {
			if ( baseUrl2.endsWith("/")) {
				this.BASE_URL2 = baseUrl2;
			} else {
				this.BASE_URL2 = baseUrl2 + "/";
			}
			this.JSON_URL2 = baseUrl2 + jsonName2;
			this.JSON_NAME2 = jsonName2;
		}else {}
		this.JSON_URL = baseUrl + jsonName;
		this.JSON_NAME = jsonName;
		if(Cluster==true) {
			
		
			int Erreur = 0;int boucle=0;
			try {
				URL url = new URL(this.JSON_URL);
				URL url2 = new URL(this.JSON_URL2);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				HttpURLConnection connection2 = (HttpURLConnection) url2.openConnection();
				boucle=1;
				connection.connect();
				boucle=2;
				connection2.connect();
			}catch (Exception e) {
				Erreur=Erreur+1;
			}
			if(boucle==1 && Erreur==1) {
				this.IGNORE_LIST = baseUrl + "ignore.cfg";
				this.DELETE_LIST = baseUrl + "delete.cfg";
				this.CUSTOM_FILES_URL = baseUrl + "files/";
				this.MAINTENANCE = baseUrl + "status.cfg";
				Clustering=false;
			}else if(boucle==2 && Erreur==2){
				this.IGNORE_LIST = baseUrl2 + "ignore.cfg";
				this.DELETE_LIST = baseUrl2 + "delete.cfg";
				this.CUSTOM_FILES_URL = baseUrl2 + "files/";
				this.MAINTENANCE = baseUrl2 + "status.cfg";
				Clustering=true;
			}else if(boucle==2 && Erreur==0) {
				this.IGNORE_LIST = baseUrl + "ignore.cfg";
				this.DELETE_LIST = baseUrl + "delete.cfg";
				this.CUSTOM_FILES_URL = baseUrl + "files/";
				this.MAINTENANCE = baseUrl + "status.cfg";
				Clustering=false;
			}
		}else {
			this.IGNORE_LIST = baseUrl + "ignore.cfg";
			this.DELETE_LIST = baseUrl + "delete.cfg";
			this.CUSTOM_FILES_URL = baseUrl + "files/";
			this.MAINTENANCE = baseUrl + "status.cfg";
		}
	}

	/**
	 * @return The url
	 */
	public String getBaseUrl() {
		if(Clustering=true) {
			return this.BASE_URL2;
		}else {
			return this.BASE_URL;
		}
	}
	
	/**
	 * @return The json name
	 */
	public String getJsonName() {
		return this.JSON_NAME;
	}
	
	/**
	 * @return The maintenance url
	 */
	public String getMaintenanceUrl() {
		return this.MAINTENANCE;
	}

	/**
	 * @return The json url
	 */
	public String getJsonUrl() {
		return this.JSON_URL;
	}

	/**
	 * @return The ignore list url
	 */
	public String getIgnoreListUrl() {
		return this.IGNORE_LIST;
	}

	/**
	 * @return The delete list url
	 */
	public String getDeleteListUrl() {
		return this.DELETE_LIST;
	}

	/**
	 * @return The custom files folder url
	 */
	public String getCustomFilesUrl() {
		return this.CUSTOM_FILES_URL;
	}

}
