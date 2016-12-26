package kl.tool.ngoc.ktl.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kl.tool.ngoc.ktl.R;


/**
 * Created by Ngocdh on 29,November,2016
 */

public class ExOneAdapter extends RecyclerView.Adapter<ExOneAdapter.ExOneHolder> {
    public ExOneAdapter() {

    }

    @Override
    public ExOneAdapter.ExOneHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_ex_one, parent, false);
        ExOneHolder holder = new ExOneHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(ExOneAdapter.ExOneHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class ExOneHolder extends RecyclerView.ViewHolder {
        TextView value1, value2, value3, value4, value5, value6, getValue67, value8;


        public ExOneHolder(View v) {
            super(v);
        }
    }
}
