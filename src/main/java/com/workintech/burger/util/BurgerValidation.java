package com.workintech.burger.util;

import com.workintech.burger.entity.Burger;
import com.workintech.burger.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

import java.util.List;

public class BurgerValidation {

    public static void checkBurgerExist(List<Burger> burgers,Long id){
        if(!burgers.contains(id)){
            throw new BurgerException("Burger is not found with id: "+id, HttpStatus.NOT_FOUND);
        }
    }
    public static void checkName(String name){
        if(name==null||name.isEmpty()){
            throw new BurgerException("Name cannot be null or empty.", HttpStatus.BAD_REQUEST);
        }
    }
    public static void checkPrice(Double price){
        if(price==null||price<0){
            throw new BurgerException("Price cannot be null or less than zero.",HttpStatus.BAD_REQUEST);
        }
    }
    public static void checkId(Long id){
        if(id==null||id<0){
            throw new BurgerException("id cannot be null or less than zero",HttpStatus.BAD_REQUEST);
        }
    }
}
