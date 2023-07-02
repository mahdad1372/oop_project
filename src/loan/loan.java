package loan;
import menu.menu;
import java.util.ArrayList;

import java.util.Scanner;
public class loan {
    private int loan_id;
    private String loan_type;
    private int loan_amount;
    private int employee_id;

    public static void main(String args[]) {
        menu obj = new menu();
        obj.menu_description();

    }

    ArrayList<Integer> Idnumbers_employee = new ArrayList<>();
    ArrayList<Integer> Idnumbers_employee_frk = new ArrayList<>();
    ArrayList<Integer> loan_id_List = new ArrayList<>();
    ArrayList<String> loan_type_List = new ArrayList<>();
    ArrayList<Integer> loan_amount_List = new ArrayList<>();
    Scanner myInput = new Scanner(System.in);
    menu menu_section = new menu();

    public void add_loan() {
        System.out.println("Please add the loan id");
        int idnumber = myInput.nextInt();
        this.loan_id = idnumber;
        loan_id_List.add(this.loan_id);
        System.out.println("Please add the loan type");
        String loantype = myInput.nextLine();
        this.loan_type = loantype;
        loan_type_List.add(this.loan_type);
        System.out.println("Please add the loan amonut per euro");
        int loanamount = myInput.nextInt();
        this.loan_amount = loanamount;
        loan_amount_List.add(this.loan_amount);
        System.out.println("Please add the employee id that you want to give hime the loan");
        int employee_id = myInput.nextInt();
        boolean containsElement = Idnumbers_employee.contains(employee_id);
        if (containsElement) {
            this.employee_id = employee_id;
            Idnumbers_employee_frk.add(this.employee_id);
        } else {
            System.out.println("Sorry this employee with this id number is not in the list");
        }
    }

    public void display_loan() {
        if (loan_id_List.size() > 0) {
            for (int i = 0; i <= loan_id_List.size() - 1; i++) {
                System.out.println("So the loan with the id of " +
                        loan_id_List.get(i) + " and the loan type " + loan_type_List.get(i) +
                        " and the loan amount "
                        + loan_amount_List.get(i) + " is devoted to the employee with the id of " +
                        Idnumbers_employee.get(i));
            }
        } else {
            System.out.println("Sorry there is not any loan in the list of loans");
        }
        loan_introduce_section();
    }

    public void update_list_int(ArrayList<Integer> arr, int id, int new_num) {

        int index = loan_id_List.indexOf(id);
        arr.set(index, new_num);

    }

    public void update_list_string(ArrayList<String> arr, int id, String
            new_charecter) {
        int index = loan_id_List.indexOf(id);
        arr.set(index, new_charecter);
    }

    public void delete_loan() {
        System.out.println("Please add the loan id that you want to remove");
        int idnumber_loan = myInput.nextInt();
        int index = loan_id_List.indexOf(idnumber_loan);
        loan_id_List.remove(index);
        Idnumbers_employee_frk.remove(index);
        loan_type_List.remove(index);
        loan_amount_List.remove(index);
        System.out.println("Now the load with the id number " + idnumber_loan +
                "completely remove");
    }

    public void update_loan() {
        Scanner myInput = new Scanner(System.in);
        System.out.println("please add the loan id and then tell us which element you want to edit ");
        int id_number = myInput.nextInt();
        System.out.println("1)loan type 2)loan_amount 3)employee id");
        System.out.println("Please add the number");
        int option_number = myInput.nextInt();

        if (option_number == 1) {
            System.out.println("Please enter new loan type");
            String loantype = myInput.nextLine();
            update_list_string(loan_type_List, id_number, loantype);
        }
        if (option_number == 2) {
            System.out.println("Please enter new loan_amount");
            Integer loan_amount = myInput.nextInt();
            update_list_int(loan_amount_List, id_number, loan_amount);
        }
        if (option_number == 3) {
            System.out.println("Please enter new employee id");
            Integer employee_id = myInput.nextInt();
            update_list_int(Idnumbers_employee_frk, id_number, employee_id);
        }
    }

    public void loan_introduce_section() {
        menu menu = new menu();
        if (Idnumbers_employee.size() > 0) {
            System.out.println("Welcome to the loan setion which type of the operation you want to do");
            System.out.println(
                    "1)add loan 2)update loan 3)delete loan 4)get all loans types of loans");
            System.out.println("Please add the number of option");
            Scanner myInput = new Scanner(System.in);
            int option_number = myInput.nextInt();

            if (option_number == 1) {
                add_loan();
            }
            if (option_number == 2) {
                update_loan();
            }
            if (option_number == 3) {
                delete_loan();
            }
            if (option_number == 4) {
                display_loan();
            }
        } else {
            System.out.println(
                    "Sorry for enter to the loan section first you need to add emplyees without employee it's impossible to enter to this secton");
            menu.menu_description();
        }

    }

    public void exportArray(ArrayList<Integer> array) {
        int size = array.size();
        if (size > 0) {
            for (Integer element : array) {
                Idnumbers_employee.add(element);

            }
        }

    }
}
