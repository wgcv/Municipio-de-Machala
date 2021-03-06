package me.wgcv.municipiomachala;

import android.app.Activity;
import android.content.res.Configuration;
import android.location.Location;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Wifi extends ActionBarActivity {
    MenuLateral menu;

    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        createMapView();
        menu = new MenuLateral(this);
        processMap();
    }

    private void createMapView(){
        /**
         * Catch the null pointer exception that
         * may be thrown when initialising the map
         */
        try {
            if(null == googleMap){
                googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.mapView)).getMap();

                /**
                 * If the map is still null after attempted initialisation,
                 * show an error to the user
                 */
                LatLng latLng1 = new LatLng( -3.267638, -79.952545);
                LatLng latLng2 = new LatLng( -3.258943, -79.959536);
                LatLng latLng3 = new LatLng( -3.260004, -79.958093);
                LatLng latLng4 = new LatLng( -3.260554, -79.954075);
                LatLng latLng5 = new LatLng( -3.255801, -79.962854);
                LatLng latLng6 = new LatLng( -3.262829, -79.957170);
                LatLng latLng7 = new LatLng(-3.265272, -79.952435);

                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng1, 15);
                googleMap.animateCamera(cameraUpdate);
                googleMap.addMarker(new MarkerOptions().position(latLng1).title("Wifi Centenario General"));
                googleMap.addMarker(new MarkerOptions().position(latLng2).title("Wifi Parque Central"));
                googleMap.addMarker(new MarkerOptions().position(latLng3).title("Wifi Paseo Cultural Lic. Diego Minuche Garrido"));
                googleMap.addMarker(new MarkerOptions().position(latLng4).title("Wifi Plaza Colón"));
                googleMap.addMarker(new MarkerOptions().position(latLng5).title("Wifi Parque de Los Heroes"));
                googleMap.addMarker(new MarkerOptions().position(latLng6).title("Wifi Tanque Rojo"));
                googleMap.addMarker(new MarkerOptions().position(latLng7).title("Wifi Parque Ismael Pérez Pazmiño"));
                googleMap.setMyLocationEnabled(true);

                if(null == googleMap) {
                    Toast.makeText(getApplicationContext(),
                            "Error creating map", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (NullPointerException exception){
            Log.e("mapApp", exception.toString());
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        menu.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        menu.onConfigurationChanged(newConfig);
    }

    public void processMap()
    {
        if(googleMap==null)
        {

           // googleMap=fragment.getMap();
            if(googleMap!=null)
            {
                LatLng latLng = new LatLng( -3.26667, -79.95);
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 17);
                googleMap.animateCamera(cameraUpdate);
                googleMap.addMarker(new MarkerOptions().position(latLng).title("MACHALA"));
            }
        }
    }
}
