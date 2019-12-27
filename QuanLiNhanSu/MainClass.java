package QuanLiNhanSu;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n,m, choose;
        ArrayList<NhanVienFullTime> list = new ArrayList<>();
        ArrayList<NhanVienPartTime> List = new ArrayList<>();

        do{
            System.out.println("---------------");
            showMenu();
            System.out.println("Chọn số: ");
            choose = Integer.parseInt(scan.nextLine());

            switch(choose){
                case 1:
                    System.out.println("Nhập số nhân viên full time cần thêm: ");
                    n = Integer.parseInt(scan.nextLine());

                    for(int i=0;i<n;i++){
                        NhanVienFullTime nv1 = new NhanVienFullTime();
                        nv1.input();

                        list.add(nv1);
                    }
                    break;
                case 2:
                    System.out.println("Nhập số nhân viên part time cần thêm: ");
                    m = Integer.parseInt(scan.nextLine());

                    for(int i=0;i<m;i++){
                        NhanVienPartTime nv2 = new NhanVienPartTime();
                        nv2.input();
                        List.add(nv2);
                    }
                    break;
                case 3:
                    System.out.println("\nThông tin nhân viên full time: \n");
                    for(int i=0;i<list.size();i++){
                        list.get(i).tinhLuong();
                        list.get(i).showInfor();
                        System.out.println("\n\n");
                    }

                    System.out.println("\n\n\n Thông tin nhân viên part time: \n\n");
                    for(int i=0;i<List.size();i++){
                        List.get(i).tinhLuong();
                        List.get(i).showInfor();
                    }
                    break;
                case 4:
                    int maxIndex=0, minIndex=0;
                    long LuongMax, LuongMin;
                    LuongMax=list.get(0).getLuong();
                    LuongMin = list.get(0).getLuong();
                    for(int i=0;i<list.size();i++){
                        if(list.get(i).getLuong()>LuongMax){
                            maxIndex =i;
                            LuongMax = list.get(i).getLuong();
                        }
                        if(list.get(i).getLuong()<LuongMin){
                            minIndex = i;
                            LuongMin =  list.get(i).getLuong();
                        }
                    }

                    System.out.println("\tNhân viên lương cao nhất full time: ");
                    list.get(maxIndex).showInfor();

                    System.out.println("\n\n Nhân viên lương thấp nhất full time: ");
                    list.get(minIndex).showInfor();

                    maxIndex=0;
                    minIndex=0;
                    LuongMax = List.get(0).tinhLuong();
                    LuongMin = List.get(0).tinhLuong();

                    for(int i=0;i<List.size();i++){
                        if(List.get(i).getLuong()>LuongMax){
                            maxIndex = i;
                            LuongMax = List.get(i).getLuong();

                        }
                        if(List.get(i).getLuong()<LuongMin){
                            minIndex = i;
                            LuongMin = List.get(i).getLuong();
                        }
                    }

                    System.out.println("\n\nNhân viên part time có lương cao nhất: ");
                    List.get(maxIndex).showInfor();
                    System.out.println("Nhân viên part tiem có lương thấp nhất: ");
                    List.get(minIndex).showInfor();

                    break;

                case 5:
                    System.out.println("Nhập mã nhân viên cần tìm kiếm: ");
                    String maNhanVien = scan.nextLine();
                    int dem=0;
                    for(NhanVienFullTime nhanvien: list){
                        if(nhanvien.getMaNhanVien().equals(maNhanVien)){
                            nhanvien.showInfor();
                            dem++;
                        }
                    }
                    if(dem==0){
                        System.out.println("Không tìm thấy mã nhân viên full time thỏa mãn!!! ");
                    }
                    dem=0;
                    for(NhanVienPartTime nhanVien: List){
                        if(nhanVien.getMaNhanVien().equals(maNhanVien)){
                            nhanVien.showInfor();
                            dem++;
                        }
                    }
                    if(dem==0){
                        System.out.println("Không tìm thấy mã nhân viên part time thỏa mãn !!! ");
                    }
                    break;
                case 6:
                    System.out.println("sắp xếp nhân viên full time theo lương giảm dần:");
                    Collections.sort(list, new Comparator<NhanVienFullTime>() {
                        @Override
                        public int compare(NhanVienFullTime o1, NhanVienFullTime o2) {
                         return o1.getLuong()>=o2.getLuong() ?-1:1;

                        }
                    });

                    for(NhanVienFullTime nv: list){
                        nv.showInfor();
                    }
                    break;

                case 7:
                    Collections.sort(list, new Comparator<NhanVienFullTime>() {
                        @Override
                        public int compare(NhanVienFullTime o1, NhanVienFullTime o2) {
                            int cmp = o1.getTenNhanVien().compareTo(o2.getTenNhanVien());
                            if(cmp>=0){
                                return 1;
                            }
                            return -1;
                        }
                    });
                    System.out.println("\n\n Sắp xếp tên nhân viên full time theo thứ tự bảng chữ cái: ");
                    for(int i=0;i<list.size();i++){
                        list.get(i).showInfor();
                        System.out.println("-------------");
                    }

                    Collections.sort(List, new Comparator<NhanVienPartTime>() {
                        @Override
                        public int compare(NhanVienPartTime o1, NhanVienPartTime o2) {
                            int cmp = o1.getTenNhanVien().compareTo(o2.getTenNhanVien());
                            if(cmp>=0){
                                return 1;
                            }
                            return -1;
                        }
                    });

                    System.out.println("\n\n\t Sắp xếp tên nhân viên part time theo thứ tự bảng chữ cái: ");
                    for(int i=0;i<List.size();i++){
                        List.get(i).showInfor();
                        System.out.println("\n*******");
                    }
                    break;

                case 8:
                    System.out.println("\tDanh sách nhân viên full time được khen thưởng: ");
                    for(int i=0;i<list.size();i++){
                        if(list.get(i).khenThuong()==true){
                            list.get(i).showInfor();
                            System.out.println("\n");
                        }
                    }
                    System.out.println("\tDanh sách nhân viên part time được khen thưởng:  ");
                    for(int i=0;i<List.size();i++){
                        if(List.get(i).khenThuong()==true){
                            List.get(i).showInfor();
                            System.out.println("");
                        }
                    }
                    break;
                case 9:
                    System.out.println("\t\t Sa thải nhân viên full time: ");
                    for(int i=0;i<list.size();i++){
                        if(list.get(i).kiLuat()==true){
                            list.remove(list.get(i));
                            i--;
                        }
                    }

                    for(NhanVienFullTime nv : list){
                        nv.showInfor();
                    }

                    System.out.println("\n\nSa thải nhân viên part time: ");
                    for(int i=0;i<List.size();i++){
                        if(List.get(i).kiLuat()==true){
                            List.remove(List.get(i));
                            i--;
                        }
                    }
                    break;
            }
        }while(choose!=10);
    }
    static final void showMenu(){
        System.out.println("\t\t1. Thêm danh sách nhân viên full time");
        System.out.println("\t\t2. Thêm danh sách nhân viên part time");
        System.out.println("\t\t3. Hiển thị thông tin các nhân viên");
        System.out.println("\t\t4. Tìm thông tin nhân viên có mức lương cao và thấp nhất");
        System.out.println("\t\t5. Tìm kiếm nhân viên theo mã nhân viên");
        System.out.println("\t\t6. Sắp xếp nhân viên theo thứ tự lương giảm dần");
        System.out.println("\t\t7. Hiển thị danh sánh nhân viên có tên theo thứ tự bảng chữ cái");
        System.out.println("\t\t8. Hiển thị danh sách nhân viên được khen thưởng");
        System.out.println("\t\t9. Tìm những nhân viên bị kỉ luật. Xóa các nhân viên đó khỏi danh sách");
        System.out.println("\t\t10. Thoát");

    }
}
