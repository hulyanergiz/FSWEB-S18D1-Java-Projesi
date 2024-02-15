package com.workintech.burger.dao;

import com.workintech.burger.entity.BreadType;
import com.workintech.burger.entity.Burger;
import com.workintech.burger.exceptions.BurgerException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class BurgerDaoImpl implements BurgerDao{

    private final   EntityManager entityManager;

    @Transactional
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public Burger findById(long id) {
        Burger burger=entityManager.find(Burger.class,id);
        return burger;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> allFounds= entityManager.createQuery("SELECT b FROM Burger b", Burger.class);
        return allFounds.getResultList();
    }

    @Override
    public List<Burger> findByPrice(Double price) {
        TypedQuery<Burger> foundListByPrice=entityManager.createQuery("SELECT b FROM Burger b WHERE b.price>:price ORDER BY b.price DESC",Burger.class);
        foundListByPrice.setParameter("price",price);
        return foundListByPrice.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> foundListByBreadType=entityManager.createQuery("SELECT b FROM Burger b WHERE b.breadType=:breadType ORDER BY b.name", Burger.class);
        foundListByBreadType.setParameter("breadType",breadType);
        return foundListByBreadType.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> foundListByContent=entityManager.createQuery("SELECT b FROM Burger b WHERE b.contents LIKE CONCAT('%',:content,'%')",Burger.class);
        foundListByContent.setParameter("content",content);
        return foundListByContent.getResultList();
    }

    @Transactional
    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger);
    }

    @Transactional
    @Override
    public Burger remove(long id) {
        Burger removedBurger=findById(id);
        entityManager.remove(removedBurger);
        return removedBurger;
    }
}
