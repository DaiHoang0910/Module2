package test.view;

import test.controller.ProductController;
import test.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        ProductController controller = new ProductController();
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu quản lý sản phẩm");
        System.out.println("1. Hiển thị danh sách sản phẩm");
        System.out.println("2. Thêm mới sản phẩm");
        System.out.println("3. Sửa thông tin sản phẩm theo id");
        System.out.println("4. Xóa sản phẩm theo id");
        System.out.println("5. Tìm kiếm sản phẩm theo tên");
        System.out.println("6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá");
        System.out.println("0. Thoát khỏi menu");
        System.out.println("Nhập lựa chọn: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Hiển thị danh sách sản phẩm");
                displayProducts();
                break;
            case 2:
                System.out.println("Thêm mới sản phẩm");
                System.out.println("Nhập thông tin sản phẩm mới");
                System.out.println("Nhập ID sản phẩm: ");
                int newId = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhập tên sản phẩm: ");
                String newName = sc.nextLine();
                System.out.println("Nhập giá sản phẩm: ");
                double newPrice = sc.nextDouble();
                Product product = new Product(newId, newName, newPrice);
                controller.addProduct(checkAdd(product));
                System.out.println("Hiển thị danh sách sản phẩm");
                displayProducts();
                break;
            case 3:
                System.out.println("Sửa thông tin sản phẩm theo id");
                System.out.println("Nhập thông tin sản phẩm cần sửa: ");
                System.out.println("Nhập ID sản phẩm cần sửa: ");
                int editId = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhập tên sản phẩm cần sửa: ");
                String editName = sc.nextLine();
                System.out.println("Nhập giá sản phẩm cần sửa: ");
                double editPrice = sc.nextDouble();
                Product productEdit = new Product(editId, editName, editPrice);
                boolean checkEdit = controller.editProduct(productEdit);
                if (checkEdit) {
                    System.out.println("Sản phẩm đã được sửa");
                    System.out.println(productEdit);
                    System.out.println("Cập nhật danh sách");
                    displayProducts();
                }
                break;
            case 4:
                System.out.println("Xóa sản phẩm theo id");
                System.out.println("Nhập ID sản phẩm cần xóa: ");
                int deleteId = sc.nextInt();
                boolean checkDel = controller.deleteProduct(deleteId);
                if (checkDel) {
                    System.out.println("Sản phẩm đã được xóa");
                    System.out.println("Cập nhật danh sách");
                    displayProducts();
                }
                break;
            case 5:
                System.out.println("Tìm kiếm sản phẩm theo tên");
                sc.nextLine();
                System.out.println("Nhập tên sản phẩm cần tìm: ");
                String nameSearch = sc.nextLine();
                List<Product> searchResult = controller.searchProduct(nameSearch);
                for (Product product1 : searchResult) {
                    System.out.println(product1);
                }
                break;
            case 6:
                System.out.println("Sắp xếp sản phẩm tăng dần, giảm dần theo giá");
                System.out.println("1. Sắp xếp tăng dần theo giá");
                System.out.println("2. Sắp xếp giảm dần theo giá");
                System.out.print("Nhập lựa chọn: ");
                int sortChoice = sc.nextInt();
                List<Product> sortedProduct;
                switch (sortChoice) {
                    case 1:
                        sortedProduct = controller.sortProductAsc();
                        System.out.println("Sản phẩm đã được sắp xếp tăng dần theo giá:");
                        for (Product product1 : sortedProduct) {
                            System.out.println(product1);
                        }
                        break;
                    case 2:
                        sortedProduct = controller.sortProductDes();
                        System.out.println("Sản phẩm đã được sắp xếp giảm dần theo giá:");
                        for (Product product1 : sortedProduct) {
                            System.out.println(product1);
                        }
                        break;
                    default:
                        System.out.println("Lựa chọn không phù hợp");
                }
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Lựa chọn không phù hợp");
        }
    }

    private static void displayProducts() {
        ProductController controller = new ProductController();
        List<Product> products = controller.getAll();
        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm nào trong danh sách");
        } else {
            System.out.printf("%-5s %-20s %-10s %n", "ID", "Name", "Price");
            System.out.println("--------------------------------------------------");
            for (Product product : products) {
                System.out.printf("%-5d %-20s %-10.2f %n",
                        product.getId(),
                        product.getName(),
                        product.getPrice());
            }
        }
    }

    private static Product checkAdd(Product product) {
        ProductController controller = new ProductController();
        boolean addProduct = controller.addProduct(product);
        if (addProduct) {
            System.out.println("Sản phẩm đã được thêm");
        } else {
            System.out.println("Sản phẩm bị trùng thông tin, vui lòng kiểm tra lại");
        }
        return product;
    }
}
