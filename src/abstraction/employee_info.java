package abstraction;

public class employee_info extends Information{
    public void display_info(String first_name, String last_name,Integer idnumbers, String identity_number) {

        System.out.println(" The employee with the name of " + first_name +
                " "+last_name + " with the id number" + idnumbers
                + " Identification number " + identity_number);
    }
}
