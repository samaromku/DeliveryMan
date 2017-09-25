package ru.savchenko.andrey.deliveryman.di;

/**
 * Created by Andrey on 25.09.2017.
 */

public class ComponentManager {
    private static ActualComponent actualComponent;

    public static ActualComponent getActualComponent() {
        return actualComponent;
    }

    public static void init(){
        actualComponent = DaggerActualComponent
                .builder()
                .build();
    }
}
