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
                List<Product> products = controller.getAll();
                for (Product product : products) {
                    System.out.println(product);
                }
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
                controller.addProduct(newId, newName, newPrice);
                System.out.println("Hiển thị danh sách sản phẩm");
                List<Product> productsAdd = controller.getAll();
                for (Product product : productsAdd) {
                    System.out.println(product);
                }
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
                controller.editProduct(editId, editName, editPrice);
                List<Product> productsEdit = controller.getAll();
                for (Product product : productsEdit) {
                    System.out.println(product);
                }
                break;
            case 4:
                System.out.println("Xóa sản phẩm theo id");
                System.out.println("Nhập ID sản phẩm cần xóa: ");
                int deleteId = sc.nextInt();
                controller.deleteProduct(deleteId);
                List<Product> productsRemove = controller.getAll();
                for (Product product : productsRemove) {
                    System.out.println(product);
                }
                break;
            case 5:
                System.out.println("Tìm kiếm sản phẩm theo tên");
                sc.nextLine();
                System.out.println("Nhập tên sản phẩm cần tìm: ");
                String nameSearch = sc.nextLine();
                List<Product> searchResult = controller.searchProduct(nameSearch);
                for (Product product : searchResult) {
                    System.out.println(product);
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
                        for (Product product : sortedProduct) {
                            System.out.println(product);
                        }
                        break;
                    case 2:
                        sortedProduct = controller.sortProductDes();
                        System.out.println("Sản phẩm đã được sắp xếp giảm dần theo giá:");
                        for (Product product : sortedProduct) {
                            System.out.println(product);
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
}
