package QuanLiXe;

import java.util.Scanner;

public class ChuyenXe {
    protected String maChuyen, tenTaiXe;
    protected int soXe;
    protected double doanhThu;

    public ChuyenXe() {
    }

    public void input(){
        Scanner scan = new Scanner(System.in);
        System.out.println("nhap ma chuyen : ");
        maChuyen = scan.nextLine();
        System.out.println("nhap ten tai xe: ");
        tenTaiXe = scan.nextLine();
        System.out.println("nhap so xe: ");
        soXe = Integer.parseInt(scan.nextLine());
    }

    public void output(){
        System.out.println("ma so chuyen: "+maChuyen);
        System.out.println("ten tai xe: "+tenTaiXe);
        System.out.println("so xe: "+soXe);

    }
    public String getMaChuyen() {
        return maChuyen;
    }

    public void setMaChuyen(String maChuyen) {
        this.maChuyen = maChuyen;
    }

    public String getTenTaiXe() {
        return tenTaiXe;
    }

    public void setTenTaiXe(String tenTaiXe) {
        this.tenTaiXe = tenTaiXe;
    }

    public int getSoXe() {
        return soXe;
    }

    public void setSoXe(int soXe) {
        this.soXe = soXe;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }
}
