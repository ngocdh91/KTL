package kl.tool.ngoc.ktl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import kl.tool.ngoc.ktl.adapter.ExOneAdapter;
import kl.tool.ngoc.ktl.view.DividerItemDecoration;

/**
 * Created by Ngocdh on 29,November,2016
 */

public class DoExOneActivity extends AppCompatActivity {
    Toolbar mToolbar;
    RecyclerView mRvItem;
    private ExOneAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_one);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRvItem = (RecyclerView) findViewById(R.id.rv_item);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //set adapter
        mAdapter = new ExOneAdapter();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvItem.setLayoutManager(layoutManager);
        mRvItem.addItemDecoration(new DividerItemDecoration(this, R.drawable.item_divider_simple));
        mRvItem.setAdapter(mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

        }
        return false;
    }
}
