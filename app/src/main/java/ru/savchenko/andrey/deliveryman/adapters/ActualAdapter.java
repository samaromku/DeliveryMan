package ru.savchenko.andrey.deliveryman.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryman.R;
import ru.savchenko.andrey.deliveryman.base.BaseAdapter;
import ru.savchenko.andrey.deliveryman.base.BaseViewHolder;
import ru.savchenko.andrey.deliveryman.entities.Order;
import ru.savchenko.andrey.deliveryman.interfaces.OnItemClickListener;

import static ru.savchenko.andrey.deliveryman.storage.Utils.setNameValueByCardViewName;

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
        @BindView(R.id.card_view_body)View card_view_body;
        @BindView(R.id.card_view_address)View card_view_address;
        @BindView(R.id.card_view_created)View card_view_created;
        @BindView(R.id.card_view_dead_line)View card_view_dead_line;
        @BindView(R.id.card_view_way)View card_view_way;
        @BindView(R.id.card_view_status)View card_view_status;
        @BindView(R.id.card_view_comment)View card_view_comment;
//        @BindView(R.id.card_view_rating)View card_view_rating;

        @Override
        public void bind(Order order, OnItemClickListener clickListener) {
            super.bind(order, clickListener);
            setNameValueByCardViewName("Описание", order.getBody(), card_view_body);
            setNameValueByCardViewName("Адрес", order.getAddress(), card_view_address);
            setNameValueByCardViewName("Дата создания", new SimpleDateFormat("dd/mm/yyyy").format(order.getCreated()), card_view_created);
            setNameValueByCardViewName("Крайний срок", new SimpleDateFormat("dd/mm/yyyy").format(order.getDeadLine()), card_view_dead_line);
            setNameValueByCardViewName("Расстояние", String.valueOf(order.getWay()), card_view_way);
            setNameValueByCardViewName("Комментарий", String.valueOf(order.getComment()), card_view_comment);
            if(order.getStatus()==1) {
                setNameValueByCardViewName("Сатус", "У курьера", card_view_status);
            }else if(order.getStatus()==2){
                setNameValueByCardViewName("Сатус", "Доставлен", card_view_status);
            }
//            setNameValueByCardViewName("Рейтинг", String.valueOf(order.getRating()), card_view_rating);
        }

        ActualViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
