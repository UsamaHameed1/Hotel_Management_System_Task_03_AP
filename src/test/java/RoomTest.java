import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {

    Room r1;
    @Before
    public void setUp()
    {
        r1=new Room();
        Room.setTotalRoomsCreated(0);
    }





    @Test
    public void isOccupiedStatus() {
        Assert.assertFalse(r1.isOccupiedStatus());
    }

    @Test
    public void isReservationStatus() {
        Assert.assertFalse(r1.isReservationStatus());
    }

    @Test
    public void getReservationDate() {
        Assert.assertFalse(r1.isReservationStatus());
    }



    @Test
    public void setOccupiedStatus() {
        r1.setOccupiedStatus(true);
        Assert.assertTrue(r1.isOccupiedStatus());

    }

    @Test
    public void setReservationStatus() {
        r1.setReservationStatus(true);
        Assert.assertTrue(r1.isReservationStatus());
    }

    @Test
    public void setReservationDate() {
        r1.setReservationDate("12-12-2021");
        Assert.assertEquals("12-12-2021",r1.getReservationDate());
    }
}