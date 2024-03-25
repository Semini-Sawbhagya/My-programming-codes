import java.io.*;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;


class itemCodeNotFoundException extends Exception {
    public itemCodeNotFoundException(String message) {
        super(message);
    }
}
class GroceryItem implements Serializable {
    String item_code;
    String item_name;
    String  weight;
    double price;
    String dateM;
    String dateE;
    String manufacturesName;
    double discount;

    GroceryItem(String item_code,String  item_name, String weight, double price,  String dateM, String dateE, String manufacturesName,double discount) {
        this.item_code = item_code;
        this.item_name=item_name;
        this.price = price;
        this.weight = weight;
        this.dateM = dateM;
        this.dateE = dateE;
        this.manufacturesName = manufacturesName;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item name: "+item_name+"\n");
        sb.append("Price: "+price+"\n");
        sb.append("Weight: "+weight+"\n");
        sb.append("Manufactured date: "+dateM+"\n");
        sb.append("Expire date:"+dateE+"\n");
        sb.append("Manufacturer's name:"+manufacturesName+"\n");

        return sb.toString();
    }
    public String getItemCode() {
        return this.item_code;
    }
    public double getPrice(){
        return this.price;
    }
    public void  setPrice(double price){
        this.price=price;
    }
    public String  getWeight(){
        return this.weight;
    }
    public void setWeight(String weight){
        this.weight=weight;
    }

    public String getManufacturesName(){
        return this.manufacturesName;
    }
    public void setManufacturesName(String ManufacturesName){
        this.manufacturesName=ManufacturesName;
    }
    public String getDateM(){
        return this.dateM;
    }
    public void setDateM(String dateM){
        this.dateM=dateM;
    }
    public String getDateE(){
        return this.dateE;
    }
    public void setDateE(String dateE){
        this.dateE=dateE;
    }
    public double getDiscount(){
        return this.discount;
    }
    public void setDiscount(double discount){
        this.discount=discount;
    }

    public static GroceryItem getItemObject(String idd, GroceryItem[] arr) {
        int n = getIndex(idd, arr);
        return arr[n];
    }

    public static int getIndex(String idd, GroceryItem[] arr) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            if (idd.equals(arr[i].getItemCode())) {
                n = i;
                break;
            }
        }
        return n;
    }
}


class Bill implements Serializable {
    private String  cashier;
    private String branch;
    private String  customer;
    private ArrayList<GroceryItem> itemList;
    private double totalDiscount;
    private double totalPrice;
    private Date dateAndTime;

    public Bill(String cashier, String branch, String customer,ArrayList<GroceryItem>tr,double totalPrice) {
        this.cashier = cashier;
        this.branch = branch;
        this.customer = customer;
        this.itemList = tr;
        this.totalDiscount = 0;
        this.totalPrice = totalPrice;
        this.dateAndTime = new Date(); // Initialize with current date and time
    }
    public Bill(String  cashier, String branch,ArrayList<GroceryItem>tr) {
        this.cashier = cashier;
        this.branch = branch;
        this.itemList = tr;
        this.totalDiscount = 0;
        this.totalPrice = 0;
        this.dateAndTime = new Date(); // Initialize with current date and time
    }
    public ArrayList<GroceryItem> getItems() {
        return new ArrayList<>(itemList); // Return a copy to prevent modification of original list
    }
    public void setTotalPrice(double val){
        this.totalPrice=val;
    }

    // Getters and Setters for all fields

    public void addItem(GroceryItem item, int quantity) {
        itemList.add(item);
        totalPrice += (item.getPrice() - item.getDiscount()) * quantity;
        totalDiscount += item.getDiscount() * quantity;
    }



    @Override
    public String toString() {
        System.out.println("\t\tWelcome to Super-Saving supermarket");
        StringBuilder sb = new StringBuilder();
        sb.append("Cashier: "+cashier+"\n");
        sb.append("Branch: "+branch+"\n");
        sb.append("Customer: "+(customer != null ? customer : "Guest")+"\n");
        sb.append("Date and Time: "+dateAndTime+"\n");
        sb.append("Items:\n");
        for (GroceryItem item : itemList) {
            sb.append(item.toString()+"\n");
        }
        sb.append("Total Price: "+totalPrice+"\n");
        sb.append("Total Discount: "+totalDiscount+"\n");
        return sb.toString();
    }
}


