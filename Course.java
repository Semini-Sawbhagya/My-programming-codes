
import javax.swing.plaf.IconUIResource;
import java.util.*;
class Student{
    String name;
    String id;
    int pfm;
    int data;
    public static  boolean isExists(String idd,Student []arr){

        int count=0;
        for(int i=0;i<arr.length;i++){
            if(idd.equals(arr[i].id)){
                count++;
            }
        }
        if(count>0) return true;
        else{
            return false;
        }
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }
    public  static Student[] extend_Array(Student arr[]){
        Student []temp=new Student[arr.length+1];
        for(int j=0;j<arr.length;j++){
            temp[j]=arr[j];
        }
        return temp;

    }
    public static void Add_New_Student(){
        Scanner input=new Scanner(System.in);
        clearConsole();
        System.out.println("        -------------------------------------         ");
        System.out.println("      |             ADD NEW STUDENT          |          ");
        System.out.println("        -------------------------------------         ");
        System.out.println("");
        do{
            Course.arr=extend_Array(Course.arr);
            int l=Course.arr.length-1;
            Course.arr[l]=new Student();
            System.out.print("Enter student ID   :");
            String idd=input.nextLine();
            if (isExists(idd,Course.arr)){
                System.out.println("The Student ID already exists");
                Student []temp=new Student[Course.arr.length-1];
                for (int i = 0; i <Course.arr.length-1; i++) {
                    temp[i]=Course.arr[i];
                }
                Course.arr=temp;
                continue;
            }
            Course.arr[l]=new Student();
            Course.arr[l].id=idd;
            System.out.print("Enter student Name  :");
            String n=input.nextLine();
            Course.arr[l].name=n;
            Course.arr[l].pfm=-1;
            Course.arr[l].pfm=-1;
            System.out.println("");
            System.out.print("Student has been added successfully.Do you want to add a new student(y/n):");
            String ss=input.nextLine();
            if (ss.equals("y")){
                Add_New_Student();
            }break;
        }while(true);
    }
    public static void  Add_New_Student_With_Marks( ){
        Scanner input=new Scanner(System.in);
        do{
            clearConsole();
            System.out.println("             ------------------------------------------         ");
            System.out.println("             |           ADD NEW STUDENT WITH MARKS   |              ");
            System.out.println("             ------------------------------------------         ");
            System.out.println(" ");
            Course.arr=extend_Array(Course.arr);
            int l=Course.arr.length-1;
            Course.arr[l]=new Student();
            System.out.print("Enter student ID   :");
            String idd=input.nextLine();
            if (isExists(idd,Course.arr)){
                System.out.println("The Student ID already exists");
                Student []temp=new Student[Course.arr.length-1];
                for (int i = 0; i <Course.arr.length-1; i++) {
                    temp[i]=Course.arr[i];
                }
                Course.arr=temp;
                continue;
            }

            Course.arr[l]=new Student();
            Course.arr[l].id=idd;
            System.out.print("Enter student Name  :");
            String na=input.nextLine();
            Course.arr[l].name=na;
            System.out.println("");
            int p=0;
            int d=0;
            while(p==0){
                System.out.print("Programming Fundamental Marks :");
                int pf=input.nextInt();
                input.nextLine();
                if (!(0<=pf && pf<=100)){
                    System.out.println("Invalid Marks, Please enter the correct marks.");
                    continue;
                }else {
                    Course.arr[l].pfm=pf;
                    p =1;
                }
            }
            while(d==0){
                System.out.print("Database Management System Marks :");
                int db=input.nextInt();
                input.nextLine();
                if (!(0<=db && db<=100)){
                    System.out.println("Invalid Marks, Please enter the correct marks.");
                    continue;
                }else {
                   Course. arr[l].data=db;
                    d =1;
                }
            }
            System.out.print("\nStudent has been added successfully.Do you want to add a new student(y/n):");
            String sss=input.nextLine();

            if (sss.equals("y")){
                Add_New_Student_With_Marks();
            }else break;
        }while(true);

    }
    public static int getIndex(String idd,Student[]arr) {
        int n=0;
        for (int i = 0; i < arr.length; i++) {
            if(idd.equals(arr[i].id)){
                n=i;
                break;
            }
        }
        return n;
    }
    public static void add_marks(){
        Scanner input=new Scanner (System.in);
        do {
            clearConsole();
            System.out.println("        ------------------------------------------         ");
            System.out.println("        |                  ADD MARKS              |");
            System.out.println("        ------------------------------------------         ");
            System.out.println("");
            System.out.print("Enter Student ID  :");
            String idd = input.next();
            int k = getIndex(idd, Course.arr);
            if (!isExists(idd,Course. arr)) {
                System.out.println("Invalid Student ID. Do you want to search again?(y/n)");
                continue;
            } else {

                System.out.println("Student name  :" + Course.arr[k].name+'\n');
            }
            if(Course.arr[k].pfm!=-1) {
                System.out.println("This student's marks have been already added.\nIf you want to update the marks,please use [4] Update Marks option");
                System.out.println("");
                System.out.print("Do you want to add marks for another student?(y/n) ");
                String sss = input.next();
                if (sss.equals("y")) {
                    continue;
                } else {
                    break;
                }
            }

            int p = 0;
            int d = 0;
            while (p == 0) {
                System.out.print("Programming Fundamental Marks :");
                int pf = input.nextInt();
                input.nextLine();
                if (!(0 <= pf && pf <= 100)) {
                    System.out.println("Invalid Marks, Please enter the correct marks.");
                    continue;
                } else {
                    Course.arr[k].pfm = pf;
                    p = 1;
                }
            }
            while (d == 0) {
                System.out.print("Database Management System Marks :");
                int db = input.nextInt();
                input.nextLine();
                if (!(0 <= db && db <= 100)) {
                    System.out.print("Invalid Marks, Please enter the correct marks.");
                    continue;
                } else {
                    Course.arr[k].data = db;
                    d = 1;
                }
            }
            System.out.println("Marks have been added.Do you want to add marks for another student(y/n)");
            String sss = input.next();

            if (sss.equals("y")) {
                continue;
            } else {
                break;
            }
        }while(true);
    }
    public static void Update_Student_Details(){
        Scanner input=new Scanner (System.in);
        do {
            clearConsole();
            System.out.println("                -------------------------------------------------------");
            System.out.println("                                 UPDATE STUDENT DETAILS                ");
            System.out.println("                -------------------------------------------------------\n");
            System.out.print("Enter Student ID  :");
            String idd = input.next();
            int k = getIndex(idd,Course. arr);
            if (!isExists(idd, Course.arr)) {
                System.out.println("Invalid Student ID. Do you want to search again?(y/n)");
                continue;
            } else {

                System.out.println("Student name  :" + Course.arr[k].name + '\n');
            }
            System.out.print("Enter the new student name :");
            String bb = input.nextLine();
            Course.arr[k].name=bb;
            System.out.println("\nStudent details has been updated successfully.\nDo you want to update another student's details?(y/n) ");
            String sss=input.next();
            if (sss.equals("y")) {
                continue;
            } else {
                break;
            }
        }while(true);

    }
    public static void update_mark(){
        Scanner input=new Scanner (System.in);
        do {
            clearConsole();
            System.out.println("                -------------------------------------------------");
            System.out.println("                |                 UPDATE MARKS                   |");
            System.out.println("                -------------------------------------------------\n");
            System.out.print("Enter Student ID  :");
            String idd = input.next();
            int k = getIndex(idd, Course.arr);
            if (!isExists(idd, Course.arr)) {
                System.out.println("Invalid Student ID. Do you want to search again?(y/n)");
                continue;
            } else {

                System.out.println("Student name  :" + Course.arr[k].name + '\n');
            }
            System.out.print("Enter new Programming Fundamental Marks   :"+Course.arr[k].pfm);
            System.out.println("Enter new Database Management System Marks  :"+Course.arr[k].data+"\n");

            int p = 0;
            int d = 0;
            while (p == 0) {
                System.out.print("Enter new Programming Fundamental Marks :");
                int pf = input.nextInt();
                input.nextLine();
                if (!(0 <= pf && pf <= 100)) {
                    System.out.println("Invalid Marks, Please enter the correct marks.");
                    continue;
                } else {
                    Course.arr[k].pfm = pf;
                    p = 1;
                }
            }
            while (d == 0) {
                System.out.print("Enter new Database Management System Marks :\n");
                int db = input.nextInt();
                input.nextLine();
                if (!(0 <= db && db <= 100)) {
                    System.out.print("Invalid Marks, Please enter the correct marks.\n");
                    continue;
                } else {
                    Course.arr[k].data = db;
                    d = 1;
                }
            }
            System.out.print("Marks have been updated successfully.\nDo you want to update marks for another student?(y/n)");
            String sss=input.nextLine();
            if (sss.equals("y")) {
                continue;
            } else {
                break;
            }
        }while(true);

    }
    public static  void delete_student(){
        Scanner input=new Scanner (System.in);
        do {
            clearConsole();
            System.out.println("               --------------------------------------------------------");
            System.out.println("               |                    DELETE STUDENT                    | ");
            System.out.println("               --------------------------------------------------------\n");
            System.out.print("Enter Student ID  :");
            String idd = input.next();
            int k = getIndex(idd, Course.arr);
            if (!isExists(idd,Course.arr)) {
                System.out.println("Invalid Student ID. Do you want to search again?(y/n)");
                continue;
            } else {
                Student[]temp=new Student[Course.arr.length-1];
                int count=0;
                for (int i = 0; i <Course.arr.length; i++) {
                    if(i==k){
                        continue;
                    }
                    temp[count]=Course.arr[i];
                    count++;
                }
                Course.arr=temp;
                System.out.println("Student has been deleted successfully.\nDo you want to delete another student?(y/n)");
                String sss=input.next();
                if (sss.equals("y")) {
                    continue;
                } else {
                    break;
                }
            }
        }while(true);
    }
    public static String  find_Rank(int k){
        int rank=-1;
        int []total=new int[Course.arr.length];
        for (int i = 0; i <Course.arr.length ; i++) {
            total[i]=Course.arr[i].pfm+Course.arr[i].data;
        }
        int[]temp=new int[total.length];
        for (int i = 0; i <temp.length; i++) {
            temp[i]=total[i];
        }
        Arrays.sort(temp);
        for (int i = 0; i < total.length; i++) {
            if(total[k]==temp[i]){
                rank=temp.length-i;
                break;
            }
        }
        switch (rank){
            case(1):return ("1(First)");
            case(2):return("2(Second)");
            case(3):return("3(Third)");
        }return rank+"";
    }
    public  static void print_student_details(){
        Scanner input=new Scanner (System.in);
        do {
            clearConsole();
            System.out.println("----------------------------------------------------");
            System.out.println("|              PRINT STUDENT DETAILS               |");
            System.out.println("----------------------------------------------------");
            System.out.println("");
            System.out.print("Enter Student ID  :");
            String idd = input.next();
            int k = getIndex(idd, Course.arr);
            if (!isExists(idd, Course.arr)) {
                System.out.println("Invalid Student ID. Do you want to search again?(y/n)");
                continue;
            } else {
                System.out.println("Student name  :" + Course.arr[k].name + '\n');
            }
            if(Course.arr[k].pfm==-1) {
                System.out.print("Marks yet to be  added.\nDo you want to search another student details?(y/n)");

                String sss = input.next();
                if (sss.equals("y")) {
                    continue;
                } else {
                    break;
                }
            }
            System.out.printf("+------------------------------------------+------------+%n");
            System.out.printf("| %-40s | %10d |%n","Programming Fundamentals Marks",Course.arr[k].pfm);
            System.out.printf("| %-40s | %10d |%n","Database Management System Marks",Course.arr[k].data);
            System.out.printf("| %-40s | %10d |%n","Total Marks",((Course.arr[k].pfm+Course.arr[k].data)));
            System.out.printf("| %-40s | %10f |%n","Avg. Marks",((double)(Course.arr[k].pfm+(double)Course.arr[k].data)/2));
            System.out.printf("| %-40s | %10s |%n","Rank",find_Rank(k));
            System.out.printf("+------------------------------------------+------------+%n");
            System.out.print("Do you want to search another student details?(y/n)");
            String sss = input.next();
            if (sss.equals("y")) {
                continue;
            } else {
                break;
            }
        }while(true);
    }
    public static Student [] make_array_rank(){
        Student[]temp =new Student[Course.arr.length];
        int []summ=new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            summ[i]=Course.arr[i].pfm+Course.arr[i].data;
        }
        int[]poo=new int[summ.length];
        for (int i = 0; i < summ.length; i++) {
            poo[i]=summ[i];
        }
        int[]oo=new int[poo.length];
        Arrays.sort(summ);
        for (int i = 0; i < poo.length; i++) {
            oo[i]=summ[summ.length-1-i];
        }

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if(oo[i]==poo[j]){
                    temp[i]=Course.arr[j];
                }
            }

        }
        return temp;
    }
    public static Student [] pf_array(){
        Student[]temp =new Student[Course.arr.length];
        int []summ=new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            summ[i]=Course.arr[i].pfm;
        }
        int[]poo=new int[summ.length];
        for (int i = 0; i < summ.length; i++) {
            poo[i]=summ[i];
        }
        int[]oo=new int[poo.length];
        Arrays.sort(summ);
        for (int i = 0; i < poo.length; i++) {
            oo[i]=summ[summ.length-1-i];
        }

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if(oo[i]==poo[j]){
                    temp[i]=Course.arr[j];
                }
            }

        }
        return temp;
    }
    public static void print_Ranks(){
        Scanner input=new Scanner(System.in);
        int m= 9;

        do {
            clearConsole();
            System.out.println("--------------------------------------------------------");
            System.out.println("                PRINT STUDENT'S RANKS               ");
            System.out.println("--------------------------------------------------------\n");
            System.out.printf("+--------+----------+-----------------------+--------------+--------------+\n");
            System.out.printf("| %-6s | %-8s | %-20s  | %-12s | %-12s |\n", "Rank", "ID", "Name", "Total Marks", "Avg.Marks");
            System.out.println("+--------+----------+-----------------------+--------------+--------------+\n");
            for (int i = 0; i < Course.arr.length; i++) {
                System.out.printf("| %-6d | %-8s | %-20s  | %-12d | %-12f |\n", i + 1, make_array_rank()[i].id, make_array_rank()[i].name, make_array_rank()[i].pfm + make_array_rank()[i].data, (double) (make_array_rank()[i].pfm + (double) make_array_rank()[i].data) / 2);
            }
            System.out.println("+--------+----------+-----------------------+--------------+--------------+\n");
            System.out.print("Do you want to go back to main menu?(y/n)");
            String sss = input.nextLine();
            if (sss.equals("y")) {
                break;
            }else{
                m=9;
            }
        }while(m!=9);
    }
    public static void best_in_pf(){
        Scanner input=new Scanner (System.in);
        int m=9;
        do{
            clearConsole();
            System.out.println("------------------------------------------------------");
            System.out.println("         BEST IN PROGRAMMING FUNDAMENTALS             ");
            System.out.println("------------------------------------------------------\n");
            System.out.printf("+--------+-----------------------+--------------+--------------+\n");
            System.out.printf("| %-8s | %-20s  | %-12s | %-12s |\n","ID", "Name", "PF Marks", "DBMS Marks");
            System.out.println("+--------+-----------------------+--------------+--------------+\n");
            for (int i = 0; i < Course.arr.length; i++) {
                System.out.printf("| %-8s |  %-20s  | %-12d | %-12d |\n", pf_array()[i].id, pf_array()[i].name, pf_array()[i].pfm ,pf_array()[i].data);
            }
            System.out.println("+--------+-----------------------+--------------+--------------+\n");
            System.out.print("Do you want to go back to main menu?(y/n)");
            String sss = input.nextLine();
            if (sss.equals("y")) {
                break;
            }else{
                m=9;
            }
        }while(m!=9);
    }
    public static Student [] dbms_array(){
        Student[]temp =new Student[Course.arr.length];
        int []summ=new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            summ[i]=Course.arr[i].data;
        }
        int[]poo=new int[summ.length];
        for (int i = 0; i < summ.length; i++) {
            poo[i]=summ[i];
        }
        int[]oo=new int[poo.length];
        Arrays.sort(summ);
        for (int i = 0; i < poo.length; i++) {
            oo[i]=summ[summ.length-1-i];
        }

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if(oo[i]==poo[j]){
                    temp[i]=Course.arr[j];
                }
            }

        }
        return temp;
    }

    public static void best_in_dbms(){
        Scanner input=new Scanner (System.in);
        int m=9;
        do{
            clearConsole();
            System.out.println("------------------------------------------------------");
            System.out.println("         BEST IN DATABASE MANAGEMENT SYSTEM            ");
            System.out.println("------------------------------------------------------\n");
            System.out.printf("+--------+-----------------------+--------------+--------------+\n");
            System.out.printf("| %-8s | %-20s  | %-12s | %-12s |\n","ID", "Name", "DBMS Marks", "PF Marks");
            System.out.println("+--------+-----------------------+--------------+--------------+\n");
            for (int i = 0; i < Course.arr.length; i++) {
                System.out.printf("| %-8s |  %-20s  | %-12d | %-12d |\n", dbms_array()[i].id, dbms_array()[i].name, dbms_array()[i].data ,dbms_array()[i].pfm);
            }
            System.out.println("+--------+-----------------------+--------------+--------------+\n");
            System.out.print("Do you want to go back to main menu?(y/n)");
            String sss = input.nextLine();
            if (sss.equals("y")) {
                break;
            }else{
                m=9;
            }
        }while(m!=9);

    }

}
class Course{
    public static Student[] arr = new Student[0];
    public static void main(String args[]){
        Scanner input=new Scanner (System.in);

        do{
            Student.clearConsole();
            System.out.println("              -------------------------------------------------");
            System.out.println("              |    WELCOME TO GDSE MARKS MANAGEMENT SYSTEM    |");
            System.out.println("              -------------------------------------------------");
            System.out.println("");
            System.out.println("[1] Add new Student                 \t\t [2] Add New Student With Marks");
            System.out.println("[3] Add Marks                       \t\t [4] Update Student Details");
            System.out.println("[5] Update Marks                    \t\t [6] Delete Student");
            System.out.println("[7] Print Student Details           \t\t [8] Print Student Ranks ");
            System.out.println("[9] Best in Programming Fundamentals\t\t [10] Best in Database Management System");
            System.out.println("");
            System.out.print("Enter an option to continue >");
            int num=input.nextInt();
            input.nextLine();
            switch(num){
                case(1):Student.Add_New_Student();break;
                case(2):Student.Add_New_Student_With_Marks();break;
                case(3):Student.add_marks();break;
                case(4):Student.Update_Student_Details();break;
                case(5):Student.update_mark();break;
                case(6):Student.delete_student();break;
                case(7):Student.print_student_details();break;
                case(8):Student.print_Ranks();break;
                case(9):Student.best_in_pf();break;
                case(10):Student.best_in_dbms();
            }
        }while(true);
    }
}
