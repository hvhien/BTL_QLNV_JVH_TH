package QuanLiXe;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        ArrayList<NoiThanh> noiThanhList = new ArrayList<>();
        ArrayList<NgoaiThanh> ngoaiThanhList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int chon,n;
        double sum1=0, sum2=0;
        do{
            showMenu();
            System.out.println("chon so: ");
            chon = scan.nextInt();
            switch (chon){
                case 1:
                    System.out.println("nhap so chuyen xe ngoai thanh can them: ");
                    n = scan.nextInt();
                    for(int i=0;i<n;i++){
                        NgoaiThanh ngoaiThanh = new NgoaiThanh();
                        ngoaiThanh.input();

                        ngoaiThanhList.add(ngoaiThanh);
                    }
                    break;
                case 2:
                    for(NgoaiThanh nt: ngoaiThanhList){
                        nt.output();
                    }
                    break;
                case 3:
                    System.out.println("nhap so chuyen xe noi thanh can them: ");
                    n = scan.nextInt();
                    for(int i=0;i<n;i++){
                        NoiThanh noiThanh = new NoiThanh();
                        noiThanh.input();

                        noiThanhList.add(noiThanh);

                    }
                    break;
                case 4:
                    for(NoiThanh nt :noiThanhList){
                        nt.output();
                    }
                    break;
                case 5:
                    for(NoiThanh nt : noiThanhList){
                        sum1+=nt.getDoanhThu();
                    }
                    for(NgoaiThanh nnt: ngoaiThanhList){
                        sum2+=nnt.getDoanhThu();
                    }
                    System.out.println("tong doanh thu cua xe noi thanh: "+sum1);
                    System.out.println("tong doanh thu cua xe ngoai thanh: "+sum2);
                    break;

                default:
                    System.out.println("Nhap sai!!!");
            }


        }while(chon!=6);

    }
    static void showMenu(){
        System.out.println(".............");
        System.out.println("1. Them chuyen xe ngoai thanh");
        System.out.println("2. Hien thi thong tin xe ngoai thanh ");
        System.out.println("3. Them chuyen xe noi thanh");
        System.out.println("4. Hien thi thong tin xe noi thanh");
        System.out.println("5. Tinh tong doanh thu tung loai xe");
        System.out.println("6. Thoat!!!");
    }
}
