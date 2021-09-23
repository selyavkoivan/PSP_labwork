import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


public class Main {


    public static void main(String[] args) throws IOE1on {
        mainMenu();
    }

    public static void mainMenu() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Ward ward = new Ward();
        List<Ward> list = new LinkedList<>();


        while (true) {
            System.out.println("1. Добавить палату");
            System.out.println("2. Просмотр палат");
            System.out.println("3. Выход");
            try {
                int choice = Integer.parseInt(reader.readLine());

                switch(choice) {
                    case 1:
                        ward = ward.addWard();
                        list.add(ward);
                        break;
                    case 2:
                        WriteInfo wi = new WriteInfo();
                        wi.printWardInfo(list);
                        break;
                    case 3:
                        System.exit(1);
                    default:
                        System.out.println("Некорректный ввод");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error:\n" + e.getMessage());
            }
        }
    }
}

class Ward {
    String name;
    int numberOfBeds;
    boolean availabilityOfFreeBeds ;

    public Ward() {}

    public Ward(String name, int numberOfBeds) {

        this.name = name;
        this.numberOfBeds = numberOfBeds;
    }

    public Ward(String name, int numberOfBeds, boolean availabilityOfFreeBeds) {
        this.name = name;
        this.numberOfBeds = numberOfBeds;
        this.availabilityOfFreeBeds  = availabilityOfFreeBeds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isIncludeIllustrations() {
        return availabilityOfFreeBeds ;
    }

    public void setIncludeIllustrations(boolean availabilityOfFreeBeds) {
        this.availabilityOfFreeBeds  = availabilityOfFreeBeds;
    }





    public Ward addWard() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name_tmp;
        int number_tmp;
        boolean availabilityOfFreeBeds_tmp = true;

        System.out.print("Фамилия врача: ");
        name_tmp = reader.readLine();

        while (true) {
            System.out.print("Количество мест: ");
            try {
                number_tmp = Integer.parseInt(reader.readLine());
                break;
            }
            catch(NumberFormatException e) {
                System.out.println("Error:\n" + e.getMessage());
            }
        }

        while(true) {
            System.out.println("Наличие свободных мест:\n" +
                    "1. Есть\n" +
                    "2. Нет");
            try {
                int illustrations = Integer.parseInt(reader.readLine());
                if (illustrations == 1) {
                    availabilityOfFreeBeds_tmp = true;
                    break;
                } else if (illustrations == 2) {
                    availabilityOfFreeBeds_tmp = false;
                    break;
                }
                else {
                    System.out.println("Некорректный ввод");
                }

            }
            catch (NumberFormatException e) {
                System.out.println("Error:\n" + e.getMessage());
            }
        }
        return new Ward(name_tmp, number_tmp, availabilityOfFreeBeds_tmp);
    }


    void printName()
    {
        System.out.print(getName() + "        |        ");
    }
    void printNumberOfBeds()
    {
        System.out.print(getName() + "        |        ");
    }
    void printAvailabilityOfFreeBeds()
    {
        if(availabilityOfFreeBeds ) {
            System.out.println("Да");
        }
        else System.out.println("Нет");
    }
}


class WriteInfo {

    public void printWardInfo(List<Ward> list) {

        System.out.println("Фамилия врача  /  Количество мест  /  Наличие свободных мест");
        for (Ward ward : list) {
            ward.printName();
            ward.printNumberOfBeds();
            ward.printAvailabilityOfFreeBeds();

        }
    }
}