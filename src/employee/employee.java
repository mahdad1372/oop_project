package employee;

import loan.loan;
import menu.menu;
import salary.salary;
import abstraction.employee_info;
import java.util.ArrayList;
import java.util.Scanner;

public class employee {
    static ArrayList<Integer> Idnumbers = new ArrayList<>();
    static ArrayList<String> firstname_List = new ArrayList<>();
    static ArrayList<String> lastname_List = new ArrayList<>();
    static ArrayList<String> birthday_List = new ArrayList<>();
    static ArrayList<String> identification_number_List = new ArrayList<>();

    private int employee_idnumber;
    private String firstname;
    private String lastname;
    private  String employee_name;
    private String birthday;
    private String identification_number;
     loan loan = new loan();



    public void addemployee(String firstname, int employee_idnumber, String lastname, String birthday,
                            String identification_number) {
        this.firstname = firstname;
        this.employee_idnumber = employee_idnumber;
        this.lastname = lastname;
        this.birthday = birthday;
        this.identification_number = identification_number;
    }

    public void setting_info() {
        boolean loop = true;

        while (loop) {
           System.out.println("Please enter the fisrtname of the employee");

            Scanner myInput = new Scanner(System.in);
            Scanner myInput2 = new Scanner(System.in);
            String name = myInput.nextLine();
            firstname_List.add(name);
            System.out.println("Please enter the lastname of the employee");
            String last_name = myInput.nextLine();
            lastname_List.add(last_name);
            this.employee_idnumber = this.employee_idnumber +1;
            Idnumbers.add(this.employee_idnumber);
            System.out.println("Please enter the birthday of the employee");
            String birthday = myInput2.nextLine();
            birthday_List.add(birthday);
            System.out.println("Please enter the identification number of the employee");
            String identification_number = myInput.nextLine();
            identification_number_List.add(identification_number);
            addemployee(firstname, employee_idnumber, lastname, birthday, identification_number);
            System.out.println("Do you want to add more employee?");
            String conditionforcontinue = myInput.next();

            if (conditionforcontinue.equals("No") ||
                    conditionforcontinue.equals("NO") ||
                    conditionforcontinue.equals("no")) {
                break;

            }
        }
        additional_operation();

    }

    public void display_employees() {
        employee_info employee_info = new employee_info();

        System.out.println("welcome to display employees section ");
        if (Idnumbers.size() > 0) {
            for (int i = 0; i <= Idnumbers.size() - 1; i++) {
                employee_info.display_info(firstname_List.get(i),lastname_List.get(i),Idnumbers.get(i),
                        identification_number_List.get(i));
            }
        } else {
            System.out.println("Sorry there is not any employee in the list of employees");
        }
        additional_operation();
    }

    public void delete_employee() {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Please enter the id number of the employee that you want to delete");
        int idnumber = myInput.nextInt();
        int index = Idnumbers.indexOf(idnumber);
        firstname_List.remove(firstname_List.get(index));
        lastname_List.remove(lastname_List.get(index));
        identification_number_List.remove(identification_number_List.get(index));
        birthday_List.remove(birthday_List.get(index));
        Idnumbers.remove(Idnumbers.get(index));
        additional_operation();

    }

    public void update_list_int(ArrayList<Integer> arr, int id, int new_num) {

        int index = Idnumbers.indexOf(id);
        arr.set(index, new_num);

    }

    public void update_list_string(ArrayList<String> arr, String charecter, String new_charecter) {
        int index = arr.indexOf(charecter);
        arr.set(index, new_charecter);
    }

    public void update_employee() {

        System.out.println("Which element you want to update please tell me");
        System.out.println("1)employee_idnumber  2)firstname  3)lastname  4)birthday  5)identification_number");
        System.out.println("Please add the number");
        Scanner myInput = new Scanner(System.in);
        int option_number = myInput.nextInt();

        if (option_number == 1) {
            System.out.println("Please enter employee id number");
            int idnumber = myInput.nextInt();
            System.out.println("Please enter new employee id number");
            int new_num = myInput.nextInt();
            update_list_int(Idnumbers, idnumber, new_num);

        }
        if (option_number == 2) {
            Scanner myInput2 = new Scanner(System.in);
            System.out.println("Please enter employee firstname");
            String firstname = myInput2.nextLine();
            System.out.println("Please enter new employee firstname");
            String new_firstname = myInput2.nextLine();
            update_list_string(firstname_List, firstname, new_firstname);

        }
        if (option_number == 3) {
            System.out.println("Please enter employee lastname");
            String lastname = myInput.nextLine();
            System.out.println("Please enter new employee lastname");
            String new_lastname = myInput.nextLine();
            update_list_string(lastname_List, lastname, new_lastname);

        }
        if (option_number == 4) {
            System.out.println("Please enter birthday");
            String birthday = myInput.nextLine();
            System.out.println("Please enter new birthday");
            String new_birthday = myInput.nextLine();
            update_list_string(birthday_List, birthday, new_birthday);

        }
        if (option_number == 5) {
            System.out.println("Please enter employee identification_number");
            int idnumber = myInput.nextInt();
            System.out.println("Please enter new employee identification_number");
            int new_num = myInput.nextInt();
            update_list_int(Idnumbers, idnumber, new_num);

        }
    }

    public void employee() {
        menu menu = new menu();
        loan loan = new loan();
        System.out.println(
                "Welcome to employee info section which type of operation you want to do? please enter the number of option ");
        System.out.println(
                "1) Add employee 2)Edit employee 3)Delete employee 4)Get all employees 5)return back to the menu");
        Scanner myInput = new Scanner(System.in);
        int number_operation = myInput.nextInt();
        if (number_operation == 1) {
            setting_info();
        }
        if (number_operation == 2) {
            update_employee();
        }
        if (number_operation == 3) {
            delete_employee();
        }
        if (number_operation == 4) {
            display_employees();
        }

        if (number_operation == 5) {

            menu.menu_description();
        }

    }

    public boolean checking_employee_id(int id){
        boolean checking = this.Idnumbers.contains(id);
        if (checking){
            return true;
        }else {
            return false;
        }
    }
    public boolean availability_employee(){
        if (this.Idnumbers.size() > 0){
            return true;
        }else {
            return false;
        }
    }
    public void setName_by_id(int id){
        int index = this.Idnumbers.indexOf(id);
        String fname = firstname_List.get(index);
        String lname = lastname_List.get(index);
        this.employee_name = fname+lname;
    }
    public String getName(){
        return  this.employee_name;
    }

    public String employee_name(int id) {
        int index = this.Idnumbers.indexOf(id);
        String fname = firstname_List.get(index);
        String lname = lastname_List.get(index);
        return fname + " "+lname;
    }

    public int sum(int a, int b) {
        int result = a + b;
        return result;
    }
    public void additional_operation() {
        salary salary = new salary();
        menu menu = new menu();
        System.out.println(
                "Do you want to do more operation");
        Scanner myInput1 = new Scanner(System.in);
        String condition = myInput1.nextLine();
        if (condition.equals("yes") || condition.equals("Yes")) {
            employee();
        }else {
            salary.import_employee(this.Idnumbers);
            loan.import_employee(this.Idnumbers);
            menu.menu_description();
        }
    }
}
