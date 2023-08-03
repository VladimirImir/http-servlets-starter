package com.dev.http.mapper;

public interface Mapper<F, T> {

    T mapFrom(F object);
}
