package QuanLiNhanSu;

import java.util.Scanner;

public class NhanVienPartTime extends NhanVien {
    private int gioLamViec; // Tổng số giờ làm việc của nhân viên
    private int soNgay;
    public NhanVienPartTime(String tenNhanVien, int gioLamViec) {
        this.tenNhanVien = tenNhanVien;
        this.gioLamViec = gioLamViec;
    }

    public NhanVienPartTime() {
    }

    @Override
    public void input(){
        Scanner scan = new Scanner(System.in);

        super.input();
        System.out.println("Nhập số giờ làm việc / ngày: ");
        while(true){
            gioLamViec= Integer.parseInt(scan.nextLine());
            boolean flag = setGioLamViec(gioLamViec);
            if(flag){
                break;
            }
            System.err.println("Nhập lại số giờ làm việc!!!");
        }
        System.out.println("Số ngày làm việc trong tháng: ");
        while(true){
            soNgay = Integer.parseInt(scan.nextLine());
            boolean flag = setSoNgay(soNgay);
            if(flag){
                break;
            }
            else{
                System.out.println("Nhập lại số ngày !!!");
            }

        }
        System.out.println("---------------");

    }

    @Override
    public void showInfor(){
        super.showInfor();
        System.out.println(" =====Loại nhân viên: "+loaiNhanVien()+"=====");
        System.out.println(" =====Lương: "+tinhLuong()+" =====");
        System.out.println("\t\t===============");
    }
    @Override
    public String loaiNhanVien() {
        return "Nhân viên thời vụ";
    }

    @Override
    public long tinhLuong() {
        return luong = Configs.LUONG_NHAN_VIEN_PART_TIME_MOI_GIO * gioLamViec*soNgay-soNgayDiMuon*50000;

    }

    public int getGioLamViec() {
        return gioLamViec;
    }

    public boolean setGioLamViec(int gioLamViec) {
        if(gioLamViec>=0&&this.gioLamViec<=24){
            this.gioLamViec = gioLamViec;
            return true;
        }
        return false;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public boolean setSoNgay(int soNgay) {
        if(soNgay>=0&&soNgay<=30){
            this.soNgay = soNgay;
            return true;
        }
        return false;
    }

    @Override
    public boolean khenThuong(){
        if(soNgayNghi==0&&soNgayDiMuon==0){
            return true;
        }
        return false;
    }

    @Override
    public boolean kiLuat(){
        if(soNgayNghi>0.3*soNgay|soNgayDiMuon>0.5*soNgay){
            return true;
        }
        return false;
    }

}
