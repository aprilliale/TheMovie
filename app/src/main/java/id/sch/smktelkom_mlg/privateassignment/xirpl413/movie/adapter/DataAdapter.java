package id.sch.smktelkom_mlg.privateassignment.xirpl413.movie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl413.movie.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl413.movie.model.Result;

/**
 * Created by rongrong on 14/05/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    ArrayList<Result> listm;
    IDataAdapter mIDataAdapter;

    public DataAdapter(Context context, ArrayList<Result> list) {
        this.listm = list;
        mIDataAdapter = (IDataAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.datalayout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result result = listm.get(position);
        holder.tvName.setText(result.original_title);
        holder.tvDesc.setText(result.overview);
        holder.itemView.setBackgroundColor(result.color);

    }

    @Override
    public int getItemCount() {
        if (listm != null)
            return listm.size();
        return 0;
    }

    public interface IDataAdapter {
        void showArticles(String original_title, String overview);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.textViewJud);
            tvDesc = (TextView) itemView.findViewById(R.id.textViewDes);
        }
    }
}
