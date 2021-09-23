
import Ward.*;
public class Main {
    public static void main(String[] args) {
        Ward []ward = new Ward[4];
        ward[0] = new Ward("Kolenko", false, 4);

        ward[1]=new Ward("Petrov",3);
        ward[2]=new Ward();
        ward[3]=new Ward(ward[0]);

        for(Ward w : ward) w.print();

        System.out.println("\n\nКоличество мест : " + Ward.NumberOfBeds(ward));
        System.out.println("Количество палат со свободными местами : " + Ward.NumberOfWards(ward));
    } }
