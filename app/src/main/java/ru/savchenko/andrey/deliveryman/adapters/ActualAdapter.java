package ru.savchenko.andrey.deliveryman.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.base.BaseAdapter;
import ru.savchenko.andrey.deliveryman.base.BaseViewHolder;
import ru.savchenko.andrey.deliveryman.entities.Order;
import ru.savchenko.andrey.deliveryman.interfaces.OnItemClickListener;

/**
 * Created by Andrey on 25.09.2017.
 */
public class ActualAdapter extends BaseAdapter {
    private static final String TAG = "ActualAdapter";

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new ActualViewHolder(view);
    }

    class ActualViewHolder extends BaseViewHolder<Order>{
        @BindView(R.id.tvOrderBody)
        TextView tvOrderBody;
        @BindView(R.id.tvTime) TextView tvTime;
        @BindView(R.id.btnTime)
        Button btnTime;
        @BindView(R.id.tvWay)
        TextView tvWay;

        @Override
        public void bind(Order order, OnItemClickListener clickListener) {
            super.bind(order, clickListener);
            Log.i(TAG, "bind: " + order);
            tvOrderBody.setText(order.getBody());
            tvWay.setText("Расстояние: " + order.getWay() + "км");
        }

        ActualViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
