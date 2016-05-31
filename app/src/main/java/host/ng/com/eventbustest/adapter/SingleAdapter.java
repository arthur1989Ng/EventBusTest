package host.ng.com.eventbustest.adapter;

import android.content.Context;


import java.util.List;

import host.ng.com.eventbustest.R;
import superadapter.SuperAdapter;
import superadapter.internal.SuperViewHolder;


public class SingleAdapter extends SuperAdapter<String> {
    public SingleAdapter(Context context, List<String> list, int layoutResId) {
        super(context, list, layoutResId);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, String item) {
        holder.setText(R.id.tv_name, item);
    }
}
