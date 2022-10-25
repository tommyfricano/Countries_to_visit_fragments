package edu.uga.cs.countriestovisitfragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

/*
List fragment for the country list
This class implements the array adapter needed for the list fragment

@Author: Tommy Fricano
@Date: 10/3/2022
 */
public class CountryListFragment extends ListFragment {
    private final String[] countries = {
            "Italy","Peru","Iceland","Egypt","Australia"};

    boolean twoFragmentsActivity = false;
    int countryIndex = 0;

    public CountryListFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*
        @params: View view, Bundle savedInstanceState
        This function creates the list adapter with the corresponding orientation
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        super.onViewCreated(view, savedInstanceState);

        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_activated_1, countries));

        View detailsFrame = getActivity().findViewById( R.id.countryInfo );

        twoFragmentsActivity = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if( savedInstanceState != null ) {
            countryIndex = savedInstanceState.getInt("countrySelection", 0);
        }

        getListView().setChoiceMode( ListView.CHOICE_MODE_SINGLE );         // can only click one item
        getListView().setItemChecked( countryIndex, true );           // sets country index

        if( twoFragmentsActivity ) {                                        // if landscape mode set both fragments
            showCountryInfo( countryIndex );                                // show info
            getListView().smoothScrollToPosition( countryIndex );           // show list with scroll
        }
    }

    /*
    @params: ListView l, View v, int position, long id
    shows country info based on of selected choice through index position
     */
    @Override
    public void onListItemClick( ListView l, View v, int position, long id ) {
        showCountryInfo( position );
    }

    /*
    @params: int countryIndex
    This shows the country info fragment in both orientations
     */
    private void showCountryInfo(int countryIndex) {
        this.countryIndex = countryIndex;

        if(twoFragmentsActivity){
            getListView().setItemChecked( countryIndex, true );

            // get the placeholder element (FrameLayout) in a 2 fragment (landscape) orientation layout
            CountryInfoFragment details =
                    (CountryInfoFragment) getParentFragmentManager().findFragmentById( R.id.countryInfo );

            if( details == null || details.getShownCountry() != countryIndex ) {

                // obtain a new Android info fragment instance
                details = CountryInfoFragment.newInstance( countryIndex );

                // replace the placeholder with the new fragment stance within a transaction
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace( R.id.countryInfo, details );

                // TRANSIT_FRAGMENT_FADE means that the fragment should fade in or fade out
                fragmentTransaction.setTransition( FragmentTransaction.TRANSIT_FRAGMENT_FADE );

                // commit the transaction, i.e. make the changes
                fragmentTransaction.commit();
            }
        }
        else {
            // In a 1 fragment orientation (portrait), start a new activity using an Intent, as in the previous demo app
            Intent intent = new Intent();
            intent.setClass( getActivity(), CountryInfoFragmentActivity.class );
            intent.putExtra("countryIndex", countryIndex);

            startActivity( intent );
        }
    }

    @Override
    public void onSaveInstanceState( Bundle outState ) {
        super.onSaveInstanceState(outState);

        // save the list index selection
        outState.putInt( "countrySelection" , countryIndex);
    }

}
