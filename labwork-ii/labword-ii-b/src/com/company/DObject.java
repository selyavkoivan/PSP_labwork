
package com.company;

abstract public class DObject implements PriceInterface{

    protected String name;
    protected double size;
    protected double price;

    public DObject()//конструктор класса
    {
        name =new String();
        size =0;
        price =0;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double countPrice()
    {
        return this.price;
    }

    abstract protected void generateName();

    @Override
    public String toString()
    {
        String str=new String();
        str= name +" размер "+ size +"гб Цена:"+ price +"BYN";
        return str;
    }
}
