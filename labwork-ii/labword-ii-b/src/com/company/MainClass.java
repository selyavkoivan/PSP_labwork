package com.company;

import java.util.Scanner;

public class MainClass {


    public static void main(String[] args) {
        // TODO code application logic here
        Order order=new Order();
        GameDisk gameDisk=new GameDisk();
        MusicDisk musicDisk=new MusicDisk();
        MovieDisk movieDisk = new MovieDisk();

        gameDisk.setPrice(125.32);
        gameDisk.setSize(47.12);
        gameDisk.setGenre("action/RPG");

        musicDisk.setPrice(12.52);
        musicDisk.setSize(0.72);
        musicDisk.setGenre("Nu Metal");
        musicDisk.setLength(45);

        movieDisk.setPrice(7.12);
        movieDisk.setSize(32.12);
        movieDisk.setLength(150);
        movieDisk.setQuality("HD");

        order.addFurniture(movieDisk);
        order.addFurniture(gameDisk);
        order.addFurniture(musicDisk);


        order.printOrder();
        order.countPrice();



    }
}








