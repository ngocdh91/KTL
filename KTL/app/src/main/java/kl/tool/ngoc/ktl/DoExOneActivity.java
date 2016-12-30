package kl.tool.ngoc.ktl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import kl.tool.ngoc.ktl.adapter.ExOneAdapter;
import kl.tool.ngoc.ktl.model.ExOneModel;
import kl.tool.ngoc.ktl.view.CustomDialogExOne;
import kl.tool.ngoc.ktl.view.DividerItemDecoration;

/**
 * Created by Ngocdh on 29,November,2016
 */

public class DoExOneActivity extends AppCompatActivity implements RealmChangeListener<ExOneModel> {
    Toolbar mToolbar;
    RecyclerView mRvItem;
    List<ExOneModel> mListData;
    Realm mRealm;
    private ExOneAdapter mAdapter;
    private double totaln, totalY, totalX1, totalX2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_one);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRvItem = (RecyclerView) findViewById(R.id.rv_item);
        setSupportActionBar(mToolbar);
        Realm.init(getApplicationContext());
        mRealm = Realm.getDefaultInstance();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mListData = new ArrayList<>();
        mListData = mRealm.where(ExOneModel.class).findAll();
        //set adapter
        mAdapter = new ExOneAdapter(mListData,mRealm);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvItem.setLayoutManager(layoutManager);
        mRvItem.addItemDecoration(new DividerItemDecoration(this, R.drawable.item_divider_simple));
        mRvItem.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_add:
                new CustomDialogExOne(this,mRealm , mListData ,mAdapter);

        }
        return false;
    }

    @Override
    public void onChange(ExOneModel element) {


        mAdapter.notifyDataSetChanged();

    }
}
