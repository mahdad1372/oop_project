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

    class introduction{
        public void section_introduction() {
            System.out.println("This is about the introduction of each section");
        }
    }

    class role_introduction extends introduction{
        public void section_introduction() {
            System.out.println("Welcome to the role section, the aim of this section is to set role for each employee");
        }
    }
    public void add_role(){
        department department = new department();
        System.out.println("Please add the Id number of the employee");

        Scanner myInput = new Scanner(System.in);
        Scanner myInput_role = new Scanner(System.in);
        int employee_id = myInput.nextInt();
        boolean contain_employee = employee.checking_employee_id(employee_id);
        boolean contain_employee_frk = this.employee_id_list.contains(employee_id);
        if (!contain_employee){
            System.out.println("Sorry there is not the employee with this id in the list of the employees");
            this.add_role();
        }else{
            if (contain_employee_frk){
                System.out.println("Sorry for this employee already has set the role so try another employee");
                this.add_role();
            }else {
                this.employee_frk = employee_id;
                employee_id_list.add(this.employee_frk);
            }
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
        additional_operation();
    }
    public void update_role() {
        department department = new department();
        Scanner update_role = new Scanner(System.in);
        Scanner update_role_int = new Scanner(System.in);
        System.out.println("please add the role id and then tell us which element you want to edit ");
        int id_number = update_role.nextInt();
        System.out.println("1)role type 2)department 3)employee");
        System.out.println("Please add the number");
        int option_number = update_role_int.nextInt();

        if (option_number == 1) {
            System.out.println("Please enter new role type");
            Scanner role_type_scanner = new Scanner(System.in);
            String role_type = role_type_scanner.nextLine();
            int index = role_id_list.indexOf(id_number);
             role_name_list.set(index,role_type);
        }
        if (option_number == 2) {
            System.out.println("Please enter new department id that you want to change for the role");
            int new_department = update_role.nextInt();
            boolean contain_department = department.check_department_availability(new_department);
            if (!contain_department){
                System.out.println("Sorry there is not any department with this id in list of department so please try again");
                this.update_role();
            }else {
                int index = role_id_list.indexOf(id_number);
                department_id_list.set(index,new_department);
            }

        }
        if (option_number == 3) {
            System.out.println("Please enter new employee id");
            Integer employee_id = update_role.nextInt();
            boolean contain_employee = employee.checking_employee_id(employee_id);

            if (!contain_employee){
                System.out.println("Sorry there is not the employee with this id in the list please try again");
                this.update_role();
            }else{
                int index = role_id_list.indexOf(id_number);
                employee_id_list.set(index,employee_id);
            }

        }
        System.out.println("So the role " + role_name_list.get(role_id_list.indexOf(id_number)) + "from the department of" +
                department.find_department(employee_id_list.get(role_id_list.indexOf(id_number))) +
                " for the " + employee.employee_name(employee_id_list.get(role_id_list.indexOf(id_number)))+ "updated succesfully");
       additional_operation();
    }
    public void additional_operation() {
        menu menu = new menu();
        System.out.println(
                "Do you want to do more operation");
        Scanner myInput1 = new Scanner(System.in);
        String condition = myInput1.nextLine();
        if (condition.equals("yes") || condition.equals("Yes")) {
            role_introduce_section();
        }else {
            menu.menu_description();
        }
    }

    public void display_roles(){
        if (role_id_list.size() > 0) {
            for (int i = 0; i <= role_id_list.size() - 1; i++) {
                System.out.println("So the role " + role_name_list.get(i) + " is devoted to the "
                + employee.employee_name(employee_id_list.get(i)));
            }
        } else {
            System.out.println("Sorry there is not any role in the list of rols");
        }
        additional_operation();
    }
    public void delete_roles() {
        if(role_id_list.size() == 0){
            System.out.println("Sorry there is not any role in the list");
            role_introduce_section();
        }
        System.out.println("Please add the role id that you want to remove");
        Scanner delete_role = new Scanner(System.in);
        int idnumber_role = delete_role.nextInt();
        boolean contain_role = role_id_list.contains(idnumber_role);

        if (contain_role){
            int index = role_id_list.indexOf(idnumber_role);
            role_id_list.remove(index);
            employee_id_list.remove(index);
            department_id_list.remove(index);
            role_name_list.remove(index);
            System.out.println("Now the load with the id number " + idnumber_role +
                    "completely remove");
        }else {
            System.out.println("Sorry the role with this id is not in the list");
        }

        additional_operation();
    }
    public void role_introduce_section() {
        role_introduction role_intro = new role_introduction();
        boolean contain_employee = employee.availability_employee();
        menu menu = new menu();
        if (contain_employee) {
            role_intro.section_introduction();
            System.out.println("Please choose which type of the operation you want to do");
            System.out.println(
                    "1)add role 2)update role 3)delete role 4)get all loans types of loans");
            System.out.println("Please add the number of option");
            Scanner myInput = new Scanner(System.in);
            int option_number = myInput.nextInt();

            if (option_number == 1) {
                add_role();
            }
            if(option_number == 2){
                update_role();
            }
            if(option_number == 3){
                delete_roles();
            }
            if(option_number == 4){
                display_roles();
            }

        } else {
            System.out.println(
                    "Sorry for enter to the role section first you need to add emplyees without employee it's impossible to enter to this secton");
            menu.menu_description();
        }

    }
    }

