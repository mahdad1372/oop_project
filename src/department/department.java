package department;

import java.util.ArrayList;
import java.util.Scanner;

public class department {
    private int department_id;
    private String department_name;
    ArrayList<String> department_name_list = new ArrayList<>();
    ArrayList<Integer> department_id_list = new ArrayList<>();
    Scanner myInput = new Scanner(System.in);

    public void add_department() {
        int i = 1;
        this.department_id = i;
        department_id_list.add(this.department_id);
        i +=1;
        System.out.println("Please add the name of the department");
        String department = myInput.nextLine();
        this.department_name = department;
        department_name_list.add(this.department_name);
        System.out.println("So the department with the id of "+ this.department_id +
                " and with the name of "+this.department_name + " add to the department section");

    }
    public void update_department() {
        System.out.println("Please add the id of the department that you want to update");
        int department_id = myInput.nextInt();
        boolean id_contain = department_id_list.contains(department_id);
        if (id_contain){
            int index = department_id_list.indexOf(department_id);
            System.out.println("Please add the new name if the department");
            String new_department = myInput.nextLine();
            department_name_list.set(index,new_department);
            System.out.println("The department succesfuly updated");
        }else{
            System.out.println("Sorry the department id that you add is not in the list of the departments");
        }

    }
    public void delete_department() {
        System.out.println("Please add the id of the department that you want to remove");
        int department_id = myInput.nextInt();
        boolean id_contain = department_id_list.contains(department_id);
        if (id_contain){
            int index = department_id_list.indexOf(department_id);
            department_id_list.remove(index);
            department_name_list.remove(index);
            System.out.println("The department sucessfuly updated");
        }else{
            System.out.println("Sorry the department id that you add is not in the list of the departments");
        }

    }
    public void display_department() {
        if (department_id_list.size() > 0) {
            for (int i = 0; i <= department_id_list.size() - 1; i++) {
                System.out.println("So the department with the id " +department_id_list.get(i) +
                        "is " + department_name_list.get(i));
            }
        } else {
            System.out.println("Sorry there is not any department in the list of departments");
        }
        department_description();
    }
    public void department_description(){
        System.out.println("Welcome to the section of the department");
        System.out.println("Please choose the which type of the operation you want to do");
        System.out.println("1)Add department 2)Edit department 3)delete department 4)display departments");
        int option_number = myInput.nextInt();

        if (option_number == 1) {
            add_department();
        }
        if (option_number == 2) {
            update_department();
        }
        if (option_number == 3) {
            delete_department();
        }
        if (option_number == 4) {
            display_department();
        }
    }
}