class POS implements Serializable {
    private Bill bill;
    POS(){
        this.bill=null;
    }
    public Bill getBill(){
        return bill;
    }
    public void setBill(Bill bill){
        this.bill=bill;
    }

    GroceryItem arr[]={new GroceryItem("10073","Cream Soda","1.5l",650.00,"13/09/2022","13/09/2024","John Keells",0.0),new GroceryItem("10074","Pepsi Cola","1.5l",550.00,"12/04/2022","12/04/2024","Elephant House",0.0),new GroceryItem("10075","Brown Sugar","1kg",250.00,"20/02/2023","20/04/2024","Jihn Keells",0.0),new GroceryItem("10076","White Rice","5kg",1750.00,"12/01/2024","12/09/2024","araliya Sahal",0.0),new GroceryItem("1077","Tea Leaves","750g",750.00,"01/09/2022","01/09/2024","Watawala",0.0),new GroceryItem("10078","Magi Noodles","500g",650.00,"15/09/2022","15/09/2024","Prima",0.0),new GroceryItem("10079","Chicken","1kg",1650.00,"22/02/2024","22/04/2024","Prima",0.0),new GroceryItem("10080","Chocolate Slab","200g",650.00,"17/09/2022","17/09/2024","Kandos",0.0)};
    public ArrayList<GroceryItem> getItemDetails() {
        ArrayList <GroceryItem>brr=new ArrayList<>();
        try {

            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            String line;
            while ((line = br.readLine()) != null) {
                String item_code = br.readLine();
                GroceryItem item = GroceryItem.getItemObject(item_code, arr);
                // Fetch item details from the database
                brr.add(item);
                br.close();
                r.close();
                if (item == null) {
                    throw new itemCodeNotFoundException("Item code not found. Please re-enter.");
                }
                return brr;
            }
        } catch(IOException e){
            e.printStackTrace();
        } catch(itemCodeNotFoundException e){
            throw new RuntimeException(e);
        }
        return null;
    }
    // Method to serialize a Bill object and save it to a file
    public void saveBillToFile(Bill bill, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(bill);
            System.out.println("Bill saved successfully to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving bill: " + e.getMessage());
        }
    }

    // Method to deserialize a Bill object from a file
    public Bill loadBillFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Bill bill = (Bill) in.readObject();
            System.out.println("Bill loaded successfully from " + filename);
            return bill;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading bill: " + e.getMessage());
            return null;

        }
    }
    public double calculateTotalPrice(ArrayList<GroceryItem>items) {
        double total_amount = 0;
        for (int i = 0; i <(int)items.size() ; i++) {
            total_amount+= items.get(i).getPrice();
        }
        return total_amount;
    }

    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        POS pp= new POS();
        System.out.println("Do you need to add new customer bill?(y/n)");
        String sss = input.next();
        if (sss.equals("y")) {
            System.out.println("Enter the cashier's name :");
            String caname=input.next();
            System.out.println("Enter the customer name  :");
            String cuname=input.next();
            System.out.println("Enter the branch  :" );
            String branch=input.next();
            ArrayList<GroceryItem>ar=pp.getItemDetails();
            double total_amount= pp.calculateTotalPrice(ar);
            Bill bill=new Bill(caname,cuname,branch,ar,total_amount);
            pp.setBill(bill);
            System.out.println("If the billing finish? (y/n) :");
            if (sss.equals("y")) {
                System.out.println(bill);
            }else {
                System.out.println("Enter pending Bill file name  :");
                String ss=input.next();
                File f=new File(ss);
                pp.saveBillToFile(bill,ss);
            }

        } else {
            System.out.println("Enter pending Bill file name  :");
            String ss=input.next();
            Bill bill=pp.loadBillFromFile(ss);

            System.out.println("Do you need to finish the billing ?(y/n)");
            if (sss.equals("y")) {
                System.out.println(bill);
            }else{
                ArrayList<GroceryItem>ar=pp.getItemDetails();
                bill.getItems().addAll(ar);
                double total_amount= pp.calculateTotalPrice(ar);
                bill.setTotalPrice(total_amount);
                System.out.println(bill);
            }
        }

    }
}
