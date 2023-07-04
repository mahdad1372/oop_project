package role;

import department.department;
import employee.employee;
import menu.menu;

import java.util.ArrayList;
import java.util.Scanner;

public class role {
    private int role_id;
    private int department;
    private String role;
    private int employee_frk;
    static ArrayList<String> role_name_list = new ArrayList<>();
    static ArrayList<Integer> department_id_list = new ArrayList<>();
    static ArrayList<Integer> role_id_list = new ArrayList<>();
    static ArrayList<Integer> employee_id_list = new ArrayList<>();
    employee employee = new employee();

    public void add_role(){
        department department = new department();
        System.out.println("Please add the Id number of the employee");
        Scanner myInput = new Scanner(System.in);
        Scanner myInput_role = new Scanner(System.in);
        int employee_id = myInput.nextInt();
        boolean contain_employee = employee.checking_employee_id(employee_id);

        if (!contain_employee){
            System.out.println("Sorry there is not the employee with this id in the list");
            this.add_role();
        }else{
            this.employee_frk = employee_id;
            employee_id_list.add(this.employee_frk);
        }
        this.role_id = this.role_id +1;
        role_id_list.add(this.role_id);
        System.out.println("Please add the Id number of the department that is devoted to the role");
        int department_id = myInput.nextInt();
        boolean contain_department = department.check_department_availability(department_id);
        if (!contain_department){
            System.out.println("Sorry there is not any department with this id in list of department so please try again");
            this.add_role();
        }else {
            this.department = department_id;
            department_id_list.add(this.department);
        }
        System.out.println("Please add the role of the employee");
        String role = myInput_role.nextLine();
        this.role =role;
        role_name_list.add(this.role);
        System.out.println("So the "+ this.role + "With the id of "+
                this.role_id+
                " for the " + employee.employee_name(this.employee_frk) +
                " form the department of" +department.find_department(this.department) + " set");
    }
    public void role_introduce_section() {
        boolean contain_employee = employee.availability_employee();
        menu menu = new menu();
        if (contain_employee) {
            System.out.println("Welcome to the loan setion which type of the operation you want to do");
            System.out.println(
                    "1)add role 2)update role 3)delete role 4)get all loans types of loans");
            System.out.println("Please add the number of option");
            Scanner myInput = new Scanner(System.in);
            int option_number = myInput.nextInt();

            if (option_number == 1) {
                add_role();
            }

        } else {
            System.out.println(
                    "Sorry for enter to the role section first you need to add emplyees without employee it's impossible to enter to this secton");
            menu.menu_description();
        }

    }
    }

