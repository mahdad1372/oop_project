package attendance;

import employee.employee;
import menu.menu;

import java.util.ArrayList;
import java.util.Scanner;

public class attendance {
    private int attendance_id;
    private int employee_id;
    private String date;
    private String enter_time;
    static ArrayList<Integer> attendance_id_list = new ArrayList<>();
    static ArrayList<Integer> employee_id_list = new ArrayList<>();
    static ArrayList<String> date_list = new ArrayList<>();
    static ArrayList<String> enter_time_list = new ArrayList<>();
   menu menu = new menu();


    public void add_attendance() {
        employee employee = new employee();
        Scanner add_attendance_input = new Scanner(System.in);
        int employee_id = add_attendance_input.nextInt();
        if(!employee.availability_employee()){
            System.out.println("Sorry there is not any employee, please add some employees");
            menu.menu_description();
        }
        if(!employee.checking_employee_id(employee_id)){
            System.out.println("Sorry there is not a employee with this id number in the list please try again");
            add_attendance();
        }

        this.attendance_id = this.attendance_id + 1;
        attendance_id_list.add(this.attendance_id);
        this.employee_id = employee_id;
        employee_id_list.add(this.employee_id);
        System.out.println("Please add the date");
        String date_input = add_attendance_input.nextLine();
        this.date = date_input;
        date_list.add(this.date);
        System.out.println("please add the enterance time");
        String enter_time = add_attendance_input.nextLine();
        this.enter_time = enter_time;
        enter_time_list.add(this.enter_time);
        System.out.println("entrance time successfully recorded");
        additional_operation();
    }
    public void display_entrance_time() {
        if(attendance_id_list.size() == 0){
            System.out.println("Sorry there is not any attendance time in the list");
        }
        additional_operation();
    }
    public void attendence_description(){
        System.out.println("Welcome to the attendance section");
        System.out.println("Please choose which type of the operation you want to do");
        System.out.println("1)Add entrance time   2)display entrance time");
        Scanner add_option_input = new Scanner(System.in);
        int option_number = add_option_input.nextInt();

        if (option_number == 1) {
            add_attendance();
        }
        if (option_number == 2) {
            display_entrance_time();
        }
    }
    public void additional_operation() {
        menu menu = new menu();
        System.out.println(
                "Do you want to do more operation");
        Scanner myInput1 = new Scanner(System.in);
        String condition = myInput1.nextLine();
        if (condition.equals("yes") || condition.equals("Yes")) {
            attendence_description();
        }else {
            menu.menu_description();
        }
    }
}
