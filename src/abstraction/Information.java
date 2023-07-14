package abstraction;
public abstract class Information {
    // Abstract method (does not have a body)
    public abstract void display_info(String first_name, String last_name,Integer idnumbers, Integer identity_number);
    // Regular method
    public void sleep() {
        System.out.println("Zzz");
    }
}

// Subclass (inherit from Animal)


