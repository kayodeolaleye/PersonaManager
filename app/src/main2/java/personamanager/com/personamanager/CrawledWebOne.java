package personamanager.com.personamanager;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kola on 4/17/16.
 *
 * This activity is used to crawl specific web page; in this case "http://www.hollywoodrag.com/category/surgery/"
 * and displays the result using a ListView and ArrayAdapter
 * The crawling task is not done on the main thread but handled in the background with AsyncTask
 */
public class CrawledWebOne extends AppCompatActivity{
    String url = "http://www.hollywoodrag.com/category/surgery/";
    ListView mListView;
    ArrayList<String> mData = new ArrayList<>();
    ArrayAdapter<String> mAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crawledweb);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        mListView = (ListView) findViewById(R.id.listview);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mData);

        new ParseURL().execute();

    }


    public class ParseURL extends AsyncTask<Void, Void, Void> {
        String title;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressDialog = new ProgressDialog(CrawledWebOne.this);
            progressDialog.setTitle("");
            progressDialog.setMessage("Crawling Hollywoodrag.com/...");
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void...params) {
            try{
                //String userAgent = System.getProperty("http.agent");
                Document document = Jsoup.connect(url)
                        .header("Accept-Encoding", "gzip, deflate")
                        .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
                        .maxBodySize(0)
                        .timeout(600000)
                        .get();

                Elements headlines = document.select(".post header .title a");
                for (Element headline : headlines) {
                    mData.add(headline.text());
                    mData.add(headline.attr("href"));
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
        protected void onPostExecute(Void aVoid) {

            mListView.setAdapter(mAdapter);
            progressDialog.dismiss();
        }
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


