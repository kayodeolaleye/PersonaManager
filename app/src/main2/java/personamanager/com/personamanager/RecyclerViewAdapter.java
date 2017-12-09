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


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    List<Information> data = Collections.emptyList();
    public RecyclerViewAdapter(Context context, List<Information> data) {
        this.context=context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_phone_apps_data, parent, false);

        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Information current = data.get(position);
        holder.logo.setImageResource(current.logoId);
        holder.thirdPartyName.setText(current.thirdParty);
        //holder.sourceName.setText(current.source);

    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView thirdPartyName;
        TextView sourceName;
        ImageView logo;

        public MyViewHolder(View itemView) {
            super(itemView);

            logo = (ImageView) itemView.findViewById(R.id.logo_photo);
            thirdPartyName = (TextView) itemView.findViewById(R.id.thirdparty_name);
            //sourceName  = (TextView) itemView.findViewById(R.id.source_name);
            itemView.setOnClickListener(this);

        }
//
        @Override
        public void onClick(View v) {

        switch (getAdapterPosition()){
        case 0:
            Intent intent0 =  new Intent(context, GoogleExternalActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("DATA", data.get(getAdapterPosition()));
            intent0.putExtras(bundle);
            int position = getAdapterPosition();
            context.startActivity(intent0);
            break;


        case 1:
            Intent intent1 =  new Intent(context, LinkedInExternalActivity.class);
            bundle = new Bundle();
            bundle.putSerializable("DATA", data.get(getAdapterPosition()));
            intent1.putExtras(bundle);
            position = getAdapterPosition();
            context.startActivity(intent1);
            break;

            case 2:
                Intent intent3 =  new Intent(context, FacebookExternalActivity.class);
                bundle = new Bundle();
                bundle.putSerializable("DATA", data.get(getAdapterPosition()));
                intent3.putExtras(bundle);
                position = getAdapterPosition();
                context.startActivity(intent3);
                break;

            case 3:
                Intent intent2 =  new Intent(context, TwitterExternalActivity.class);
                bundle = new Bundle();
                bundle.putSerializable("DATA", data.get(getAdapterPosition()));
                intent2.putExtras(bundle);
                position = getAdapterPosition();
                context.startActivity(intent2);
                break;

            case 4:
                Intent intent4 =  new Intent(context, InstagramExternalActivity.class);
                bundle = new Bundle();
                bundle.putSerializable("DATA", data.get(getAdapterPosition()));
                intent4.putExtras(bundle);
                position = getAdapterPosition();
                context.startActivity(intent4);
                break;

            case 5:
            Intent intent5 =  new Intent(context, AOLExternalActivity.class);
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
