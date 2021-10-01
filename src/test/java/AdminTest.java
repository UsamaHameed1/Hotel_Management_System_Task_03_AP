import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminTest {

    Admin a1;
    @Before
    public void setup()
    {
        a1=new Admin("abc","abc","123");
    }
    @Test
    public void getName() {
        Assert.assertEquals("abc",a1.getName());
    }

    @Test
    public void getUserName() {
        Assert.assertEquals("abc",a1.getUserName());
    }

    @Test
    public void getPassword() {
        Assert.assertEquals("123",a1.getPassword());
    }

    @Test
    public void setPassword() {
        a1.setPassword("789");
        Assert.assertEquals("789",a1.getPassword());
    }
}