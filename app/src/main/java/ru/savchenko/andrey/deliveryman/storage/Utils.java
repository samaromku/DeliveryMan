package ru.savchenko.andrey.deliveryman.storage;

import android.view.View;
import android.widget.TextView;

import ru.savchenko.andrey.deliveryman.R;

/**
 * Created by savchenko on 15.01.18.
 */

public class Utils {
    public static void setNameValueByCardViewName(String name, String value, View cardView){
        TextView tvName = cardView.findViewById(R.id.tvName);
        TextView tvValue = cardView.findViewById(R.id.tvValue);
        tvName.setText(name);
        tvValue.setText(value);
    }
}
