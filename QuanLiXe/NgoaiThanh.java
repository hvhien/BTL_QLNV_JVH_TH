package QuanLiXe;

import java.util.Scanner;

public class NgoaiThanh extends ChuyenXe {
    private int soNgayDi;
    private String noiDen;


    public NgoaiThanh() {
    }

    @Override
    public void input(){
        System.out.println("..................");
        Scanner scan = new Scanner(System.in);
        super.input();
        System.out.println("Nhap noi den: ");
        noiDen = scan.nextLine();
        System.out.println("nhap so ngay di duoc: ");
        soNgayDi = Integer.parseInt(scan.nextLine());
    }

    @Override
    public void output(){
        super.output();
        System.out.println("Noi den: "+noiDen);
        System.out.println("SO ngay di duoc: "+soNgayDi);
    }
    public int getSoNgayDi() {
        return soNgayDi;
    }

    public void setSoNgayDi(int soNgayDi) {
        this.soNgayDi = soNgayDi;
    }

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }
}
