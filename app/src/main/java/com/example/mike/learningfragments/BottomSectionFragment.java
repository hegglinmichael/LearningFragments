package com.example.mike.learningfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mike on 8/11/2015.
 */
public class BottomSectionFragment extends Fragment {

    //the textViews
    private static TextView topText = null;
    private static TextView bottomText = null;

    //method says it's a fragment, now setting what it looks like
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //is creating the reference to the xml file
        View view = inflater.inflate(R.layout.bottom_fragment, container, false);

        //linking the textViews to the xml
        topText = (TextView)view.findViewById(R.id.top_text);
        bottomText = (TextView)view.findViewById(R.id.bottom_text);

        //returns the view from the xml file
        return view;
    }

    //sets the textViews equal to whatever we pass through them
    public void setBothText(String top, String bottom) {
        topText.setText(top);
        bottomText.setText(bottom);
    }
}
