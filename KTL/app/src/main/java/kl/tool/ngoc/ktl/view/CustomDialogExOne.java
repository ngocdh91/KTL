package kl.tool.ngoc.ktl.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.List;

import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import kl.tool.ngoc.ktl.R;
import kl.tool.ngoc.ktl.adapter.ExOneAdapter;
import kl.tool.ngoc.ktl.model.ExOneModel;

/**
 * Created by Ngocdh on 26,December,2016
 */

public class CustomDialogExOne implements RealmChangeListener<ExOneModel>{
    Context mContext;
    MaterialDialog dialog;
    EditText mVal1, mVal2, mVal3, mVal4;
    ExOneModel model;
    ExOneAdapter mAdapter;
    List<ExOneModel> mListData;
    Realm mRealm;
    public CustomDialogExOne(Context context, final Realm realm, List<ExOneModel> mListData,ExOneAdapter mAdapter) {
        mContext = context;
        this.mListData = mListData;
        mRealm = realm;
        this.mAdapter = mAdapter;
        dialog = new MaterialDialog.Builder(mContext)
                .title(R.string.title)
                .customView(R.layout.exone_input, true)
                .positiveText(R.string.positive)
                .negativeText(R.string.negative)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                        ExOneModel model = new ExOneModel();
                        model.setN(Double.parseDouble(mVal1.getText().toString()));
                        model.setY(Double.parseDouble(mVal2.getText().toString()));
                        model.setX1(Double.parseDouble(mVal3.getText().toString()));
                        model.setX2(Double.parseDouble(mVal4.getText().toString()));
                        model.setKey(System.currentTimeMillis());
                        realm.beginTransaction();
                        realm.copyToRealmOrUpdate(model);
                        realm.commitTransaction();

                    }
                }).onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                }).build();
        View customView = dialog.getCustomView();
        mVal1 =  ButterKnife.findById(customView, R.id.value1);
        mVal2 =  ButterKnife.findById(customView, R.id.value2);
        mVal3 =  ButterKnife.findById(customView, R.id.value3);
        mVal4 =  ButterKnife.findById(customView, R.id.value4);
        dialog.show();
    }

    @Override
    public void onChange(ExOneModel element) {
        mListData = mRealm.where(ExOneModel.class).findAll();
    }
}
