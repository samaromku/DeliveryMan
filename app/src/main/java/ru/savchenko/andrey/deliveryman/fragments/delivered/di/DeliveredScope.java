package ru.savchenko.andrey.deliveryman.fragments.delivered.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
@interface DeliveredScope {
}
