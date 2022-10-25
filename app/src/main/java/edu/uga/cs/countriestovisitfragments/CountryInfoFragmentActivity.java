package edu.uga.cs.countriestovisitfragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;


/*
    This class manages the fragment activity
    @Author:Tommy Fricano
    @Date: 10/2/2022
 */
public class CountryInfoFragmentActivity extends AppCompatActivity {

    /*
        @Params: Bundle savedInstanceState
        onCreate ensures the orientation
        creates the correct fragment(s)
        sets the intent
        makes the transaction to set the content to the info fragment
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if( getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE ) {
            finish();
            return;
        }

        CountryInfoFragment countryInfoFragment = new CountryInfoFragment();
        countryInfoFragment.setArguments( getIntent().getExtras() );
        getSupportFragmentManager().beginTransaction().replace( android.R.id.content, countryInfoFragment ).commit();
    }
}
