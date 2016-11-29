package kl.tool.ngoc.ktl.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

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
        return 1;
    }

    public static class ExOneHolder extends RecyclerView.ViewHolder {
        EditText value1, value2, value3;
        double c, s, t;
        int lastSelected = 0;

        public ExOneHolder(View v) {
            super(v);
            value1 = (EditText) v.findViewById(R.id.value1);
            value1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (value1.isFocused())
                        if (!isValue1Valid(editable)) {
                            c = 0;
                        } else {
                            if (t != 0)
                                value2.setText("" + c / t);
                            if (s != 0)
                                value3.setText("" + c / s);
                        }

                }
            });
            value2 = (EditText) v.findViewById(R.id.value2);
            value2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }


                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }


                @Override
                public void afterTextChanged(Editable editable) {
                    if (value2.isFocused())
                        if (!isValue2Valid(editable)) {
                            s = 0;
                        } else {
                            value1.setText("" + s * t);
                            if (s != 0)
                                value3.setText("" + c / s);
                        }

                }
            });
            value3 = (EditText) v.findViewById(R.id.value3);
            value3.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (value3.isFocused())
                        if (!isValue3Valid(editable)) {
                            t = 0;
                        } else {
                            value1.setText("" + t * s);
                            if (t != 0)
                                value2.setText("" + c / t);
                        }

                }
            });
        }

        private boolean isValue1Valid(Editable editable) {
            try {
                String number = editable.toString();
                double price = Double.parseDouble(number);
                if (price > 999999999999f)
                    return false;
                c = price;
                return true;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            } catch (ClassCastException e) {
                e.printStackTrace();
                return false;
            }
        }

        private boolean isValue2Valid(Editable editable) {
            try {
                String number = editable.toString();
                double price = Double.parseDouble(number);
                if (price > 999999999999f)
                    return false;
                s = price;
                return true;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            } catch (ClassCastException e) {
                e.printStackTrace();
                return false;
            }
        }

        private boolean isValue3Valid(Editable editable) {
            try {
                String number = editable.toString();
                double price = Double.parseDouble(number);
                if (price > 999999999999f)
                    return false;
                t = price;
                return true;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            } catch (ClassCastException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
