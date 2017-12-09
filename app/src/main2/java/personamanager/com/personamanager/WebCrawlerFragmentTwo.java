package personamanager.com.personamanager;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kola on 4/24/16.
 *
 * This fragment lets user typr in a URL and crawls the URL to return thwe content of the URL.
 */
public class WebCrawlerFragmentTwo extends Fragment {
    Button button;
    ListView mListView;
    ArrayList<String> mData = new ArrayList<>();
    ArrayAdapter<String> mAdapter;
    ProgressDialog progressDialog;

    public  WebCrawlerFragmentTwo() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.activity_webcrawler, container, false);

        final EditText editUrl = (EditText) layout.findViewById(R.id.editURL);
        button = (Button) layout.findViewById(R.id.buttonGo);
        mListView = (ListView) layout.findViewById(R.id.listview);
        mAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,mData);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String siteUrl = editUrl.getText().toString();
                new ParseURL().execute(new String[]{siteUrl});
            }
        });

        return layout;

    }


    public class ParseURL extends AsyncTask<String, Void, String> {
        String title;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setTitle("");
            progressDialog.setMessage("Crawling Hollywoodrag.com/...");
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String...strings) {
            try{
                //String userAgent = System.getProperty("http.agent");
                Document document = Jsoup.connect(strings[0])
                        .header("Accept-Encoding", "gzip, deflate")
                        .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
                        .maxBodySize(0)
                        .timeout(600000)
                        .get();

                Elements headlines = document.select(".post header .title a");
                for (Element headline : headlines) {
                    mData.add(headline.text());
                }


                if (mData.size()==0){
                    mData.add("Empty result");
                }
            }catch (IOException e){
                e.printStackTrace();
                mData.clear();
                mData.add("Exception: " + e.toString());
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s) {

            mListView.setAdapter(mAdapter);
            progressDialog.dismiss();
        }
    }

}
