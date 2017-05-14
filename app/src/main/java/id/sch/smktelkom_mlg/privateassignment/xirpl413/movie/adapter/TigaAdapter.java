package id.sch.smktelkom_mlg.privateassignment.xirpl413.movie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl413.movie.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl413.movie.model.Result;

/**
 * Created by rongrong on 14/05/2017.
 */

public class TigaAdapter extends RecyclerView.Adapter<TigaAdapter.ViewHolder> {
    ArrayList<Result> listm;
    ITigaAdapter mITigaAdapter;
    Context context;

    public TigaAdapter(Context context, ArrayList<Result> list) {
        this.listm = list;
        this.context = context;
        mITigaAdapter = (ITigaAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tigalayout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result result = listm.get(position);
        holder.tvName.setText(result.title);
        holder.tvDesc.setText(result.overview);
        holder.itemView.setBackgroundColor(result.color);
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w500" + result.poster_path)
                .into(holder.ivData);
    }

    @Override
    public int getItemCount() {
        if (listm != null)
            return listm.size();
        return 0;
    }

    public interface ITigaAdapter {
        void showArticles(String original_title, String overview);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDesc;
        ImageView ivData;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.textViewJudulTiga);
            tvDesc = (TextView) itemView.findViewById(R.id.textViewDeskripsiTiga);
            ivData = (ImageView) itemView.findViewById(R.id.imageViewTiga);
        }
    }
}
