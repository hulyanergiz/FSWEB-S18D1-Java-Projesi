package com.workintech.burger.dao;

import com.workintech.burger.entity.BreadType;
import com.workintech.burger.entity.Burger;

import java.util.List;

public interface BurgerDao {

    Burger save(Burger burger);

    Burger findById(long id);

    List<Burger> findAll();

    List<Burger> findByPrice(Double price);

    List<Burger> findByBreadType(BreadType breadType);

    List<Burger> findByContent(String content);

    Burger update(Burger burger);

    Burger remove(long id);

}
