package me.wgcv.municipiomachala;

import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Municipio extends ActionBarActivity {
    MenuLateral menu;

    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipio);
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
                LatLng latLng = new LatLng( -3.258485, -79.959125);
                LatLng latLng1 = new LatLng( -3.258544, -79.958936);


                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 17);
                googleMap.animateCamera(cameraUpdate);
                googleMap.addMarker(new MarkerOptions().position(latLng).title("GAD Municipal de Machala"));
                googleMap.addMarker(new MarkerOptions().position(latLng1).title("Municipio de Machala"));


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
                LatLng latLng = new LatLng( -3.258485, -79.959125);
                LatLng latLng1 = new LatLng( -3.258544, -79.958936);


                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 17);
                googleMap.animateCamera(cameraUpdate);
                googleMap.addMarker(new MarkerOptions().position(latLng).title("GAD Municipal de Machala"));
                googleMap.addMarker(new MarkerOptions().position(latLng).title("Municipio de Machala"));

            }
        }
    }
}
