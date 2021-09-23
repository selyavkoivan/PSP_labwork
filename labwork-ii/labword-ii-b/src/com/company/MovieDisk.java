package com.company;

public class MovieDisk extends DObject {
    protected int length;
    protected String quality;
    public MovieDisk()
    {
        super();
        length = 0;
        generateName();
    }
    public void setLength(int length)
    {
        this.length =length;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    protected void generateName() {
        name ="Начало";
    }

    @Override
    public String toString()
    {
        String str=new String();
        str=super.toString()+" Длина фильма: "+ length + " минут";
        return str;
    }

}



