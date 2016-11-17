package com.framentos.list;

public class City {


	//class has 3 Strings
	//methods to get/set all strings
	//constructor to initialixe all strings

	public City(String name, String urlWiki, String image) {
		super();
		this.name = name;
		this.urlWiki = urlWiki;
		this.image = image;
	}

	private String name;
	private String urlWiki;
	private String image;

	public String getName() {
		return name;
	}

	public void setName(String nameText) {
		name = nameText;
	}

	public String getUrlWiki() {
		return urlWiki;
	}

	public void setUrlWiki(String urlWiki) {
		this.urlWiki = urlWiki;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}

