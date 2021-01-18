package com.example.mvvmtesttask.domain.useCase.base;

public interface BaseUseCase<T,S> {
    T execute(S s);
}
