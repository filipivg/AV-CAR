package com.av_car_auto_center.respository;

import java.util.List;

public interface GenericDao<T> {

    void insert(T obj);

    void update(T obj);

    T SelectPorID(int id);

    List<T> SelectAll();
}
