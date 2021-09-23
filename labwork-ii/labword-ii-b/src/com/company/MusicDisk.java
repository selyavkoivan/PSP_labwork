
package com.company;

public class MusicDisk extends DObject {
    private int length;
    private String genre;
    private static int mNum =0;
    private int mId;
    public MusicDisk()
    {
        super();
        genre = new String();
        length=0;
        generateName();
        mNum = mNum +1;
        mId = mNum;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLength(int length)
    {
        this.length=length;
    }

    @Override
    protected void generateName()
    {
        name ="Linkin Park : Hybrid Theory";
    }

    @Override
    public String toString()
    {
        String str=new String();
        str=super.toString()+"Длина альбома : "+length+" минут";
        return str;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof MusicDisk)
        {
            MusicDisk temp=(MusicDisk)obj;
            return this.size ==temp.size &&
                    this.name.equals(temp.name) &&
                    this.price ==temp.price &&
                    this.mId ==temp.mId;
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.length;
        hash = 79 * hash + this.mId;
        return hash;
    }

}
