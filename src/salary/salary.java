package salary;
import menu.menu;

import java.util.ArrayList;
import java.util.Scanner;
public class salary {

    private int salary_id;
    private int salary_daily;
    private int working_days;
    private int total_salary;
    private int employee_id;
    ArrayList<Integer> Idnumbers_employee = new ArrayList<>();
    ArrayList<Integer> Idnumbers_employee_frk = new ArrayList<>();
    ArrayList<Integer> salary_id_List = new ArrayList<>();
    ArrayList<Integer> total_salary_List = new ArrayList<>();
    Scanner myInput = new Scanner(System.in);

    public void exportArray(ArrayList<Integer> array) {
        int size = array.size();
        if (size > 0) {
            for (Integer element : array) {
                Idnumbers_employee.add(element);

            }
        }

    }
    public void add_salary() {
        System.out.println("Please add the employee id that you want to set salary for him");
        int employee_id = myInput.nextInt();
        boolean containsElement = Idnumbers_employee.contains(employee_id);
        if (containsElement) {
            this.employee_id = employee_id;
            Idnumbers_employee_frk.add(this.employee_id);
        } else {
            System.out.println("Sorry this employee with this id number is not in the list");
        }
        int i =1;
        this.salary_id = i;
        salary_id_List.add(this.salary_id);
        i +=1;
        System.out.println("Please add the amount of the salary for each day of working");
        int salary_perday = myInput.nextInt();
        this.salary_daily = salary_perday;
        System.out.println("Please add the number of days that the employee has worked in the company");
        int days = myInput.nextInt();
        this.working_days = days;
        System.out.println("Please add the number of days that the employee has worked in the company");
        this.total_salary = this.working_days * this.salary_daily;
        total_salary_List.add(this.total_salary);
    }
    public void update_salary() {
        Scanner myInput = new Scanner(System.in);
        System.out.println("please add the salary id you want to update");
        int id_number = myInput.nextInt();
        System.out.println("so please add the new amount of the salary");
        int new_salary = myInput.nextInt();
        int index = salary_id_List.indexOf(id_number);
        total_salary_List.set(index, new_salary);
        System.out.println("so the amount of the salary for the employee with the id of "+ Idnumbers_employee_frk.get(index) + " is this" +
                " " + total_salary_List.get(index));
    }
    public void delete_salary() {
        System.out.println("Please add the salary id that you want to remove");
        int salary_id = myInput.nextInt();
        int index = salary_id_List.indexOf(salary_id);
        salary_id_List.remove(index);
        Idnumbers_employee_frk.remove(index);
        total_salary_List.remove(index);
        System.out.println("Now the load with the id number " + salary_id +
                "completely remove");
    }
    public void display_salary() {
        if (salary_id_List.size() > 0) {
            for (int i = 0; i <= salary_id_List.size() - 1; i++) {
                System.out.println("So the employee with the id " +Idnumbers_employee_frk.get(i) +
                        "has the salary equal to " + salary_id_List.get(i));
            }
        } else {
            System.out.println("Sorry there is not any salary in the list of salaries");
        }
        salary_introduce_section();
    }
    public void salary_introduce_section() {
        menu menu = new menu();
        if (Idnumbers_employee.size() > 0) {
            System.out.println("Welcome to the salary section which type of the operation you want to do");
            System.out.println("1)add salary 2)update salary 3)delete salary 4)get all salaries for all of the employees");
            System.out.println("Please add the number of option that you want");
            int option_number = myInput.nextInt();
            if (option_number == 1) {
                add_salary();
            }
            if (option_number == 2) {
                update_salary();
            }
            if (option_number == 3) {
                delete_salary();
            }
            if (option_number == 4) {
                display_salary();
            }
        } else {
            System.out.println(
                    "Sorry for enter to the salary section first you need to add employees without employee it's impossible to enter to this secton");
            menu.menu_description();
        }

    }
}
