package ru.savchenko.andrey.deliveryman;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

import ru.savchenko.andrey.deliveryman.di.ComponentManager;

/**
 * Created by Andrey on 25.09.2017.
 */

public class App extends Application {
    private static ComponentManager componentManager;

    public static ComponentManager getComponentManager() {
        return componentManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        componentManager = new ComponentManager();
        componentManager.init();
        JodaTimeAndroid.init(this);
    }
}
