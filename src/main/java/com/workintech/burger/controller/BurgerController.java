package com.workintech.burger.controller;

import com.workintech.burger.dao.BurgerDao;
import com.workintech.burger.entity.BreadType;
import com.workintech.burger.entity.Burger;
import com.workintech.burger.util.BurgerValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/burger")
public class BurgerController {
    private final BurgerDao burgerDao;


    @PostMapping
    public Burger save(@RequestBody Burger burger){
        BurgerValidation.checkName(burger.getName());
        return burgerDao.save(burger);
    }

    @GetMapping
    public List<Burger> getAll(){
        return burgerDao.findAll();
    }
    @GetMapping("/{id}")
    public Burger getEach(@PathVariable long id){
        BurgerValidation.checkId(id);
        return burgerDao.findById(id);
    }
    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable Double price){
        BurgerValidation.checkPrice(price);
        return burgerDao.findByPrice(price);
    }
    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable String breadType){
        BreadType breadType1=BreadType.valueOf(breadType);
        return burgerDao.findByBreadType(breadType1);
    }
    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable String content){
        return burgerDao.findByContent(content);
    }
    @PutMapping("/{id}")
    public Burger update(@RequestBody Burger burger,@PathVariable Long id){
        burger.setId(id);
        return burgerDao.update(burger);
    }
    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable long id){
        BurgerValidation.checkId(id);
        return burgerDao.remove(id);
    }

}
