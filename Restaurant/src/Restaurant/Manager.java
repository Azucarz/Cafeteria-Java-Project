package Restaurant;

import java.util.ArrayList;

public class Manager extends User{

    public static ArrayList<Manager>  managers = new ArrayList<>();

    public Manager(String name, String password, String email, String number) {
        super(name, password, email, number);
    }

    public static void setManagers(ArrayList<Manager> managers) {Manager.managers = managers;}

    public void addCustomer(){}

    public void removeCustomer(){}

    public void search(Manager manager){}

    public void search(Customer customer){}

    public void getManagers(){}

}
