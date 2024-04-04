
package ra.businessImp;

import ra.business.design.IProduct;

import java.util.Scanner;

public class Product implements IProduct,Comparable<Product>{
    static int nextId = 1;
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean productStatus;

    public Product() {
        productId = nextId++;
    }

    public Product(int productId, String productName, String title, String descriptions, float importPrice, float exportPrice, float interest, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
        this.interest = interest;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("mời bạn nhập tên sản phẩm");
        this.productName = scanner.nextLine();
        System.out.println("mời bạn nhập tiêu đề sản phẩm");
        this.title = scanner.nextLine();
        System.out.println("mời bạn nhập mô tả sản phẩm");
        this.descriptions = scanner.nextLine();
        System.out.println("mời bạn nhập giá nhập sản phẩm");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("mời bạn nhập giá xuất sản phẩm");
        this.exportPrice = Float.parseFloat(scanner.nextLine());
        this.interest = this.exportPrice - this.importPrice;
        System.out.println("mời bạn nhập trạng thái sản phẩm(true/false)");
        this.productStatus = Boolean.parseBoolean(scanner.nextLine());


    }

    @Override
    public void displayData() {
        System.out.printf("| ProductID: %d | ProductName: %s | Title: %s | Descriptions: %s | ImportPrice: %.2f| ExportPrice: %.2f| Interest: %.2f| productStatus: %s|\n",
                this.productId, this.productName, this.title, this.descriptions, this.importPrice, this.exportPrice, this.interest, (this.productStatus ? "Hoạt động" : "Không hoạt động"));
        System.out.println("=====================================================================================================================");

    }

    @Override
    public int compareTo(Product o) {
        return Float.compare(this.interest,o.getInterest());
    }
}
