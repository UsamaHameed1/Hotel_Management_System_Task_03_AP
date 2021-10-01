import java.util.Scanner;

public class Hotel_Management_System {
    public static void main(String[] args) {
        try {
            Hotel ABC_HOTEL = new Hotel("ABC HOTEL");
            ABC_HOTEL.getAdmins_List().add(new Admin("Anwar Maqsood", "12", "12"));
            Scanner sc = new Scanner(System.in);
            boolean loginStatus = false;

            do {
                System.out.println("\n===================== Welcome To DE` ABC Hotel ===================== ");
                System.out.println("\n\nAdmin Portal");
                System.out.println("Default Admin Login: 12");
                System.out.println("Default Admin Password: 12");


                System.out.println("\n\n---- Admin Login -----");

                System.out.print("Enter Admin Login : ");
                String admin_login = sc.nextLine();

                System.out.print("Enter Admin Password : ");
                String admin_pass = sc.nextLine();



                for (Admin testAdmin : ABC_HOTEL.getAdmins_List()) {
                    if (admin_login.equals(testAdmin.getUserName()) && admin_pass.equals(testAdmin.getPassword())) {
                        System.out.println("Login Successful");
                        System.out.println("Welcome " + testAdmin.getName());
                        ABC_HOTEL.openAdminHotelPortal();
                        loginStatus=false;
                    }
                    loginStatus=true;
                }

            } while (loginStatus);
        }
        catch (Hotel_Exception E) {
            System.out.println("Exception is Thrown By the Hotel Management System");
            System.out.println(E);
        }catch (Exception E) {
            System.out.println("Exception is Thrown By the Main");
            System.out.println(E);
        }

    }
}