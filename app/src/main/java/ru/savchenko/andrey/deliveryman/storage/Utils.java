package ru.savchenko.andrey.deliveryman.storage;

import android.app.Service;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
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

    public static void hideKeyboard(Context context, EditText editText){
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Service.INPUT_METHOD_SERVICE);
        if(imm!=null)
            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public static void showKeyboard(Context context, EditText editText){
        editText.requestFocus();
        InputMethodManager keyboard = (InputMethodManager)
                context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(keyboard!=null) {
            keyboard.showSoftInput(editText, 0);
        }
    }
}
