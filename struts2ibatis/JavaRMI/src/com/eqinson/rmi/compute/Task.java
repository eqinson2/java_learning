package com.eqinson.rmi.compute;

public interface Task<T> {
    T execute();
}