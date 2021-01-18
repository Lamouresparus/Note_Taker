package com.example.mvvmtesttask.di;

import com.example.mvvmtesttask.domain.repository.NoteRepository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;


@Module
@InstallIn(ApplicationComponent.class)
public class AppModule {
    @Singleton
    @Provides
    public static ExecutorService provideExecutor(){
        return Executors.newFixedThreadPool(3);
    }
}
