package com.framentos.list;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CityListAdapter extends ArrayAdapter<City> {

	private int				resource;
	//private LayoutInflater	inflater;
	private Context 		context;
	
	public CityListAdapter ( Context ctx, int resourceId, List<City> objects) {
		
		super( ctx, resourceId, objects );
		resource = resourceId;
		//inflater = LayoutInflater.from( ctx );
		context=ctx;
	}

     //ArrayAdapter has a method getview() we can use to return a view
	//As CityListAdapter extends ArrayAdapter we override this method getView() to return the type of view we want

	//Whenever our ListView (citylistView in CityList.java) needs to display a particular row of data,
	//it requests the associated adapter (our CityListAdapter a type of ArrayAdapter)
	//to provide the view corresponding to the data at that row. It does this through the getView() method.
	//This may occur whenever the view needs to be updated on screen (eg. during creation/scroll etc.).
	//The position parameter is specified when we scroll on the list, and marks the row required to display.

	//The parent ViewGroup(LinearLayout, RelativeLayout etc) is the root ayout that our row will be attached to

	@Override
	public View getView ( int position, View convertView, ViewGroup parent ) {


		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		//Our xml file for our row_layout has a RelativeLayout as its root view
		//so this is what we want to return
		//resource is our actual xml file reference - R.layout.city_row_item

		//convertView is our java object representing our xml layout city_row_item.xml
		//Below we will use R,id... to get individual views from this layout
		//our resource will NOT be part of the parent ViewGroup but can use its layout parameters
		convertView = ( RelativeLayout ) inflater.inflate( resource, parent, false);
		//this can be called also as inflater.inflate( resource, null );

		//We have now inflated / converted our xml layout in the Java object convertView
		//Next we add data to this object using the findViewById

		/* Extract the city's object to show*/
		// our class extends ArrayAdapter<city> so we can usee the ArrayAdapter method getItem
		City city = getItem( position );

		/////////////////////////////////////////////
		// Now we extract all the views from our inflated convertView layout
		//and place the data from our city class in them
		/* Take the TextView from layout and set the city's name */
		TextView txtName = (TextView) convertView.findViewById(R.id.cityName);
		txtName.setText(city.getName());
		
		/* Take the TextView from layout and set the city's wiki link */
		TextView txtWiki = (TextView) convertView.findViewById(R.id.cityLinkWiki);
		txtWiki.setText(city.getUrlWiki());
		
		/* Take the ImageView from layout and set the city's image */
		ImageView imageCity = (ImageView) convertView.findViewById(R.id.ImageCity);
		String uri = "drawable/" + city.getImage();  //create the path to get the image from the drawable folder
	    int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
	    Drawable image = context.getResources().getDrawable(imageResource);
	    imageCity.setImageDrawable(image);

		return convertView;

	}
}

