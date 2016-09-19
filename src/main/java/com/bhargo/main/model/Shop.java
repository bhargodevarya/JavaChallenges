package com.bhargo.main.model;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Created by barya on 8/18/16.
 */
public class Shop {
    private item shirt;
    private item pant;
    private item shoe;

    private enum item {
        SHIRT(0),PANT(0),SHOE(0);
        private int cost;
        item(int cost) {

        }
        public void set(int cost) {
            this.cost = cost;
        }

        public int get() {
            return cost;
        }
    }

    @Override
    public String toString() {
        return shirt + " " + pant + " " + shoe;
    }

    public Shop(int shirt, int pant, int shoe) {
        this.shirt = item.SHIRT;
        this.shirt.set(shirt);
        this.pant = item.PANT;
        this.pant.set(pant);
        this.shoe = item.SHOE;
        this.shoe.set(shoe);
    }

    public item getShirt() {
        return shirt;
    }

    public item getPant() {
        return pant;
    }

    public item getShoe() {
        return shoe;
    }

    public int getLeast() {
        List<Integer> list = new ArrayList<>();
        list.add(shirt.get());list.add(pant.get());list.add(shoe.get());
        Collections.sort(list);
        return list.get(0);
    }
}
