import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Hotel {
    private String hotelName;
    private Vector<Customer> Customers_List;
    private Vector<Room> Rooms_List;
    private Vector<Admin> Admins_List;

    //******************************** Constructor************************************************************************************************************************
    public Hotel(String hotelName) {
        this.hotelName = hotelName;
        Customers_List=new Vector<>();
        Rooms_List=new Vector<>();
        for (int i = 0; i <5; i++) {
            Rooms_List.add(new Room());
        }
        Admins_List=new Vector<>();
    }

    // ================================ Getter Methods ===================================================================================================================
    public Vector<Customer> getCustomers_List() {
        return Customers_List;
    }

    public Vector<Room> getRooms_List() {
        return Rooms_List;
    }

    public Vector<Admin> getAdmins_List() {
        return Admins_List;
    }

    public void Add_Rooms(int numberOfRooms)
    {
        try {
            if(numberOfRooms <=0)
            {
                System.out.println("Invalid Number of Rooms Enter Please Try Again");
                throw new IOException("Invalid Input Entered in The System");
            }
            else
            {
                System.out.println("\n--->Adding New "+numberOfRooms+" Rooms in the System");
                for (int i = 1; i <= numberOfRooms; i++) {
                    Rooms_List.add(new Room());
                }
                System.out.println("New Rooms Added Successfully");
            }
        }catch (Exception E)
        {
            System.out.println("-->Exception Thrown");
            System.out.println(E);
        }
    }

    public void getAvailableRooms()
    {
        System.out.println("\n\tFollowing Rooms Are Available for Both Reservations and Bookings");
        for (Room availableRoom: this.Rooms_List)
        {
            if(availableRoom.isOccupiedStatus() ==false && availableRoom.isReservationStatus() ==false)
            {
                System.out.println("\tRoom Number : "+availableRoom.getRoomNumber());
            }
        }
    }

    public boolean isRoomAvailable(int roomNumber)
    {
        if(Rooms_List.get(roomNumber).isReservationStatus() ==false && Rooms_List.get(roomNumber).isOccupiedStatus()==false)
        {
            return true;
        }
        return false;
    }
   public Customer Search_Guest(int customerID)
   {
       try
       {
           System.out.println("Guest Searching Menu");
           for (Customer qureyCustomer : Customers_List)
           {
               if(customerID == qureyCustomer.getCustoemrID())
               {
                   System.out.println("Customer Details Are");
                   qureyCustomer.getCustomerDetails();
                   return qureyCustomer;
               }
           }
       }catch (Exception E)
       {
           System.out.println(E);
       }
       return null;
   }

    public void openAdminHotelPortal() throws Exception
    {
            try {
                Scanner sc = new Scanner(System.in);
                int optionChoice=-1;
                boolean quitStatus=true;

                do {
                    System.out.println("\n\n=======================================================");
                    System.out.println("Welcome To the Admin Hotel Portal");
                    System.out.println("\n\t1. Add New Rooms");
                    System.out.println("\n\t2. Get Available Rooms");
                    System.out.println("\n\t3. Search Guest");
                    System.out.println("\n\t4. Book Room");
                    System.out.println("\n\t5. Reserve A Room");
                    System.out.println("\n\t6. Customer Checkout and Print the Bill");
                    System.out.println("\n\t7. Quit the Menu");
                    System.out.println("\n=======================================================");


                    System.out.print("\nEnter Your Choice : ");
                    optionChoice = sc.nextInt();

                    switch (optionChoice) {
                        case 1: {
                            System.out.print("\nEnter The Number of Rooms To Enter : ");
                            int numRooms = sc.nextInt();
                            this.Add_Rooms(numRooms);
                            System.out.println("Total Rooms in Hotel : " + this.getRooms_List().get(0).getTotalRoomsCreated());
                            break;
                        }
                        case 2: {
                            System.out.println("\n\n------------ Available Rooms List ------------ ");
                            this.getAvailableRooms();
                            break;
                        }
                        case 3: {
                            System.out.println("\n\n------------ Search Customer------------ ");
                            System.out.print("\nPlease Enter the Customer ID : ");
                            int customerID = sc.nextInt();
                            Customer serachedCustomer= this.Search_Guest(customerID);
                            if(serachedCustomer !=null)
                            {
                                serachedCustomer.displayCustomerDisplay();
                            }
                            else
                            {
                                System.out.println("Customer Not Found");
                            }
                            break;
                        }
                        case 4: {
                            System.out.println("Room Booking Menu");

                            sc.nextLine();
                            System.out.print("Enter Your Name : ");
                            String name = sc.nextLine();

                            System.out.print("Enter the CNIC Number (With -) : ");
                            String CNIC = sc.nextLine();

                            System.out.print("Enter The Phone Number : ");
                            String phoneNo = sc.nextLine();

                            System.out.print("Enter The Check In Date : ");
                            String checkInDate = sc.nextLine();

                            System.out.print("Enter The Check Out Date : ");
                            String checkOutDate = sc.nextLine();

                            System.out.print("Please Enter The Room Number You want to Book : ");
                            int roomNumber = sc.nextInt()-1;

                            if(roomNumber <0 )
                            {
                                throw new Hotel_Exception("Invlaid Room Number Entered");
                            }

                            boolean avaliableRoomStatus = this.isRoomAvailable(roomNumber);
                            if (avaliableRoomStatus == true) {
                                Rooms_List.get(roomNumber).setOccupiedStatus(true);
                                Room bookedRoom = Rooms_List.get(roomNumber);
                                bookedRoom.setOccupiedStatus(true);
                                //adding the customer to the records
                                Customers_List.add(new Customer(name, CNIC, phoneNo, bookedRoom, checkInDate, checkOutDate));
                                System.out.println("\n\n==================Customer Details====================");
                                getCustomers_List().lastElement().displayCustomerDisplay();

                                System.out.println("\n\nRoom Booked !!!! Thank You For Choosing Us");
                            }
                            else
                            {
                                System.out.println("\n\nThe Room is Already Booked");

                            }
                            break;
                        }
                        case 5: {
                            System.out.println("------------ Reserve A Room Menu ------------ ");
                            System.out.print("Please Enter The Room Number You want to Book : ");
                            int roomNumber = sc.nextInt()-1;
                            boolean avaliableRoomStatus = this.isRoomAvailable(roomNumber);
                            if (avaliableRoomStatus == true) {

                                System.out.println("\nThe Room " + roomNumber+1 + " is available from Reservation");
                                System.out.print("\nDo you want to Reserve the Room " + roomNumber+1 + " Y-Yes & N-No : ");
                                char choice = sc.next().charAt(0);

                                if (choice == 'y' || choice == 'Y') {
                                    sc.nextLine();
                                    System.out.print("Enter the Resvation Date : ");
                                    String reservationDate = sc.nextLine();

                                    Rooms_List.get(roomNumber).setReservationStatus(true);
                                    Rooms_List.get(roomNumber).setReservationDate(reservationDate);

                                    System.out.println("Your Room is Booked Now ");
                                    System.out.println("Room #"+roomNumber+1+" Reserved at "+reservationDate);

                                } else {
                                    System.out.println("\nReservations Cancelled\nThanks For Coming 😀😀😀 ");
                                }
                            }
                            else
                            {

                                System.out.println("\n\nThe Room is Already Booked");
                                Rooms_List.get(roomNumber-1).DisplayRoomDetails();
                            }
                            break;
                        }
                        case 6: {
                            System.out.println("------------ Customer Check Out and Customer Bill Menu------------ ");
                            System.out.print("Please Enter your Customer ID : ");
                            int customerID = sc.nextInt()-1;

                            Customer checkoutCustomer = Customers_List.get(customerID);
                            Customers_List.add(customerID,new Customer());


                            Rooms_List.get(customerID).setReservationStatus(false);
                            Rooms_List.get(customerID).setOccupiedStatus(false);
                            Rooms_List.get(customerID).setReservationDate("-");
                            checkoutCustomer.getRoomOccupiedByCustomer().setOccupiedStatus(false);
                            checkoutCustomer.getRoomOccupiedByCustomer().setReservationStatus(false);


                            System.out.println("Enter The Price of Food Services");
                            int foodPrice= sc.nextInt();
                            System.out.println("Enter The Price of Other Services");
                            int otherPrice= sc.nextInt();
                            System.out.println("Enter The Price of Room Charges Services");
                            int roomPrice= sc.nextInt();

                            checkoutCustomer.addService(new Services("Food",foodPrice,"Food Services"));
                            checkoutCustomer.addService(new Services("Room Cleaning",otherPrice,"Other Services"));
                            checkoutCustomer.addService(new Services("Room Charges",otherPrice,"Room Rent"));
                            checkoutCustomer.setCustomerTotalBill(foodPrice+roomPrice+otherPrice);

                            System.out.println("\n\n\t\t------ Printing Bill ------------ ");
                            checkoutCustomer.displayCustomerDisplay();
                            for (Services temp: checkoutCustomer.getServicesUsed())
                            {
                                System.out.println(temp);
                            }
                            System.out.println("Total Bill : "+(foodPrice+roomPrice+otherPrice));

                            break;
                        }
                        case 7:
                        {
                            //****************************** Creating the file ******************************************************************
                            try
                            {
                                File Room_List_File=new File("Rooms Details.txt");
                                if (Room_List_File.createNewFile()) {
                                    System.out.println("File created: " + Room_List_File.getName());
                                } else {
                                    System.out.println("File already exists.");
                                }
                            }
                            catch(IOException e)
                            {
                                System.out.println(e);
                            }

                            //*********************** Write the File ******************************************************************************
                            try {
                                FileWriter Room_List_File = new FileWriter("Rooms Details.txt");
                                for (int i = 0; i <Rooms_List.size(); i++) {
                                    String line=Rooms_List.get(i).toString()+"\n";
                                    Room_List_File.write(line);
                                }
                                Room_List_File.close();
                                System.out.println("Successfully wrote to the file.");
                            } catch (IOException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                            quitStatus=false;
                            break;
                        }
                        default: {
                            System.out.println("------------ Invalid Option Inserted------------ ");
                        }
                    }
                }while (quitStatus);
            }catch (Hotel_Exception E)
            {
                System.out.println("Exception Thrown");
                System.out.println(E);
            }catch (Exception E)
            {
                System.out.println("Exception Thrown");
                System.out.println(E);
            }


    }

}
