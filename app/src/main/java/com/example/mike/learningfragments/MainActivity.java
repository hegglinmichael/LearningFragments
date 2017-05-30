package com.example.mike.learningfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//Fragments are reusable bits of code
//Part of an activity (1 activity can have multiple Fragments)
//fragments do not talk directly to each other

public class MainActivity extends AppCompatActivity implements TopSectionFragment.TopSectionListener{

    //creating a bottomFragment object
    BottomSectionFragment bottomSectionFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //this gets called by the Top Fragment when the user clicks the button
    @Override
    public void create(String top, String bottom) {
        //initializing the bottom fragment object
        bottomSectionFragment = (BottomSectionFragment)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        //strings come from the top of the method and et set in the bottom method w/below code
        bottomSectionFragment.setBothText(top, bottom);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
