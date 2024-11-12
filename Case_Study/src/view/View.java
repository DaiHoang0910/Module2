package view;

import controller.FlowerController;
import controller.FruitController;
import entity.Flower;
import entity.Fruit;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------- Quản lý sản phẩm-hàng hóa --------");
            System.out.println("1. Hiển thị danh sách thông tin sản phẩm-hàng hóa");
            System.out.println("2. Quản lý hàng hóa trái cây");
            System.out.println("3. Quản lý hoa");
            System.out.println("0. Thoát");
            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số.");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("1. Danh sách hàng hóa trái cây");
                    displayFruit();
                    System.out.println("2. Danh sách thông tin hoa");
                    displayFlower();
                    break;
                case 2:
                    menuFruit();
                    break;
                case 3:
                    menuFlower();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    public static void menuFruit() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu quản lý hàng hóa trái cây");
            System.out.println("1. Hiển thị danh sách hàng hóa trái cây");
            System.out.println("2. Thêm mới hàng hóa trái cây");
            System.out.println("3. Sửa thông tin hàng hóa");
            System.out.println("4. Xóa thông tin hàng hóa");
            System.out.println("5. Tìm kiếm hàng hóa theo tên");
            System.out.println("6. Sắp xếp hàng hóa theo giá");
            System.out.println("0. Trở lại menu chính");
            System.out.println("Nhập lựa chọn: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số.");
                continue;
            }
            FruitController fruitController = new FruitController();
            switch (choice) {
                case 1:
                    System.out.println("1. Hiển thị danh sách hàng hóa trái cây");
                    displayFruit();
                    break;
                case 2:
                    System.out.println("Nhập thông tin của hàng hóa trái cây cần thêm mới");
                    int newId;
                    while (true) {
                        try {
                            System.out.println("Nhập id của trái cây cần thêm");
                            newId = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập số.");
                        }
                    }
                    if (!checkIdFruit(newId)) {
                        System.out.println("Nhập tên");
                        String newName = scanner.nextLine();
                        while (isValidName(newName)) {
                            System.out.println("Tên không hợp lệ. Vui lòng nhập lại (chỉ chứa ký tự chữ, khoảng trắng):");
                            newName = scanner.nextLine();
                        }

                        double newPrice;
                        while (true) {
                            try {
                                System.out.println("Nhập giá");
                                newPrice = Double.parseDouble(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Vui lòng nhập số.");
                            }
                        }

                        int newQuantity;
                        while (true) {
                            try {
                                System.out.println("Nhập số lượng");
                                newQuantity = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Vui lòng nhập số.");
                            }
                        }

                        System.out.println("Nhập thông tin xuất xứ");
                        String newOrigin = scanner.nextLine();
                        while (isValidName(newOrigin)) {
                            System.out.println("Thông tin không hợp lệ. Vui lòng nhập lại (chỉ chứa ký tự chữ, khoảng trắng):");
                            newOrigin = scanner.nextLine();
                        }
                        Fruit fruit = new Fruit(newId, newName, newPrice, newQuantity, newOrigin);
                        fruitController.addFruit(checkAddFruit(fruit));
                        System.out.println("Danh sách hàng hóa trái cây sau khi thêm");
                        displayFruit();
                    } else {
                        System.out.println("Sản phẩm thêm mới bị trùng id, vui lòng nhập lại.");
                    }
                    break;
                case 3:
                    System.out.println("Nhập thông tin cần chỉnh sửa cho hàng hóa");
                    int editId;
                    while (true) {
                        try {
                            System.out.println("Nhập id của hàng hóa cần chỉnh sửa");
                            editId = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập số.");
                        }
                    }

                    if (checkIdFruit(editId)) {
                        System.out.println("Nhập tên thay thế");
                        String editName = scanner.nextLine();
                        while (isValidName(editName)) {
                            System.out.println("Tên không hợp lệ. Vui lòng nhập lại (chỉ chứa ký tự chữ, khoảng trắng):");
                            editName = scanner.nextLine();
                        }

                        double editPrice;
                        while (true) {
                            try {
                                System.out.println("Nhập giá thay thế");
                                editPrice = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Vui lòng nhập số.");
                            }
                        }

                        int editQuantity;
                        while (true) {
                            try {
                                System.out.println("Nhập số lượng thay thế");
                                editQuantity = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Vui lòng nhập số.");
                            }
                        }

                        System.out.println("Nhập thông tin xuất xứ thay thế");
                        String editOrigin = scanner.nextLine();
                        while (isValidName(editOrigin)) {
                            System.out.println("Thông tin không hợp lệ. Vui lòng nhập lại (chỉ chứa ký tự chữ, khoảng trắng):");
                            editOrigin = scanner.nextLine();
                        }

                        Fruit editFruit = new Fruit(editId, editName, editPrice, editQuantity, editOrigin);
                        fruitController.editFruit(editFruit);
                        System.out.println("Danh sách hàng hóa trái cây sau khi sửa");
                        displayFruit();
                    } else {
                        System.out.println("Không tồn tại sản phẩm cần chỉnh sửa, vui lòng kiểm tra việc nhập id");
                    }
                    break;
                case 4:
                    System.out.println("Nhập id của hàng hóa cần xóa");
                    int delId;
                    while (true) {
                        try {
                            System.out.println("Nhập id của trái cây cần thêm");
                            delId = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập số.");
                        }
                    }

                    if (checkIdFruit(delId)) {
                        fruitController.deleteFruit(delId);
                        System.out.println("Danh sách hàng hóa trái cây sau khi xóa:");
                        displayFruit();
                    } else {
                        System.out.println("Không tồn tại sản phẩm cần xóa");
                    }
                    break;
                case 5:
                    System.out.println("Nhập tên hàng hóa trái cây cần tìm kiếm");
                    String searchName = scanner.nextLine();
                    while (isValidName(searchName)) {
                        System.out.println("Tên không hợp lệ. Vui lòng nhập lại (chỉ chứa ký tự chữ, khoảng trắng):");
                        searchName = scanner.nextLine();
                    }
                    if (checkNameFruit(searchName)) {
                        List<Fruit> searchFruits = fruitController.searchFruit(searchName);
                        displayFruit(searchFruits);
                    } else {
                        System.out.println("Không tìm thấy thông tin sản phẩm");
                    }
                    break;
                case 6:
                    System.out.println("Sắp xếp hàng hóa theo giá");
                    System.out.println("1. Sắp xếp tăng dần theo giá");
                    System.out.println("2. Sắp xếp giảm dần theo giá");
                    System.out.print("Nhập lựa chọn: ");
                    int sortChoice;
                    try {
                        sortChoice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số.");
                        continue;
                    }
                    List<Fruit> sortedFruit;
                    switch (sortChoice) {
                        case 1:
                            sortedFruit = fruitController.sortFruitAsc();
                            System.out.println("Sản phẩm đã được sắp xếp tăng dần theo giá:");
                            displayFruit(sortedFruit);
                            break;
                        case 2:
                            sortedFruit = fruitController.sortFruitDesc();
                            System.out.println("Sản phẩm đã được sắp xếp tăng dần theo giá:");
                            displayFruit(sortedFruit);
                            break;
                        default:
                            System.out.println("Lựa chọn không phù hợp");
                            break;
                    }
                case 0:
                    return;
                default:
                    System.out.println("Vui lòng nhập lại lựa chọn");
                    break;
            }
        }
    }

    public static void menuFlower() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu quản lý hoa");
            System.out.println("1. Hiển thị danh sách hoa");
            System.out.println("2. Thêm mới hoa");
            System.out.println("3. Sửa thông tin hoa");
            System.out.println("4. Xóa thông tin hoa");
            System.out.println("5. Tìm kiếm hoa theo tên");
            System.out.println("0. Trở lại menu chính ");
            System.out.println("Nhập lựa chọn: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số.");
                continue;
            }
            FlowerController flowerController = new FlowerController();
            switch (choice) {
                case 1:
                    System.out.println("Hiển thị danh sách thông tin hoa");
                    displayFlower();
                    break;
                case 2:
                    System.out.println("Nhập thông tin của hoa cần thêm mới");
                    int newId;
                    while (true) {
                        try {
                            System.out.println("Nhập id của hoa cần thêm");
                            newId = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập số.");
                        }
                    }
                    while (checkIdFlower(newId)) {
                        System.out.println("Thông tin sản phẩm bị trùng id, vui lòng nhập lại");
                        while (true) {
                            try {
                                System.out.println("Nhập id của hoa cần thêm");
                                newId = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Vui lòng nhập số.");
                            }
                        }
                    }
                    System.out.println("Nhập tên");
                    String newName = scanner.nextLine();
                    while (isValidName(newName)) {
                        System.out.println("Tên không hợp lệ. Vui lòng nhập lại (chỉ chứa ký tự chữ, khoảng trắng):");
                        System.out.println("Nhập tên");
                        newName = scanner.nextLine();
                    }

                    double newPrice;
                    while (true) {
                        try {
                            System.out.println("Nhập giá");
                            newPrice = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập số.");
                        }
                    }

                    System.out.println("Nhập màu sắc");
                    String newColor = scanner.nextLine();
                    while (isValidName(newColor)) {
                        System.out.println("Màu sắc nhập không hợp lệ. Vui lòng nhập lại (chỉ chứa ký tự chữ, khoảng trắng):");
                        System.out.println("Nhập màu sắc");
                        newColor = scanner.nextLine();
                    }
                    Flower flower = new Flower(newId, newName, newPrice, newColor);
                    flowerController.addFlower(checkAddFlower(flower));
                    System.out.println("Danh sách hàng hóa trái cây sau khi thêm");
                    displayFlower();
                    break;
                case 3:
                    System.out.println("Nhập thông tin cần chỉnh sửa cho hàng hóa");
                    int checkId;
                    while (true) {
                        try {
                            System.out.println("Nhập id của hàng hóa cần chỉnh sửa");
                            checkId = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập số.");
                        }
                    }

                    while (!checkIdFlower(checkId)) {
                        System.out.println("Sản phẩm không tồn tại, vui lòng kiểm tra lại thông tin và nhập lại:");
                        while (true) {
                            try {
                                System.out.println("Nhập id của hàng hóa cần chỉnh sửa");
                                checkId = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Vui lòng nhập số.");
                            }
                        }
                    }

                    System.out.println("Nhập tên thay thế");
                    String editName = scanner.nextLine();
                    while (isValidName(editName)) {
                        System.out.println("Tên không hợp lệ. Vui lòng nhập lại (chỉ chứa ký tự chữ, khoảng trắng):");
                        System.out.println("Nhập tên thay thế");
                        editName = scanner.nextLine();
                    }

                    double editPrice;
                    while (true) {
                        try {
                            System.out.println("Nhập giá thay thế");
                            editPrice = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập số.");
                        }
                    }

                    System.out.println("Nhập màu sắc thay thế");
                    String editColor = scanner.nextLine();
                    while (isValidName(editColor)) {
                        System.out.println("Màu sắc nhập không hợp lệ. Vui lòng nhập lại (chỉ chứa ký tự chữ, khoảng trắng):");
                        System.out.println("Nhập màu sắc thay thế");
                        editColor = scanner.nextLine();
                    }

                    Flower editFlower = new Flower(checkId, editName, editPrice, editColor);
                    flowerController.editFlower(editFlower);
                    System.out.println("Danh sách hoa sau khi sửa");
                    displayFlower();
                    break;
                case 4:
                    int delId;
                    while (true) {
                        try {
                            System.out.println("Nhập id của hàng hóa cần xóa");
                            delId = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập số.");
                        }
                    }
                    if (!checkIdFlower(delId)) {
                        System.out.println("Không tìm thấy sản phẩm cần xóa.");
                    } else {
                        System.out.println("Bạn có chắc chắn muốn xóa sản phẩm này không (yes or no)?");
                        String del = scanner.nextLine();
                        if (del.equalsIgnoreCase("yes")) {
                            flowerController.deleteFlower(delId);
                            System.out.println("Danh sách hoa sau khi xóa:");
                            displayFlower();
                        } else if (del.equalsIgnoreCase("no")) {
                            System.out.println("Không có thông tin nào bị xóa");
                            displayFlower();
                        } else {
                            System.out.println("Không có câu trả lời xác định. Kết thúc chức năng!");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Nhập tên hoa cần tìm kiếm");
                    String searchName = scanner.nextLine();
                    while (isValidName(searchName)) {
                        System.out.println("Tên không hợp lệ. Vui lòng nhập lại (chỉ chứa ký tự chữ, khoảng trắng):");
                        System.out.println("Nhập tên hoa cần tìm kiếm");
                        searchName = scanner.nextLine();
                    }
                    if (checkNameFlower(searchName)) {
                        List<Flower> searchFlower = flowerController.searchFlower(searchName);
                        displayFlower(searchFlower);
                    } else {
                        System.out.println("Không tìm thấy thông tin sản phẩm");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Vui lòng nhập lại lựa chọn");
                    break;
            }
        }
    }

    public static void displayFruit() {
        FruitController fruitController = new FruitController();
        List<Fruit> fruits = fruitController.getAllFruit();
        displayFruit(fruits);
    }

    public static void displayFruit(List<Fruit> fruits) {
        if (fruits.isEmpty()) {
            System.out.println("Không có sản phẩm nào trong danh sách");
        } else {
            System.out.printf("%-5s %-15s %-15s %-15s %-20s %n", "ID", "Tên", "Giá(vnd)", "Số lượng(kg)", "Xuất xứ");
            System.out.println("-----------------------------------------------------------------------");

            for (Fruit fruit : fruits) {
                System.out.printf("%-5d %-15s %-15s %-15s %-20s %n",
                        fruit.getId(),
                        fruit.getName(),
                        fruit.getPrice(),
                        fruit.getQuantity(),
                        fruit.getOrigin());
            }
        }
    }

    public static void displayFlower() {
        FlowerController flowerController = new FlowerController();
        List<Flower> flowers = flowerController.getAllFlower();
        displayFlower(flowers);
    }

    public static void displayFlower(List<Flower> flowers) {
        if (flowers.isEmpty()) {
            System.out.println("Không có thông tin của hoa nào trong danh sách");
        } else {
            System.out.printf("%-5s %-15s %-15s %-15s %n", "ID", "Tên", "Giá(vnd)", "Màu sắc");
            System.out.println("--------------------------------------------------------");

            for (Flower flower : flowers) {
                System.out.printf("%-5d %-15s %-15s %-15s %n",
                        flower.getId(),
                        flower.getName(),
                        flower.getPrice(),
                        flower.getColor());
            }
        }
    }

    private static Fruit checkAddFruit(Fruit fruit) {
        FruitController controller = new FruitController();
        boolean addProduct = controller.addFruit(fruit);
        if (addProduct) {
            System.out.println("Sản phẩm đã được thêm");
        } else {
            System.out.println("Sản phẩm bị trùng thông tin, vui lòng kiểm tra lại");
        }
        return fruit;
    }

    private static Flower checkAddFlower(Flower flower) {
        FlowerController controller = new FlowerController();
        boolean addProduct = controller.addFlower(flower);
        if (addProduct) {
            System.out.println("Sản phẩm đã được thêm");
        } else {
            System.out.println("Sản phẩm bị trùng thông tin, vui lòng kiểm tra lại");
        }
        return flower;
    }

    public static boolean checkIdFlower(int checkId) {
        FlowerController flowerController = new FlowerController();
        List<Flower> flowers = flowerController.getAllFlower();
        for (Flower flower1 : flowers) {
            if (flower1.getId() == checkId) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkNameFlower(String checkName) {
        FlowerController flowerController = new FlowerController();
        List<Flower> flowers = flowerController.getAllFlower();
        for (Flower flower1 : flowers) {
            if (Objects.equals(flower1.getName(), checkName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIdFruit(int checkId) {
        FruitController fruitController = new FruitController();
        List<Fruit> fruits = fruitController.getAllFruit();
        for (Fruit fruit : fruits) {
            if (fruit.getId() == checkId) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkNameFruit(String checkName) {
        FruitController fruitController = new FruitController();
        List<Fruit> fruits = fruitController.getAllFruit();
        for (Fruit fruit : fruits) {
            if (Objects.equals(fruit.getName(), checkName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidName(String name) {
        String regex = "^[a-zA-z\\s]+$";
        return !name.matches(regex);
    }
}
