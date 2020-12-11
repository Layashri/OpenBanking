package TestEndpoints;

public enum Endpts {

    Product("/cds-au/v1/banking/products"),
    ProductDetails("/cds-au/v1/banking/products/{productID}"),
    Outages("/cds-au/v1/discovery/outages");

    private final String path;
    Endpts(String path) {this.path=path;}

    public String path() {
        return path;
    }
}
