package com.example.mike.learningfragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by mike on 8/11/2015.
 */
public class TopSectionFragment extends Fragment {

    //the eidt text fields and buttons
    private static EditText topText = null;
    private static EditText bottomText = null;
    private Button button = null;

    //this is an interface object
    TopSectionListener activityCommander = null;

    //creating an interface (implemented by the main activity)
    //if main activity wants to talk to this fragment must implement this
    public interface TopSectionListener{
        void create(String top, String bottom);
    }

    //called whenever a fragment gets attached to the activity
    //trying to create the interface
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCommander = (TopSectionListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    //method says it's a fragment, now setting what it looks like(get called as soon as fragment is made)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //is creating the reference to the xml file
        View view = inflater.inflate(R.layout.top_fragment, container, false);

        //links the buttons and editText fields together
        topText = (EditText)view.findViewById(R.id.top_text);
        bottomText = (EditText)view.findViewById(R.id.bottom_text);
        button = (Button)view.findViewById(R.id.enter_button);

        //sets up an onclick listener for the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });

        //returns the view from the xml file
        return view;
    }

    //calls this when the button is clicked
    public void buttonClicked(View v) {
        //this calls the create method that is implemented in the main activity
        activityCommander.create(topText.getText().toString(), bottomText.getText().toString());
    }
}
