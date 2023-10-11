package view;

import quanlysanpham.Product;
import quanlysanpham.ProductManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    ProductManager productManager = new ProductManager();
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    public void showMenu() {
        int btn;
        do {
            System.out.println("=-=-MENU-=-=");
            System.out.println("Nhập số theo bảng");
            System.out.println("*1. --Xem danh sách. \n" +
                    "*2. --Thêm mới. \n" +
                    "*3. --Cập nhật. \n" +
                    "*4. --Xóa. \n" +
                    "*5. --Sắp xếp. \n" +
                    "*6. --Tìm kiếm sản phẩm đắt nhất. \n" +
                    "*0. --Thoát khỏi chương trình.");
            try{
                btn = inputInt.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(" hãy nhập số");
                inputInt.nextLine();
                btn = -1;
            }
            switch (btn) {
                case 1:
                    showAllProduc();
                    break;
                case 2:
                    addProduc();
                    break;
                case 3:
                    editProduc();
                    break;
                case 4:
                    deleteProduc();
                    break;
                case 5:
                    Arreary();
                    break;
                case 6:
                    Max();
                    break;
            }
        } while (btn != 0);
    }

    public void addProduc() {
        System.out.println(" Nhập tên sản phẩm");
        String nameAdd = inputString.nextLine();
        try {
            System.out.println("Số lượng sản phẩm ");
            int quantityAdd = inputInt.nextInt();
            System.out.println("Giá tiền sản phẩm");
            int priceAdd = inputInt.nextInt();
            System.out.println("Loại sản phẩm");
            String describeAdd = inputString.nextLine();
            Product product = new Product(nameAdd, quantityAdd, priceAdd, describeAdd);
            productManager.addProduct(product);
        } catch (InputMismatchException t) {
            System.out.println(" cấm nhập chữ vào !! ");
            inputInt.nextLine();
        }
    }
    public void deleteProduc() {
        try {
            System.out.println(" Nhập mã sản phẩm bạn muốn xóa");
            int idDelete = inputInt.nextInt();
            productManager.deleteProduct(idDelete);
            System.out.println(" xóa thành công !");
        } catch (InputMismatchException a) {
            System.out.println("Không được nhập chữ !");
        }

    }
    public void showAllProduc() {
        ArrayList<Product> list = productManager.findAll();
        for (Product product: list) {
            System.out.println(product);
        }
    }
    public void editProduc() {
        try {
            System.out.println("Nhập mã bạn muốn cập nhật ");
            int idEdit = inputInt.nextInt();
            System.out.println("Cập nhật tên sản phẩm ");
            String nameEdit = inputString.nextLine();
            System.out.println("Cập nhật số lượng sản phẩm");
            int quantityAdd = inputInt.nextInt();
            System.out.println("Cập nhật giá tiền ");
            int priceEdit = inputInt.nextInt();
            System.out.println("Cập nhật mô tả sản phẩm");
            String describeEdit = inputString.nextLine();
            Product product = new Product(idEdit, nameEdit, quantityAdd, priceEdit, describeEdit);
            productManager.editProduct(idEdit, product);
        } catch (InputMismatchException j) {
            System.out.println(" cấm nhập chữ !!");
        }
    }
    public void Max() {
        System.out.println(productManager.maxMoney());
    }
    public void Arreary() {
        productManager.sortIncreaseProduct();
    }
}
