package ra.run;

import ra.businessImp.Product;

import java.util.*;

public class ProductManagement {
    private static List<Product> productList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số sản phẩm và nhập thông tin sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm");
            System.out.println("7. Thoát");
            System.out.print("Mời bạn nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputProducts();
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    sortProductsByProfit();
                    break;
                case 4:
                    deleteProductById();
                    break;
                case 5:
                    searchProductByName();
                    break;
                case 6:
                    changeProductStatusById();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    private static void inputProducts() {
        System.out.print("Nhập số sản phẩm cần nhập thông tin: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin cho sản phẩm thứ " + (i + 1) + ":");
            Product product = new Product();
            product.inputData();
            productList.add(product);
        }
    }

    private static void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách rỗng");
            return;
        }
        System.out.println("Danh sách sản phẩm:");
        for (Product product : productList) {
            product.displayData();
        }

    }

    private static void sortProductsByProfit() {
        Collections.sort(productList);
        System.out.println("Đã sắp xếp sản phẩm theo lợi nhuận tăng dần.");
        displayProducts();
//        productList.sort(Comparator.comparingDouble(Product::getInterest));
    }

    private static void deleteProductById() {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        int productId = Integer.parseInt(scanner.nextLine());
        for (Product product : productList) {
            if (product.getProductId() == productId) {
                productList.remove(product);
                System.out.println("Đã xóa sản phẩm có mã " + productId);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã " + productId);
    }

    private static void searchProductByName() {
        System.out.print("Nhập tên sản phẩm cần tìm kiếm: ");
        String productName = scanner.nextLine();
//        productList.stream().filter(t -> t.getProductName().toLowerCase().contains(productName.toLowerCase())).forEach(Product::displayData);
        for (Product product : productList) {
            if (product.getProductName().contains(productName)) {
                product.displayData();
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có tên " + productName);
    }

    private static void changeProductStatusById() {
        System.out.print("Nhập mã sản phẩm cần thay đổi trạng thái: ");
        int productId = Integer.parseInt(scanner.nextLine());
        for (Product product : productList) {
            if (product.getProductId() == productId) {
                product.setProductStatus(!product.isProductStatus());
                System.out.println("Đã thay đổi trạng thái của sản phẩm có mã " + productId);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã " + productId);
    }
}
