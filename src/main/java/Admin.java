public class Admin {
    private String Name;
    private String userName;
    private String password;

    public Admin(String name, String userName, String password) {
        this.Name = name;
        this.userName = userName;
        this.password = password;
    }


    //Getter Methods
    public String getName() {
        return Name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    // Setter Only For Changing The Password
    public void setPassword(String password) {
        this.password = password;
    }
}
