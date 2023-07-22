package task;

import employee.employee;
import menu.menu;
import project.project;

import java.util.ArrayList;
import java.util.Scanner;

public class task {
    private int task_id;
    private String task_name;
    private String description;

    private int employee_id;
    private int project_id;
    static ArrayList<Integer> task_id_list = new ArrayList<>();
    static ArrayList<String> task_name_list = new ArrayList<>();
    static ArrayList<String> description_list = new ArrayList<>();
    static ArrayList<Integer> employee_id_list = new ArrayList<>();
    static ArrayList<Integer> project_id_list = new ArrayList<>();
    class task_specification{
        private Integer task_id = 0;
        private String task_name;
        private String description;
        static ArrayList<Integer> task_id_list = new ArrayList<>();
        static ArrayList<String> task_name_list = new ArrayList<>();
        static ArrayList<String> description_list = new ArrayList<>();
        public void add_detail_task (String name, String description, Integer employee_id , String project_name)
        {
            this.task_id += 1;
            this.task_name = name;
            this.description = description;
            this.task_id_list.add(this.task_id);
            this.task_name_list.add(this.task_name);
            this.description_list.add(this.description);
            System.out.println("So the task " + name + " and description of  " + description+ " with the id "+ this.task_id+
                "devoted to the "+ employee_id + " and it's related to the project of "
            + project_name);
        }
    }

    class project_specification{
        employee employee = new employee();
        project project = new project();
        boolean project_availability = project.project_availability();
        boolean employee_availability = employee.availability_employee();

        public void checking_project( ){
            if (!project_availability){
                System.out.println("Sorry for enter to this section first you need to add some project, now there is"+
                        "not any project");
                menu.menu_description();
            }
            if (!employee_availability){
                System.out.println("Sorry for enter to this section first you need to add some employee, now there is"+
                        "not any employee");
                menu.menu_description();
            }

        }
    }


    menu menu = new menu();

    employee employee = new employee();
    public void add_task(){
        project project = new project();
        project_specification project_spec = new project_specification();
        task_specification new_task = new task_specification();
        project_spec.checking_project();
        System.out.println("Please add the project id that you want to create task for it");
        Scanner add_project_scanner = new Scanner(System.in);
        int project_id = add_project_scanner.nextInt();
        project.check_project_by_id(project_id);
        boolean project_check_id = project.check_project_by_id(project_id);
        if (!project_check_id){
            System.out.println("sorry this project is not in the list please try again");
            this.add_task();
        }
        System.out.println("Please add the employee id that you want to devote task for him");
        Scanner add_employee_scanner = new Scanner(System.in);
        int employee_id = add_employee_scanner.nextInt();
        boolean employee_check_id = employee.checking_employee_id(employee_id);
        if (!employee_check_id){
            System.out.println("sorry this employee is not in the list please try again");
            this.add_task();
        }

        this.project_id = project_id;
        this.employee_id = employee_id;
        System.out.println("please add the task name");
        Scanner add_task_scanner = new Scanner(System.in);
        String task_name = add_task_scanner.nextLine();
        System.out.println("please add the description for the task");
        Scanner add_description_scanner = new Scanner(System.in);
        String add_description = add_description_scanner.nextLine();
        new_task.add_detail_task(task_name,add_description,employee_id,project.check_project_name(this.project_id));
        project_id_list.add(this.project_id);
        employee_id_list.add(this.employee_id);
        this.additional_operation();
    }
    public void update_task(){
        employee employee = new employee();
        if(task_id_list.size() == 0){
            System.out.println("Sorry there is nothing in the task list for update");
            this.additional_operation();
        }
        System.out.println("Please add the id number of the task that you want to update");
        Scanner update_task = new Scanner(System.in);
        int task_id_update = update_task.nextInt();
        if(!task_id_list.contains(task_id_update)){
            System.out.println("Sorry there is not task with this id number in the task list so please try again");
            this.update_task();
        }
        System.out.println("So please choose which type of option you want to update");
        System.out.println("1) task name   2) Project  3) employee  4) description");

        int choose_option_update = update_task.nextInt();
        if (choose_option_update == 1){
            System.out.println("Please enter new task name");
            Scanner task_name_scanner = new Scanner(System.in);
            String task_name = task_name_scanner.nextLine();
            int index = task_id_list.indexOf(task_id_update);
            task_name_list.set(index,task_name);
        }
        if (choose_option_update == 2){
            System.out.println("Please enter new id project");
            Scanner project_name_scanner = new Scanner(System.in);
            int project_id = project_name_scanner.nextInt();
            int index = task_id_list.indexOf(task_id_update);
            project_id_list.set(index,project_id);
        }
        if (choose_option_update == 3){
            System.out.println("Please enter new employee id");
            Scanner employee_id_scanner = new Scanner(System.in);
            int employee_id = employee_id_scanner.nextInt();
            if (!employee.checking_employee_id(employee_id)){
                System.out.println("Sorry there is not the id of the employee in list please try again");
                this.update_task();
            }
            int index = task_id_list.indexOf(task_id_update);
            employee_id_list.set(index,employee_id);
        }
        if (choose_option_update == 4){
            System.out.println("Please add new description for the task");
            Scanner task_description_scanner = new Scanner(System.in);
            String new_description = task_description_scanner.nextLine();
            int index = task_id_list.indexOf(task_id_update);
            description_list.set(index,new_description);
        }
        System.out.println("Your task successfully updated");
        additional_operation();
    }
    public void delete_task() {
        if(task_id_list.size() == 0){
            System.out.println("Sorry there is not any task in the list try again");
            this.delete_task();
        }
        System.out.println("Please add the task id that you want to remove");
        Scanner delete_task = new Scanner(System.in);
        int id_task = delete_task.nextInt();
        boolean contain_task = task_id_list.contains(id_task);

        if (contain_task){
            int index = task_id_list.indexOf(id_task);
            project_id_list.remove(index);
            task_id_list.remove(index);
            task_name_list.remove(index);
            description_list.remove(index);
            employee_id_list.remove(index);
            System.out.println("Now the task with the id number of " + id_task +
                    "completely remove");
        }else {
            System.out.println("Sorry the task with this id is not in the list");
        }

        additional_operation();
    }
    public void additional_operation() {
        menu menu = new menu();
        System.out.println(
                "Do you want to do more operation");
        Scanner myInput1 = new Scanner(System.in);
        String condition = myInput1.nextLine();
        if (condition.equals("yes") || condition.equals("Yes")) {
            introduce_section_task();
        }else {
            menu.menu_description();
        }
    }
    public void display_tasks(){
        project project = new project();
        if (task_id_list.size() > 0) {
            for (int i = 0; i <= task_id_list.size() - 1; i++) {
                System.out.println("So the task " + task_name_list.get(i) + "with the id "
                        + task_id_list.get(i) + " that is about  " + description_list.get(i)
                + " from project of " + project.check_project_name(project_id_list.get(i)) +
                        " is devoted to the " + employee.employee_name(employee_id_list.get(i)));
            }
        } else {
            System.out.println("Sorry there is not any project in the list of projects");
        }
        additional_operation();
    }
    public void introduce_section_task(){
        System.out.println("Welcome to the project section which type of the operation you want to do");
        System.out.println(
                "1)add task 2)update task 3)delete task 4)get all tasks");
        System.out.println("Please add the number of option");
        Scanner myInput = new Scanner(System.in);
        int option_number = myInput.nextInt();

        if (option_number == 1) {
            add_task();
        }
        if(option_number == 2){
            update_task();
        }
        if(option_number == 3){
            delete_task();
        }
        if(option_number == 4){
            display_tasks();
        }
    }
}
