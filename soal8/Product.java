package soal8;

public class Product {
    private String sku;
    private String productName;
    private int quantityInStock;
    private double price;
    private String category;

    // Getter & Setter
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "SKU: " + sku +
                ", Name: " + productName +
                ", Stock: " + quantityInStock +
                ", Price: $" + price +
                ", Category: " + category;
    }
}
