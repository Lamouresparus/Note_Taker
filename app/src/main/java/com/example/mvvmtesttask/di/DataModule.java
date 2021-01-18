package com.example.mvvmtesttask.di;

import com.example.mvvmtesttask.domain.repository.NoteRepository;
import com.example.mvvmtesttask.local.LocalSourceImpl;
import com.example.mvvmtesttask.model.repositories.NoteRepositoryImpl;
import com.example.mvvmtesttask.model.sources.LocalSource;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public abstract class DataModule {



    @Binds
    public abstract NoteRepository bindNoteRepository(NoteRepositoryImpl noteRepository);

    @Binds
    public abstract LocalSource bindLocalSource(LocalSourceImpl localSource);
}
