package host.ng.com.eventbustest.adapter;

import android.content.Context;

import java.util.List;

import host.ng.com.eventbustest.R;
import host.ng.com.eventbustest.model.MockModel;
import superadapter.IMulItemViewType;
import superadapter.SuperAdapter;
import superadapter.internal.SuperViewHolder;


public class MultipleAdapter extends SuperAdapter<MockModel> {
    public MultipleAdapter(Context context, List<MockModel> list, IMulItemViewType<MockModel> multiItemViewType) {
        super(context, list, multiItemViewType);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, MockModel item) {
        switch (viewType) {
            case 0:
                holder.setText(R.id.tv_name, item.getName());
                break;
            case 1:
                holder.setText(R.id.tv_name, item.getName());
                holder.setImageResource(R.id.iv_portrait, R.mipmap.ic_launcher);
                holder.setText(R.id.tv_age, String.valueOf(item.getAge()));
                break;
        }
    }

    @Override
    protected IMulItemViewType<MockModel> offerMultiItemViewType() {
        return new IMulItemViewType<MockModel>() {
            @Override
            public int getViewTypeCount() {
                return 2;
            }

            @Override
            public int getItemViewType(int position, MockModel mockModel) {
                if (position % 2 == 0) {
                    return 0;
                }
                return 1;
            }

            @Override
            public int getLayoutId(int viewType) {
                if (viewType == 0) {
                    return R.layout.item_type1;
                }
                return R.layout.item_type2;
            }
        };
    }
}
