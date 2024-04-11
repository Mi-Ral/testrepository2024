package ru.shop.exceptions;

public class BadOrderCountException extends Exception{
    public BadOrderCountException(String message){
        super(message);
    }
}
