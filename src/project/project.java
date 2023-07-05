package project;

import menu.menu;

import java.util.ArrayList;
import java.util.Scanner;

public class project {
    private int project_id;
    private String project_type;
    private String project_name;
    private String dead_line;

    static ArrayList<Integer> project_id_list = new ArrayList<>();
    static ArrayList<String> project_type_list = new ArrayList<>();
    static ArrayList<String> project_name_list = new ArrayList<>();
    static ArrayList<String> dead_line_list = new ArrayList<>();

    public void add_project(){
        System.out.println("Please add the project type");
        this.project_id = this.project_id + 1;
        project_id_list.add(this.project_id);
        Scanner project = new Scanner(System.in);
        String project_type = project.nextLine();
        this.project_type = project_type;
        project_type_list.add(this.project_type);
        System.out.println("Please add the project name");
        String project_name = project.nextLine();
        this.project_name = project_name;
        project_name_list.add(this.project_name);
        System.out.println("Please add the deadline for the project");
        String dead_line = project.nextLine();
        this.dead_line = dead_line;
        dead_line_list.add(this.dead_line);
        System.out.println("So the project " + this.project_name + " with the type of the "
        + this.project_type + " and with the deadline of " + this.dead_line
        + " with the id " + this.project_id + " added to the list");
        additional_operation();
    }


    public void update_project(){
        System.out.println("Please add the id number of the project that you want to update");
        Scanner update_project = new Scanner(System.in);
        int project_id_update = update_project.nextInt();
        if(!project_id_list.contains(project_id_update)){
            System.out.println("Sorry there is not project with this id number in the project list so please try again");
            this.update_project();
        }
        System.out.println("So please choose which type of option you want to update");
        System.out.println("1) Project type   2) Project name  3)Deadline");
        int choose_option_update = update_project.nextInt();
        if (choose_option_update == 1){
            System.out.println("Please enter new project type");
            Scanner project_type_scanner = new Scanner(System.in);
            String project_type = project_type_scanner.nextLine();
            int index = project_id_list.indexOf(project_id_update);
            project_type_list.set(index,project_type);
        }
        if (choose_option_update == 2){
            System.out.println("Please enter new project name");
            Scanner project_name_scanner = new Scanner(System.in);
            String project_name = project_name_scanner.nextLine();
            int index = project_id_list.indexOf(project_id_update);
            project_name_list.set(index,project_name);
        }
        if (choose_option_update == 3){
            System.out.println("Please enter new deadline");
            Scanner project_deadline_scanner = new Scanner(System.in);
            String project_deadline = project_deadline_scanner.nextLine();
            int index = project_id_list.indexOf(project_id_update);
            dead_line_list.set(index,project_deadline);
        }
        additional_operation();
    }
    public void delete_project() {
        if(project_id_list.size() == 0){
            System.out.println("Sorry there is not any project in the list try again");
            this.delete_project();
        }
        System.out.println("Please add the project id that you want to remove");
        Scanner delete_project = new Scanner(System.in);
        int idnumber_project = delete_project.nextInt();
        boolean contain_role = project_id_list.contains(idnumber_project);

        if (contain_role){
            int index = project_id_list.indexOf(idnumber_project);
            project_id_list.remove(index);
            project_name_list.remove(index);
            project_type_list.remove(index);
            dead_line_list.remove(index);
            System.out.println("Now the project with the id number " + idnumber_project +
                    "completely remove");
        }else {
            System.out.println("Sorry the project with this id is not in the list");
        }

        additional_operation();
    }
    public void display_projects(){
        if (project_id_list.size() > 0) {
            for (int i = 0; i <= project_id_list.size() - 1; i++) {
                System.out.println("So the project " + project_name_list.get(i) + "from the type of "
                        + project_type_list.get(i) + " has the id of " +project_id_list.get(i));
            }
        } else {
            System.out.println("Sorry there is not any project in the list of projects");
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
            introduce_section_project();
        }else {
            menu.menu_description();
        }
    }
    public void introduce_section_project(){
        System.out.println("Welcome to the project section which type of the operation you want to do");
        System.out.println(
                "1)add project 2)update project 3)delete project 4)get all projects");
        System.out.println("Please add the number of option");
        Scanner myInput = new Scanner(System.in);
        int option_number = myInput.nextInt();

        if (option_number == 1) {
            add_project();
        }
        if(option_number == 2){
            update_project();
        }
        if(option_number == 3){
            delete_project();
        }
        if(option_number == 4){
            display_projects();
        }
    }
    public boolean  project_availability(){
        if (project_id_list.size() > 0){
            return true;
        }else {
            return false;
        }
    }
    public boolean check_project_by_id(int id){
        if (project_id_list.contains(id)){
            return true;
        }else {
            return false;
        }
    }
    public String check_project_name(int id){
        int index = project_id_list.indexOf(id);
        return project_name_list.get(index);
    }
}
