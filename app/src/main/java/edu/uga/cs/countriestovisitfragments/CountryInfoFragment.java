package edu.uga.cs.countriestovisitfragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.InputStream;

/*
    This fragment contains the layout and information for country info

    @Author: Tommy Fricano
    @Date: 10/3/2022
 */
public class CountryInfoFragment extends Fragment {

    TextView countryTitle;
    ImageView countryPicture;
    TextView countryInfo;
    ImageView countryFlag;

    public CountryInfoFragment(){}

    /*
        @params: int countryIndex

        NewInstances of CountryInfoFragment creates a fragment
        that holds a bundle with the countryIndex as an "argument"
        then returns the fragment
     */
    public static CountryInfoFragment newInstance( int countryIndex) {

        CountryInfoFragment frag = new CountryInfoFragment();

        Bundle args = new Bundle();
        args.putInt( "countryIndex", countryIndex );
        frag.setArguments( args );

        return frag;
    }

    /*
        @params: LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
        Ensures there are no other containers then renders(inflates) layout of the fragment into
        a view which is returned
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        if( container != null )
            container.removeAllViews();

        View view = inflater.inflate( R.layout.fragment_info, container, false );

        return view;
    }

    /*
        @params: View view, Bundle savedInstanceState
        The onViewCreated sets the images and text within the layout

     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        countryTitle = view.findViewById(R.id.overViewTitle);
        countryPicture = view.findViewById(R.id.imageOverview);
        countryInfo = view.findViewById(R.id.countryInfoId);
        countryFlag = view.findViewById(R.id.imageOverview2);

        int index = getShownCountry();                                          // corresponding country-choice

        /*
          index 0 = italy
          index 1 = Peru
          index 2 = Iceland
          index 3 = Egypt
          index 4 = Australia
         */
        if( index == 0 ) {
            countryTitle.setText( "Italy" );                                    // set title
            countryPicture.setImageResource(R.drawable.italy_overview);         // set image
            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource( R.raw.italy_info );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                countryInfo.setText( new String(b) );                           //set article text
            } catch (Exception e) {
                countryInfo.setText( "Error: can't show info text." );
            }
            countryFlag.setImageResource(R.drawable.italy_flag);                //set flag
        }
        else if(index == 1){
            countryTitle.setText( "Peru" );
            countryPicture.setImageResource(R.drawable.peru_overview);
            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource( R.raw.peru_info );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                countryInfo.setText( new String(b) );
            } catch (Exception e) {
                countryInfo.setText( "Error: can't show info text." );
            }
            countryFlag.setImageResource(R.drawable.peru_flag);                //set flag
        }
        else if(index == 2){
            countryTitle.setText( "Iceland" );
            countryPicture.setImageResource(R.drawable.iceland_overview);
            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource( R.raw.iceland_info );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                countryInfo.setText( new String(b) );
            } catch (Exception e) {
                countryInfo.setText( "Error: can't show info text." );
            }
            countryFlag.setImageResource(R.drawable.iceland_flag);                //set flag
        }
        else if(index == 3){
            countryTitle.setText( "Egypt" );
            countryPicture.setImageResource(R.drawable.egypt_overview);
            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource( R.raw.egypt_info );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                countryInfo.setText( new String(b) );
            } catch (Exception e) {
                countryInfo.setText( "Error: can't show info text." );
            }
            countryFlag.setImageResource(R.drawable.egypt_flag);                //set flag
        }
        else if(index == 4){
            countryTitle.setText( "Australia" );
            countryPicture.setImageResource(R.drawable.australia_overview);
            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource( R.raw.australia_info );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                countryInfo.setText( new String(b) );
            } catch (Exception e) {
                countryInfo.setText( "Error: can't show info text." );
            }
            countryFlag.setImageResource(R.drawable.australia_flag);                //set flag
        }
    }

    /*
        Gets the index value from corresponding selection
     */
    public int getShownCountry() {
        return getArguments().getInt("countryIndex", 0 );
    }
}
