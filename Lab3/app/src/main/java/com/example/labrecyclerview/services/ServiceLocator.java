package com.example.labrecyclerview.services;

import com.example.labrecyclerview.repositories.TrabajadorRespository;

public class ServiceLocator {
    private static ServiceLocator instance = null;
    private static TrabajadorRespository mainRepositoryinstance = null;

    private ServiceLocator() {}

    public static ServiceLocator getInstance() {
        if (instance == null) {
            synchronized(ServiceLocator.class) {
                instance = new ServiceLocator();
            }
        }
        return instance;
    }

    public TrabajadorRespository getDBSource() {
        if (mainRepositoryinstance == null) {
            synchronized(ServiceLocator.class) {
                mainRepositoryinstance = new TrabajadorRespository();
            }
        }
        return mainRepositoryinstance;
    }
}

