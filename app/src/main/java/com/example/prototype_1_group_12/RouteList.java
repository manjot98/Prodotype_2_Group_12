package com.example.prototype_1_group_12;

import java.util.ArrayList;

public class RouteList {

    public static ArrayList<Route> routeArrayList = new ArrayList<>();

    public static void addRoute(Route r){

        routeArrayList.add(r);

    }

    public static void removeRoute(Route r){

        routeArrayList.remove(r);
    }

    public static void searchRoute(String routeName){


    }
}
