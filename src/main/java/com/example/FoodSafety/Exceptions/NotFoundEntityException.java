package com.example.FoodSafety.Exceptions;

public class NotFoundEntityException extends RuntimeException{

    public NotFoundEntityException(Long id){
        super("Could not find entity with id: " + id);
    }

}
