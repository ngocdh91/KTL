package kl.tool.ngoc.ktl.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import io.realm.Realm;
import kl.tool.ngoc.ktl.R;
import kl.tool.ngoc.ktl.Util;
import kl.tool.ngoc.ktl.model.ExOneModel;


/**
 * Created by Ngocdh on 29,November,2016
 */

public class ExOneAdapter extends RecyclerView.Adapter<ExOneAdapter.ExOneHolder> {
    List<ExOneModel> mListData;
    double totaln, totalY, totalX1, totalX2;
    Realm mRealm;

    public ExOneAdapter(List<ExOneModel> mListData, Realm realm) {
        this.mListData = mListData;
        for (ExOneModel model : mListData) {
            totaln += model.getN();
            totalX1 += model.getX1();
            totalX2 += model.getX2();
            totalY += model.getY();
        }
        this.mRealm = realm;
    }

    @Override
    public ExOneAdapter.ExOneHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_ex_one, parent, false);
        ExOneHolder holder = new ExOneHolder(view);
        holder.lnItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new CustomDialogExOne(view.getContext(), mRealm);
            }
        });

        return holder;
    }


    @Override
    public void onBindViewHolder(ExOneAdapter.ExOneHolder holder, int position) {
        
        holder.value1.setText(Util.formatNumberDecimal((mListData.get(position).getY() - totalY) / mListData.size()));
        holder.value2.setText(Util.formatNumberDecimal(mListData.get(position).getX1() - totalX1 / mListData.size()));
        holder.value3.setText(Util.formatNumberDecimal(mListData.get(position).getX2() - totalX2 / mListData.size()));
        holder.value4.setText(Util.formatNumberDecimal((mListData.get(position).getY() - totalY) / mListData.size() * (mListData.get(position).getX1() - totalX1 / mListData.size())));
        holder.value5.setText(Util.formatNumberDecimal((mListData.get(position).getY() - totalY) / mListData.size() * (mListData.get(position).getX2() - totalX2 / mListData.size())));
        holder.value6.setText(Util.formatNumberDecimal((mListData.get(position).getX1() - totalX1 / mListData.size()) * (mListData.get(position).getX2() - totalX2 / mListData.size())));
        holder.value7.setText(Util.formatNumberDecimal((mListData.get(position).getX1() - totalX1 / mListData.size()) * (mListData.get(position).getX1() - totalX1 / mListData.size())));
        holder.value8.setText(Util.formatNumberDecimal((mListData.get(position).getX2() - totalX2 / mListData.size()) * (mListData.get(position).getX2() - totalX2 / mListData.size())));


    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public static class ExOneHolder extends RecyclerView.ViewHolder {
        LinearLayout lnItem;
        TextView value1, value2, value3, value4, value5, value6, value7, value8;


        public ExOneHolder(View v) {
            super(v);
            lnItem = (LinearLayout) v.findViewById(R.id.item);
            value1 = ButterKnife.findById(v, R.id.value1);
            value2 = ButterKnife.findById(v, R.id.value2);
            value3 = ButterKnife.findById(v, R.id.value3);
            value4 = ButterKnife.findById(v, R.id.value4);
            value5 = ButterKnife.findById(v, R.id.value5);
            value6 = ButterKnife.findById(v, R.id.value6);
            value7 = ButterKnife.findById(v, R.id.value7);
            value8 = ButterKnife.findById(v, R.id.value8);
        }
    }
}
