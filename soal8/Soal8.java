package soal8;

import java.io.FileReader;
import java.util.Scanner;

import com.google.gson.Gson;

public class Soal8 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Input
    System.out.print("Choose dummy data (1 or 2): ");
    Integer input = sc.nextInt();
    sc.close();

    String dummyInput = "";
    if (input.equals(1))
      dummyInput = "dummyData1.json";
    else if (input.equals(2))
      dummyInput = "dummyData2.json";

    try {
      // File berada di folder yang sama dengan Soal8.java
      String url = "D:\\79\\WORK\\TestCaseClient\\OCBC211025\\java\\soal8\\" + dummyInput;
      FileReader reader = new FileReader(url);

      // Parse JSON ke object Java
      Gson gson = new Gson();
      ProductResponse response = gson.fromJson(reader, ProductResponse.class);

      // Tampilkan semua produk
      // for (Product product : response.getData()) {
      // System.out.println(product);
      // }

      int statusValid = productValidator(response);
      System.out.println("Status Valid: " + statusValid);

      reader.close();

    } catch (Exception e) {
      System.out.println("Terjadi kesalahan saat membaca file JSON: " + e.getMessage());
    }
  }

  private static int productValidator(ProductResponse response) {
    int isValid = 400;

    // Validasi setiap atribut di setiap produk
    for (Product product : response.getData()) {
      // SKU kosong
      if (product.getSku() == null || product.getSku().isEmpty()) {
        System.out.println("The sku is a mandatory field");
        break;
      }

      // SKU bukan SKU-12345678
      if (product.getSku().length() != 12 || !product.getSku().startsWith("SKU-")
          || !product.getSku().matches("^SKU-\\d{8}$")) {
        System.out.println("The sku must be in the format SKU-XXXXXXXX");
        break;
      }

      // productName kosong
      if (product.getProductName() == null || product.getProductName().isEmpty()) {
        System.out.println("The productName is a mandatory field");
        break;
      }

      // quantityInStock negatif
      if (product.getQuantityInStock() < 0) {
        System.out.println("The quantityInStock cannot be negative");
        break;
      }

      // price <= 0
      if (product.getPrice() <= 0) {
        System.out.println("The price must be greater than zero");
        break;
      }

      // category kosong
      if (product.getCategory() == null || product.getCategory().isEmpty()) {
        System.out.println("The category is a mandatory field");
        break;
      }

      // category tidak tersedia
      if (!product.getCategory().equals("Electronics") &&
          !product.getCategory().equals("Books") &&
          !product.getCategory().equals("Apparel") &&
          !product.getCategory().equals("Home Goods")) {
        System.out.println("Invalid product category");
        break;
      }

      else {
        // Lolos Validasi
        isValid = 200;
      }
    }
    return isValid;
  }

}
