package personamanager.com.personamanager;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kola on 4/15/16.
 *
 * This activity lets the user choose from a list of social networks.
 * RecyclerView is used to display the social network icons and each is clickable
 * and launches a new activity that allows the user to log in to the respective social network
 * to see what application has access to personal data.
 */

public class PhoneAppsDataFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    public PhoneAppsDataFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.custom_row, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.rv);
        adapter = new RecyclerViewAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        return layout;

    }

    public static List<Information> getData() {
        List<Information> data = new ArrayList<>();
        int[] logos = {R.drawable.ic_google, R.drawable.ic_linkedin, R.drawable.ic_facebook, R.drawable.ic_twitter,  R.drawable.ic_instagram,
                R.drawable.ic_imo};
        String[] thirdpartySites = {"Google", "LinkedIn", "Facebook", "Twitter", "Instagram", "Imo"};
        //String[] sourceSites = {"Facebook", "Twitter", "LinkedInActivity", "Facebook", "Twitter", "LinkedInActivity", "Facebook", "Twitter"};

        for (int i = 0; i < logos.length && i < thirdpartySites.length; i++) {
            Information current = new Information();
            current.logoId = logos[i];
            current.thirdParty = thirdpartySites[i];
            //current.source = sourceSites[i];
            data.add(current);
        }

        return data;
    }
}
