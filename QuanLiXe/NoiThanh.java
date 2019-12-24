package QuanLiXe;

import java.util.Scanner;

public class NoiThanh extends ChuyenXe{
    private int soTuyen;
    private double soKm;

    public NoiThanh() {
    }

    @Override
    public void input(){
        System.out.println("....................");
        Scanner scan = new Scanner(System.in);
        super.input();
        System.out.println("nhap so tuyen: ");
        soTuyen = Integer.parseInt(scan.nextLine());
        System.out.println("nhap so km di duoc: ");
        soKm = Double.parseDouble(scan.nextLine());
    }

    @Override
    public void output(){
        super.output();
        System.out.println("SO tuyen: "+soTuyen);
        System.out.println("so km di duoc: "+soKm);
    }
    public int getSoTuyen() {
        return soTuyen;
    }

    public void setSoTuyen(int soTuyen) {
        this.soTuyen = soTuyen;
    }

    public double getSoKm() {
        return soKm;
    }

    public void setSoKm(double soKm) {
        this.soKm = soKm;
    }
}
