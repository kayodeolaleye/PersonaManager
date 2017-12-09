package personamanager.com.personamanager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by oumar on 4/15/16.
 *
 * This activity lets the user choose from a list of social networks.
 * GridView is used to display the social network icons and each GridView is clickable
 * and launches a new activity that allows the user to log in to the respective social network
 * to view personal information
 */

public class SocialNetworkDataFragment extends Fragment {

    public SocialNetworkDataFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_social_network_data, container, false);
        GridView gridview = (GridView) view.findViewById(R.id.gridview);

        List<ItemObject> allItems = getAllItemObject();
        personamanager.com.personamanager.CustomAdapter customAdapter = new personamanager.com.personamanager.CustomAdapter(getActivity(), allItems);
        gridview.setAdapter(customAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0:
                        Intent myIntent0 = new Intent(view.getContext(), GoogleActivity.class);
                        startActivity(myIntent0);
                        break;
                    case 1:
                        Intent myIntent1 = new Intent(view.getContext(), LinkedInActivity.class);
                        startActivity(myIntent1);
                        break;

                    case 2:
                        Intent myIntent2 = new Intent(view.getContext(), TwitterActivity.class);
                        startActivity(myIntent2);
                        break;

                    case 3:
                        Intent myIntent3 = new Intent(view.getContext(),FacebookActivity.class);
                        startActivity(myIntent3);
                        break;

                    case 4:
                        Intent myIntent4 = new Intent(view.getContext(), InstagramActivity.class);
                        startActivity(myIntent4);
                        break;


                }
            }
        });
        return view;
    }

    private List<ItemObject> getAllItemObject() {
        List<ItemObject> items = new ArrayList<>();
        items.add(new ItemObject(R.drawable.google, "GOOGLE"));
        items.add(new ItemObject(R.drawable.linkedin, "LINKEDIN"));
        items.add(new ItemObject(R.drawable.twitter,"TWITTER"));
        items.add(new ItemObject(R.drawable.facebook, "FACEBOOK"));
        items.add(new ItemObject(R.drawable.imo,"IMO"));
        items.add(new ItemObject(R.drawable.instagram,"INSTAGRAM"));

        return items;
    }
}
