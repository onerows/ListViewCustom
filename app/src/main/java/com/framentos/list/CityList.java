package com.framentos.list;

import java.util.ArrayList;
import java.util.List;

import com.framentos.list.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class CityList extends Activity {
	
	private ListView listViewCity;
	private Context ctx;
	@Override
	public void onCreate(Bundle savedInstanceState) {

		//This Activity does not extend ListActivity so we do not have access
		//to the ListView provided by ListActivity - we provide our own ListView layout city_list
		//Then below we specify the row layout for each list item with city_row_item
		//and use an Adapter to place each item from our City ArrayList in a city_row_item
		super.onCreate(savedInstanceState);
		setContentView(R.layout.city_list);  //layout file with just one ListView


		//Create an array of City objects each with name, url, and image png String name
		List<City> listCity= new ArrayList<City>();
		listCity.add(new City("London","http://en.wikipedia.org/wiki/London","london"));
		listCity.add(new City("Rome","http://en.wikipedia.org/wiki/Rome","rome"));
		listCity.add(new City("Paris","http://en.wikipedia.org/wiki/Paris","paris"));

		//Get the layout with the ListView
		listViewCity = ( ListView ) findViewById(R.id.city_list);
		//set Adapter for list and row item layout (imageView and 2 TextViews
		//The Adapter is returned by CityListAdapter
		//It adapts our custom view for our list
		CityListAdapter clA = new CityListAdapter(this, R.layout.city_row_item, listCity);
		listViewCity.setAdapter(clA);
//		listViewCity.setAdapter( new CityListAdapter(ctx, R.layout.city_row_item, listCity ) );
	}
}
