import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    Customer c1;
    Room r1;
    @Before
    public void setUp()
    {
        r1=new Room();
        c1 =new Customer("ABC","1234","+92145",r1,"12-05-2021","25-06-2021");

    }
    @Test
    public void getName() {
        Assert.assertEquals("ABC",c1.getName());
    }

    @Test
    public void getCNIC() {
        Assert.assertEquals("1234",c1.getCNIC());
    }

    @Test
    public void getPhoneNo() {
        Assert.assertEquals("+92145",c1.getPhoneNo());
    }

    @Test
    public void getRoomOccupiedByCustomer() {
        Assert.assertEquals(r1,c1.getRoomOccupiedByCustomer());
    }

    @Test
    public void getCheckInDate() {
        Assert.assertEquals("12-05-2021",c1.getCheckInDate());
    }

    @Test
    public void getCheckOutDate() {
        Assert.assertEquals("25-06-2021",c1.getCheckOutDate());
    }



    @Test
    public void getCustomerTotalBill() {
        assertEquals(0,c1.getCustomerTotalBill());
    }

    @Test
    public void getCustomerDetails() {
        assertEquals(c1,c1.getCustomerDetails());
    }

    @Test
    public void getCustoemrID() {
        assertEquals(1,c1.getCustoemrID());
    }

    @Test
    public void setRoomOccupiedByCustomer() {
        Room r2=new Room();
        c1.setRoomOccupiedByCustomer(r2);
        assertEquals(r2,c1.getRoomOccupiedByCustomer());
    }

    @Test
    public void setCheckOutDate() {
        c1.setCheckOutDate("1-1-2021");
        Assert.assertEquals("1-1-2021",c1.getCheckOutDate());
    }

    @Test
    public void setCustomerTotalBill() {
        c1.setCustomerTotalBill(1500);
        Assert.assertEquals(1500,c1.getCustomerTotalBill());
    }
}