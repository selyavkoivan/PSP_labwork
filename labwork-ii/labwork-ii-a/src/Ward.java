package  Ward;

public class Ward {

    private String name;
    private boolean availabilityOfFreeBeds;
    private int numberOfBeds;

    public Ward() {
        this.name = "borovoi";
        availabilityOfFreeBeds = true;
        numberOfBeds = 4;
    }

    public Ward(String name, int numberOfBeds) {
        this.name = name;
        this.numberOfBeds = numberOfBeds;
        availabilityOfFreeBeds = false;
    }

    public Ward(String name, boolean availabilityOfFreeBeds, int numberOfBeds) {
        this.name = name;
        this.availabilityOfFreeBeds = availabilityOfFreeBeds;
        this.numberOfBeds = numberOfBeds;
    }

    public Ward( Ward o){
        this.name=o.name;
        this.availabilityOfFreeBeds=o.availabilityOfFreeBeds;
        this.numberOfBeds=o.numberOfBeds;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailabilityOfFreeBeds() {
        return availabilityOfFreeBeds;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void print()
    {
        System.out.println("\n\nФамилия врача : " + name);
        System.out.println("Количество мест : " + numberOfBeds);
        if(availabilityOfFreeBeds) System.out.println("Места есть");
        else System.out.println("Мест нет");

    }

    public static int NumberOfBeds(Ward []ward){
        int p=0;
        for(Ward w : ward) {
            p += w.numberOfBeds;
        }
        return p;

        }
        public static int NumberOfWards(Ward []ward){
            int lic=0;
            for(Ward w : ward) {
                if (w.availabilityOfFreeBeds == true) lic++;
            }
            return lic;
        }
}