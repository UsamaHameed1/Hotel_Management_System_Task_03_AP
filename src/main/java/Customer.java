import java.util.Vector;

public class Customer {
    private int custoemrID=0;
    private String Name;
    private String CNIC;
    private String phoneNo;
    private Room roomOccupiedByCustomer;
    private String checkInDate;
    private String checkOutDate;
    private Vector<Services> servicesUsed;
    private long customerTotalBill;
    static private int totalCustomerCount=1;

    //================================================= Constructors ===============================================================================================================
    public Customer(String name, String CNIC, String phoneNo, Room roomOccupiedByCustomer, String checkInDate, String checkOutDate) {
        this.custoemrID = totalCustomerCount;
        Name = name;
        this.CNIC = CNIC;
        this.phoneNo = phoneNo;
        this.roomOccupiedByCustomer = roomOccupiedByCustomer;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.servicesUsed=new Vector<>();


        ++totalCustomerCount;
    }
    public Customer()
    {

    }

    //================================================= Getters ===============================================================================================================
    public String getName() {
        return Name;
    }

    public String getCNIC() {
        return CNIC;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public Room getRoomOccupiedByCustomer() {
        return roomOccupiedByCustomer;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public Vector<Services> getServicesUsed() {
        return servicesUsed;
    }

    public long getCustomerTotalBill() {
        return customerTotalBill;
    }

    public Customer getCustomerDetails()
    {
        return this;
    }

    public int getCustoemrID() {
        return custoemrID;
    }

    //================================================= Setters ===============================================================================================================
    public void setRoomOccupiedByCustomer(Room roomOccupiedByCustomer) {
        this.roomOccupiedByCustomer = roomOccupiedByCustomer;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setCustomerTotalBill(long customerTotalBill) {
        this.customerTotalBill = customerTotalBill;
    }

    public void addService(Services temp)
    {
        servicesUsed.add(temp);
    }

    public void displayCustomerDisplay()
    {
        System.out.println("Customer Name : "+this.Name);
        System.out.println("Customer CNIC : "+this.CNIC);
        System.out.println("Customer Phone No : "+this.phoneNo);
        System.out.println("\nCustomer Room Occupied : \n");
        this.roomOccupiedByCustomer.DisplayRoomDetails();
        System.out.println("\n");

        System.out.println("Customer Check In Date : "+this.checkInDate);
        System.out.println("Customer Check Out Date : "+this.checkOutDate);
        System.out.println("Customer Total Bill (Avaliable After Checkout): "+this.customerTotalBill);
        System.out.println("\nCustomer ID : "+this.custoemrID);

    }

    @Override
    public String toString() {
        return "Customer{" +
                "custoemrID=" + custoemrID +
                ", Name='" + Name + '\'' +
                ", CNIC='" + CNIC + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", roomOccupiedByCustomer=" + roomOccupiedByCustomer +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                ", servicesUsed=" + servicesUsed +
                ", customerTotalBill=" + customerTotalBill +
                '}';
    }
}
