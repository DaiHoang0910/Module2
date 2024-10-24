package bai_tap.arraylist;

import java.util.Scanner;


public class View {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        manager.addProduct(new Product(1, "Pineapple", 10));
        manager.addProduct(new Product(2, "Banana", 8));
        manager.addProduct(new Product(3, "Apple", 6));
        manager.addProduct(new Product(4, "Orange", 6));
        manager.addProduct(new Product(5, "Mango", 7));

        Scanner sc = new Scanner(System.in);
        System.out.println("Menu quản lý sản phẩm");
        System.out.println("1. Hiển thị danh sách sản phẩm");
        System.out.println("2. Thêm mới sản phẩm");
        System.out.println("3. Sửa thông tin sản phẩm theo id");
        System.out.println("4. Xóa sản phẩm theo id");
        System.out.println("5. Tìm kiếm sản phẩm theo tên");
        System.out.println("6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá");
        System.out.println("Nhập lựa chọn: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Hiển thị danh sách sản phẩm");
                manager.displayProducts();
                break;
            case 2:
                System.out.println("Thêm mới sản phẩm");
                break;
            case 3:
                System.out.println("Sửa thông tin sản phẩm theo id");
                break;
            case 4:
                System.out.println("Xóa sản phẩm theo id");
                break;
            case 5:
                System.out.println("Tìm kiếm sản phẩm theo tên");
                break;
            case 6:
                System.out.println("Sắp xếp sản phẩm tăng dần, giảm dần theo giá");
                break;
            default:
                System.out.println("Lựa chọn không xác định");
        }
    }
}
