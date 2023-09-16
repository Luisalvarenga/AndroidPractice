package com.example.lab02.services;

import com.example.lab02.repositories.PersonRepository;

public class ServiceLocator {
    private static ServiceLocator instance = null;
    private static PersonRepository PersonRepositoryinstance = null;

    private ServiceLocator() {}

    public static ServiceLocator getInstance() {
        if (instance == null) {
            synchronized(ServiceLocator.class) {
                instance = new ServiceLocator();
            }
        }
        return instance;
    }

    public PersonRepository getDBSource() {
        if (PersonRepositoryinstance == null) {
            synchronized(ServiceLocator.class) {
                PersonRepositoryinstance = new PersonRepository();
            }
        }
        return PersonRepositoryinstance;
    }
}
