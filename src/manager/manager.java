package manager;

import department.department;
import employee.employee;

import java.util.ArrayList;
import java.util.Scanner;

public class manager {
    private int manager_id;
    private String manager_name;
    private int department_id;
    private int employee_id;

    static ArrayList<Integer> manager_id_list = new ArrayList<>();
    static ArrayList<String> manager_name_list = new ArrayList<>();
    static ArrayList<Integer> department_id_list = new ArrayList<>();
    static ArrayList<Integer> employee_id_list = new ArrayList<>();

    public void add_manager(){
        employee employee = new employee();
        department department = new department();
        System.out.println("Please add the employee id of the manager");
        Scanner add_manager_scanner = new Scanner(System.in);
        int employee_id = add_manager_scanner.nextInt();
        boolean availabiity = employee.checking_employee_id(employee_id);
        if (!availabiity){
            System.out.println("Sorry the employee id that you add is not in the list");
            this.add_manager();
        }
        this.employee_id = employee_id;
        employee_id_list.add(this.employee_id);
        System.out.println("Please add the department id that the manager devote to it");
        Scanner add_department_scanner = new Scanner(System.in);
        int department_id = add_department_scanner.nextInt();
        boolean availability_department = department.check_department_availability(department_id);
        if (!availability_department){
            System.out.println("Sorry the department id that you add is not in the list of the department");
            this.add_manager();
        }
        this.department_id = department_id;
        department_id_list.add(this.department_id);
        String manager_name = employee.employee_name(this.employee_id);
        this.manager_name = manager_name;
        manager_name_list.add(this.manager_name);
        this.manager_id = this.manager_id + 1;
        manager_id_list.add(this.manager_id);
        System.out.println("So " + this.manager_name +" has elected as the director of the " +department.find_department(this.department_id));
    }

    public void update_manger(){
        department department = new department();
        employee employee = new employee();
        System.out.println("Please add the id of the manager that you want to update");
        Scanner update_manager_scanner = new Scanner(System.in);
        int manager_id = update_manager_scanner.nextInt();
        boolean id_contain = manager_id_list.contains(manager_id);
        if (!id_contain){
            System.out.println("Sorry the id that you add is not in our list please try again");
            this.update_manger();
        }
        System.out.println("Please choose which filed you want to update for the manager");
        System.out.println("1)manager  2 )department");
        int update_field = update_manager_scanner.nextInt();
        if (update_field == 1){
            System.out.println("Please add the id employee of the new manager");
            int new_manager = update_manager_scanner.nextInt();
            boolean contain_employee = employee.checking_employee_id(new_manager);
            if (!contain_employee){
                System.out.println("Sorry this employee is not in the list please try again");
                this.update_manger();
            }
            int index = manager_id_list.indexOf(manager_id);
            manager_name_list.set(index,employee.employee_name(new_manager));

        }
        if (update_field == 2){
            System.out.println("Please add the new department id");
            Scanner add_department_scanner = new Scanner(System.in);
            int department_id = add_department_scanner.nextInt();
            boolean availability_department = department.check_department_availability(department_id);
            if (!availability_department){
                System.out.println("Sorry the department id that you add is not in the list of the department");
                this.update_manger();
            }
            int index = manager_id_list.indexOf(manager_id);
            department_id_list.set(index,department_id);
        }
    }

    public void delete_manager(){
        System.out.println("Please add the id of the manager that you want to remove");
        Scanner delete_manager_scanner = new Scanner(System.in);
        int manager_id = delete_manager_scanner.nextInt();
        boolean id_contain = manager_id_list.contains(manager_id);
        if (id_contain){
            int index = manager_id_list.indexOf(id_contain);
            department_id_list.remove(index);
            manager_id_list.remove(index);
            System.out.println("The department sucessfuly updated");
        }else{
            System.out.println("Sorry the department id that you add is not in the list of the departments");
        }


    }

}
