package personamanager.com.personamanager;



import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class WebCrawlerFragmentOne extends Fragment {

    private RecyclerView recyclerView;
    private WebCrawlerRecyclerViewAdapter adapter;
    public WebCrawlerFragmentOne() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.custom_row, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.rv);
        adapter = new WebCrawlerRecyclerViewAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        return layout;

    }

    public static List<WebList> getData() {
        List<WebList> data = new ArrayList<>();
        int[] logos = {R.drawable.ic_google, R.drawable.ic_linkedin, R.drawable.ic_facebook, R.drawable.ic_twitter,  R.drawable.ic_instagram};
        String[] thirdpartySites = {"Hollywoodrag.com", "dailymail.co.uk", "dailypost.ng", "companieshouse.gov.uk", "companieshouse.gov.uk"};

        for (int i = 0; i < logos.length && i < thirdpartySites.length; i++) {
            WebList current = new WebList();
            current.logo = logos[i];
            current.web = thirdpartySites[i];
            //current.source = sourceSites[i];
            data.add(current);
        }

        return data;
    }
}
