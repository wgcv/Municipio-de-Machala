package me.wgcv.municipiomachala;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wgcv on 13/06/15.
 */
public class MenuLateral {
    public Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView leftDrawerList;
    private ArrayAdapter<String> navigationDrawerAdapter;
    private String[] menu = {"Inicio", "Android", "Sitemap", "About", "Contact Me"};
    private Principal principal;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    public MenuLateral(Principal principal){
        this.principal = principal;
        nitView();
        if (toolbar != null) {
            toolbar.setTitle("Municipio de Machala");
            principal.setSupportActionBar(toolbar);
        }
        initDrawer();
        // get the listview
        expListView = (ExpandableListView) principal.findViewById(R.id.lvExp);
        // preparing list data
        prepareListData();
        listAdapter = new ExpandableListAdapter(principal, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);
    }
    public void syncState() {
        drawerToggle.syncState();

    }
    public void onConfigurationChanged(Configuration newConfig){
        drawerToggle.onConfigurationChanged(newConfig);

    }
    private void nitView() {
       // leftDrawerList = (ListView) principal.findViewById(R.id.left_drawer);
        toolbar = (Toolbar) principal.findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) principal.findViewById(R.id.drawerLayout);
       // navigationDrawerAdapter=new ArrayAdapter<String>( principal, android.R.layout.simple_list_item_1, menu);
        //leftDrawerList.setAdapter(navigationDrawerAdapter);
    }

    private void initDrawer() {

        drawerToggle = new ActionBarDrawerToggle(principal, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }


    /*
   * Preparing the list data
   */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Top 250");
        listDataHeader.add("Now Showing");
        listDataHeader.add("Coming Soon..");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}
