package menu;

import attendance.attendance;
import department.department;
import employee.employee;
import loan.loan;
import manager.manager;
import project.project;
import role.role;
import salary.salary;
import task.task;

import java.util.Scanner;
public class menu {


    public void menu_description() {

        Scanner myInput = new Scanner(System.in);
        loan loan = new loan();
        role role = new role();
        project project = new project();
        salary salary = new salary();
        task task = new task();
        employee employee_section = new employee();
        department department = new department();
        attendance attendance = new attendance();
        manager manager = new manager();
        System.out.println("Hello dear manager welcome to the employee managment system");
        System.out.println("Which section you want to enter: 1)employee registration and details  2)loan" +
                " 3)salary  4)department  5)role  6)project  7)task 8)Attendance 9)Manager 10)exit");
        int option = myInput.nextInt();
        if (option == 1) {
            employee_section.employee();
        }

         if (option == 2) {

           loan.loan_introduce_section();
         }
        if (option == 3) {
           salary.salary_introduce_section();
        }
        if (option == 4) {
            department.department_description();
        }
        if (option == 5) {
            role.role_introduce_section();
        }
        if (option == 6) {
            project.introduce_section_project();
        }
        if (option == 7) {
            task.introduce_section_task();
        }
        if (option == 8) {
            attendance.attendence_description();
        }
        if (option == 9) {
            manager.manager_description();
        }
        if (option == 10) {
            System.exit(0);
        }
    }
}
