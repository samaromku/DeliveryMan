package ru.savchenko.andrey.deliveryman.base;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.arellomobile.mvp.MvpAppCompatFragment;

import ru.savchenko.andrey.deliveryman.interfaces.OnChangeTitle;

/**
 * Created by Andrey on 25.09.2017.
 */

public class BaseFragment extends MvpAppCompatFragment{
    protected OnChangeTitle onChangeTitle;

    public void setOnChangeTitle(OnChangeTitle onChangeTitle) {
        this.onChangeTitle = onChangeTitle;
    }

    protected void setToolbarTitle(String title){
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if(actionBar!=null){
            actionBar.setTitle(title);
        }
    }
}
