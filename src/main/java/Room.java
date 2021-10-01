public class Room {
    private int roomNumber;
    private int keyNumber;
    private boolean occupiedStatus;
    private boolean reservationStatus;
    private String reservationDate;
    static private int totalRoomsCreated=1;

    //Constructor
    public Room() {
        this.roomNumber = totalRoomsCreated;
        this.occupiedStatus = false;
        this.reservationStatus = false;
        this.reservationDate = "-";
        this.keyNumber=this.roomNumber;
        System.out.println("New Room Number "+(this.totalRoomsCreated));

        totalRoomsCreated++;
    }

    //===================================================== Getter Methods For the Room Class =====================================================
    public int getRoomNumber() {
        return roomNumber;
    }

    public int getKeyNumber() {
        return keyNumber;
    }

    public boolean isOccupiedStatus() {
        return occupiedStatus;
    }

    public boolean isReservationStatus() {
        return reservationStatus;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public static int getTotalRoomsCreated() {
        return totalRoomsCreated-1;
    }

    public Room getRoomDetails()
    {
        return this;
    }

    //===================================================== Setter Methods For The Room Class =====================================================
    public void setOccupiedStatus(boolean occupiedStatus) {
        this.occupiedStatus = occupiedStatus;
    }

    public void setReservationStatus(boolean reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public static void setTotalRoomsCreated(int totalRoomsCreated) {
        Room.totalRoomsCreated = totalRoomsCreated;
    }
    public void DisplayRoomDetails()
    {
        System.out.println("Room Number\t\tOccupied Status\t\tReservation Status\t\tReservation Date");
        System.out.println(this.roomNumber+"\t"+this.occupiedStatus+"\t"+this.reservationStatus+"\t"+this.reservationDate);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", keyNumber=" + keyNumber +
                ", occupiedStatus=" + occupiedStatus +
                ", reservationStatus=" + reservationStatus +
                ", reservationDate='" + reservationDate + '\'' +
                '}';
    }
}
