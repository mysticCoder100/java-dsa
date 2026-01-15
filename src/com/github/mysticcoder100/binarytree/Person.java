package com.github.mysticcoder100.binarytree;

public record Person(long userId, String firstName, String lastName) {
    public long getUserId(){
        return this.userId;
    }
}
