package com.company;

public class GameDisk extends DObject {

    private String genre;
    private static int gNum =0;
    private int gId;
    public GameDisk()
    {
        super();
        size =0;
        genre = new String();
        generateName();
        gNum = gNum +1;
        gId = gNum;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    protected void generateName()
    {
        name ="The Witcher 3: Wild Hunt";
    }
    @Override
    public String toString()
    {
        String str=new String();
        str=super.toString()+" размер : "+ size +"гб";
        return str;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof GameDisk)
        {
            GameDisk temp=(GameDisk)obj;
            return this.gId ==temp.gId &&
                    this.name.equals(temp.name) &&
                    this.price ==temp.price &&
                    this.size ==temp.size;

        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int)this.size;
        hash = 47 * hash + this.gId;
        return hash;
    }

}
