package personamanager.com.personamanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by kola on 4/17/16.
 * This class handles the RecyclerView.
 * RecyclerView is used to display the list of website to crawl and when clicked,
 * launches a new activity that displays the content of the webpage
 *
 */
public class WebCrawlerRecyclerViewAdapter extends RecyclerView.Adapter<WebCrawlerRecyclerViewAdapter.MH> {

    private LayoutInflater inflater;
    private Context context;
    List<WebList> data = Collections.emptyList();

    public WebCrawlerRecyclerViewAdapter(Context context, List<WebList> data) {
        this.context=context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    @Override
    public WebCrawlerRecyclerViewAdapter.MH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_web_crawler, parent, false);

        MH holder = new MH(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(WebCrawlerRecyclerViewAdapter.MH holder, int position) {

        WebList current = data.get(position);
        holder.logo.setImageResource(current.logo);
        holder.webName.setText(current.web);
        //holder.sourceName.setText(current.source);

    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    public class MH extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView webName;
//        TextView sourceName;
        ImageView logo;

        public MH(View itemView) {
            super(itemView);

            logo = (ImageView) itemView.findViewById(R.id.logo_photo);
            webName = (TextView) itemView.findViewById(R.id.thirdparty_name);
            //sourceName  = (TextView) itemView.findViewById(R.id.source_name);
            itemView.setOnClickListener(this);

        }
        //
        @Override
        public void onClick(View v) {

            switch (getAdapterPosition()){

                case 0:
                    Intent intent1 =  new Intent(context, CrawledWebOne.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("DATA", data.get(getAdapterPosition()));
                    intent1.putExtras(bundle);
                    int position = getAdapterPosition();
                    position = getAdapterPosition();
                    context.startActivity(intent1);
                    break;

                case 1:
                    Intent intent2 =  new Intent(context, CrawledWebTwo.class);
                    bundle = new Bundle();
                    bundle.putSerializable("DATA", data.get(getAdapterPosition()));
                    intent2.putExtras(bundle);
                    position = getAdapterPosition();
                    context.startActivity(intent2);
                    break;

                case 2:
                    Intent intent3 =  new Intent(context, CrawledWebThree.class);
                    bundle = new Bundle();
                    bundle.putSerializable("DATA", data.get(getAdapterPosition()));
                    intent3.putExtras(bundle);
                    position = getAdapterPosition();
                    context.startActivity(intent3);
                    break;

                case 3:
                    Intent intent4 =  new Intent(context, CrawledWebFour.class);
                    bundle = new Bundle();
                    bundle.putSerializable("DATA", data.get(getAdapterPosition()));
                    intent4.putExtras(bundle);
                    position = getAdapterPosition();
                    context.startActivity(intent4);
                    break;

                case 4:
                    Intent intent5 =  new Intent(context, CrawledWebFive.class);
                    bundle = new Bundle();
                    bundle.putSerializable("DATA", data.get(getAdapterPosition()));
                    intent5.putExtras(bundle);
                    position = getAdapterPosition();
                    context.startActivity(intent5);
                    break;
            }

        }

    }
}
