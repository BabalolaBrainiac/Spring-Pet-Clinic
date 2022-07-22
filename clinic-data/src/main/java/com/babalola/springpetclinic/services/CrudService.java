package com.babalola.springpetclinic.services;

import java.util.Set;

//CRUD service is a base service that other services extends from
public interface CrudService<T, ID> {
    //Where T is TYPE of object, and ID represents the ID of object

    T findById(ID id);
    T save(T object);
    Set<T>findAll();
    void delete(T object);
    void deleteById(ID id);


}
