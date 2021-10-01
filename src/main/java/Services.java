public class Services {
    private String serviceName;
    private int price;
    private String serviceType;

    //==================================================== Constructor ==============================================================================================
    public Services(String serviceName, int price, String serviceType) {
        this.serviceName = serviceName;
        this.price = price;
        this.serviceType = serviceType;
    }

    //Display Method
    @Override
    public String toString() {
        return this.serviceName+"\t\t"+this.serviceType+"\t\t\t"+this.price+"\n";

    }

}
