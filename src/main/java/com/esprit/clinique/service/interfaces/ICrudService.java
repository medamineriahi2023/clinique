package com.esprit.clinique.service.interfaces;

import java.util.List;

public interface ICrudService<T> {
    T save(T entity);
    List<T> getALl();
    T update(T entity);
    void delete(Long id);
}
