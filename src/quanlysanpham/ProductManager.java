package quanlysanpham;

import readandwritefile.ReadAndWriteFile;

import java.util.ArrayList;

public class ProductManager {
    ArrayList<Product> list = new ArrayList<>();
    private ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();

    public ProductManager() {
        this.list = readAndWriteFile.readFile();
    }
    public void addProduct(Product product) {
        this.list.add(product);
        readAndWriteFile.WriteFile(list);
    }
    public void editProduct(int id, Product product) {
        int index = findIndexById(id);
        list.set(index, product);
    }

    public void deleteProduct(int id) {
        int index = findIndexById(id);
        this.list.remove(index);
    }

    public int findIndexById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if(id==list.get(i).getId()){
                return i;
            }
        }
        return -1;
    }
    public ArrayList<Product> findAll() {
        return list;
    }
    public Product searchId(int id) {
        for (Product product: list) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    public Product maxMoney() {
        Product max = list.get(0);
        for (Product product: list) {
            if (product.getPrice() > max.getPrice()) {
                max = product;
            }
        }
        return max;
    }
    public void sortIncreaseProduct() {
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i; j++) {
                if (list.get(j).getPrice() > list.get(j + 1).getPrice()) {
                    Product temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        for (Product product : list) {
            System.out.println(product);
        }
    }
}
