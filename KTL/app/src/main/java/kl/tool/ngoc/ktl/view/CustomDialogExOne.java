package kl.tool.ngoc.ktl.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.afollestad.materialdialogs.MaterialDialog;
import kl.tool.ngoc.ktl.R;

/**
 * Created by Ngocdh on 26,December,2016
 */

public class CustomDialogExOne extends AppCompatActivity {
    Context mContext;
    public CustomDialogExOne(Context context){
        mContext = context;
        new MaterialDialog.Builder(this)
                .title(R.string.title)
                .customView(R.layout.exone_input, true)
                .positiveText(R.string.positive)
                .negativeText(R.string.negative)
                .show();
    }
}
