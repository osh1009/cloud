package com.knife.example.business.order.core.business.order.controller;

public class test {



    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.knife.example.business.order.core.business.order.controller.User");
        String name = aClass.getName();

        System.out.println(aClass.hashCode());
        System.out.println("name"+name);

        User user = new User();
        System.out.println(user.getClass().hashCode());

        Class<User> userClass = User.class;
        System.out.println(userClass.hashCode());


    }




}

