
package com.company;
import java.util.*;

public class Order implements PriceInterface {

    private List<DObject> objects;
    private static int orderNum = 0;

    public Order() {
        objects = new ArrayList<DObject>();
        orderNum = orderNum + 1;
    }

    public void addFurniture(DObject obj) {
        objects.add(obj);
    }

    public void printOrder() {
        int i = 1;
        Iterator it = objects.iterator();
        System.out.println("=================================================");
        while (it.hasNext()) {
            System.out.println(i + ")" + (it.next()).toString());
            i = i + 1;
        }
        System.out.println();
        System.out.println("Цена заказа:" + this.countPrice() + "BYN");
        System.out.println("=================================================");
    }


    @Override
    protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable ex) {
            System.err.println("Ошибка при удалении объекта");
        }
        orderNum = orderNum - 1;
    }

    @Override
    public double countPrice() {
        double tempPrice = 0;
        Iterator it = objects.iterator();
        DObject obj;
        while (it.hasNext()) {
            obj = (DObject) it.next();
            tempPrice = tempPrice + obj.getPrice();
        }
        return tempPrice;
    }
}