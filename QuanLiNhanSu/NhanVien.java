package QuanLiNhanSu;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class NhanVien {
    protected String tenNhanVien, maNhanVien, ngaySinh, que, gmail, soDienThoai;
    protected long luong;
    protected int soNgayNghi;
    protected int soNgayDiMuon;

    public NhanVien() {
    }

    public NhanVien(String tenNhanVien, String maNhanVien, String ngaySinh, String que) {
        this.tenNhanVien = tenNhanVien;
        this.maNhanVien = maNhanVien;
        this.ngaySinh = ngaySinh;
        this.que = que;

    }

    public void input(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        while(true){
            tenNhanVien = scan.nextLine();
            boolean flag = setTenNhanVien(tenNhanVien);
            if(flag){
                break;
            }
            else{
                System.err.println("Tên không hợp lệ!!!!");
            }
        }

        System.out.println("Nhập mã nhân viên: ");
        while(true){
            maNhanVien = scan.nextLine();
            boolean flag = setMaNhanVien(maNhanVien);

            if(flag){
                break;
            }
            else{
                System.err.println("Mã nhân viên không hợp lệ!! Nhập lại!!!");
            }
        }
        System.out.println("Nhập ngày sinh: ");
        ngaySinh = scan.nextLine();
        System.out.println("Nhập quê quán: ");
        que = scan.nextLine();
        System.out.println("Nhập gmail: ");
        while(true){
            gmail =scan.nextLine();
            boolean flag = setGmail(gmail);
            if(flag ==true){
                break;
            }
            else{
                System.err.println("gmail không hợp lệ !!!! Nhập lại");
            }


        }
        System.out.println("Nhập số điện thoại liên lạc: ");
        while(true){
            soDienThoai = scan.nextLine();
            boolean flag = setSoDienThoai(soDienThoai);
            if(flag==true){
                break;
            }
            else{
                System.err.println("Số điện thoại không hợp lệ");
            }
        }
        System.out.println("Nhập số ngày nghỉ: ");
        soNgayNghi = Integer.parseInt(scan.nextLine());
        System.out.println("Nhập số ngày đi muộn: ");
        soNgayDiMuon = Integer.parseInt(scan.nextLine());


    }

    public void showInfor(){
        System.out.println("===== Nhân viên: " + tenNhanVien + " =====");
        System.out.println("===== Mã nhân viên: "+maNhanVien+" =====");
        System.out.println("===== Ngày sinh: "+ngaySinh+" =====");
        System.out.println("===== Quê quán: "+que+" =====");
        System.out.println("===== Gmail: "+ gmail+ " =====");
        System.out.println("===== Số điện thoại: "+soDienThoai+ " =====");
        System.out.println("===== Số ngày nghỉ: "+ soNgayNghi+ " =====");
        System.out.println("===== Số ngày đi muộn: "+soNgayDiMuon);
    }

    public abstract String loaiNhanVien();

    public abstract long tinhLuong();

    public abstract boolean khenThuong();

    public abstract boolean kiLuat();

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public boolean setTenNhanVien(String tenNhanVien) {
        if(tenNhanVien.length()!=0){
            this.tenNhanVien = tenNhanVien;
            return true;
        }
        return false;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public boolean setMaNhanVien(String maNhanVien) {
        String regex = "^2019\\d{4}$";
        Pattern pattern =  Pattern.compile(regex);
        Matcher matcher = pattern.matcher(maNhanVien);
        if(matcher.find()){
            return true;
        }
        return false;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public long getLuong() {
        return luong;
    }

    public void setLuong(long luong) {
        this.luong = luong;
    }

    public String getGmail() {
        return gmail;
    }

    public boolean setGmail(String gmail) {
        String regex = "^[a-zA-Z]+[a-zA-Z0-9]+@gmail.com$";//thanhvu2k@gmail.com
        Pattern pattern =  Pattern.compile(regex);
        Matcher matcher = pattern.matcher(gmail);
        if(matcher.find()){
            return true;
        }
        return false;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public boolean setSoDienThoai(String soDienThoai) {
        String regex = "^0\\d{9}$";// 0363992640
        Pattern pattern =  Pattern.compile(regex);
        Matcher matcher = pattern.matcher(soDienThoai);
        if(matcher.find()){
            this.soDienThoai = soDienThoai;
            return true;
        }
        return false;

    }



}
