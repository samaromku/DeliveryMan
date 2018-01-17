package ru.savchenko.andrey.deliveryman.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.savchenko.andrey.deliveryman.activities.draw.DeliveryDrawerActivity;
import ru.savchenko.andrey.deliveryman.activities.draw.di.MainComponent;
import ru.savchenko.andrey.deliveryman.activities.neworder.NewOrderActivity;
import ru.savchenko.andrey.deliveryman.activities.neworder.di.NewOrderComponent;
import ru.savchenko.andrey.deliveryman.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryman.activities.oneorder.OneOrderActivity;
import ru.savchenko.andrey.deliveryman.activities.oneorder.di.OneOrderComponent;
import ru.savchenko.andrey.deliveryman.fragments.actual.ActualFragment;
import ru.savchenko.andrey.deliveryman.fragments.actual.di.ActualComponent;
import ru.savchenko.andrey.deliveryman.fragments.contacts.ContactFragment;
import ru.savchenko.andrey.deliveryman.fragments.contacts.di.ContactComponent;
import ru.savchenko.andrey.deliveryman.fragments.curiers.CuriersFragment;
import ru.savchenko.andrey.deliveryman.fragments.curiers.di.CuriersComponent;
import ru.savchenko.andrey.deliveryman.fragments.delivered.DeliveredFragment;
import ru.savchenko.andrey.deliveryman.fragments.delivered.di.DeliveredComponent;
import ru.savchenko.andrey.deliveryman.fragments.profile.ProfileUserFragment;
import ru.savchenko.andrey.deliveryman.fragments.profile.di.ProfileUserComponent;
import ru.savchenko.andrey.deliveryman.network.DeliveryNetworkService;

/**
 * Created by Andrey on 06.10.2017.
 */
@Module(subcomponents = {
    MainComponent.class,
    ActualComponent.class,
    NewOrderComponent.class,
    OneOrderComponent.class,
    DeliveredComponent.class,
    CuriersComponent.class,
    ProfileUserComponent.class,
    ContactComponent.class,
})
class AppModule {
    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String EMULATOR_IP = "http://10.0.2.2:8999";

    @Provides
    @IntoMap
    @ClassKey(DeliveryDrawerActivity.class)
    ComponentBuilder provideMain(MainComponent.Builder builder){
        return builder;
    }

    @Provides
    @IntoMap
    @ClassKey(ContactFragment.class)
    ComponentBuilder provideContact(ContactComponent.Builder builder){
        return builder;
    }

    @Provides
    @IntoMap
    @ClassKey(CuriersFragment.class)
    ComponentBuilder provideCourier(CuriersComponent.Builder builder){
        return builder;
    }

    @Provides
    @IntoMap
    @ClassKey(ProfileUserFragment.class)
    ComponentBuilder provideProfile(ProfileUserComponent.Builder builder){
        return builder;
    }

    @Provides
    @IntoMap
    @ClassKey(DeliveredFragment.class)
    ComponentBuilder provideDelivered(DeliveredComponent.Builder builder){
        return builder;
    }

    @Provides
    @IntoMap
    @ClassKey(OneOrderActivity.class)
    ComponentBuilder provideOneOrder(OneOrderComponent.Builder builder){
        return builder;
    }

    @Provides
    @IntoMap
    @ClassKey(ActualFragment.class)
    ComponentBuilder provideActual(ActualComponent.Builder builder){
        return builder;
    }

    @Provides
    @IntoMap
    @ClassKey(NewOrderActivity.class)
    ComponentBuilder provideNewOrder(NewOrderComponent.Builder builder){
        return builder;
    }

    @Singleton
    @Provides
    DeliveryNetworkService deliveryNetworkService(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(chain -> {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("Content-Type", "application/json")
                            .build();
                    return chain.proceed(request);
                })
                .build();

        Gson gson = new GsonBuilder()
                .setDateFormat(DATE_PATTERN)
                .create();
        return new Retrofit.Builder()
                .baseUrl(EMULATOR_IP)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(DeliveryNetworkService.class);
    }
}
