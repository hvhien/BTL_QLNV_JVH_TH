package QuanLiNhanSu;

import java.util.Scanner;

public class NhanVienFullTime extends NhanVien {


    private int ngayLamThem; // Ngày làm thêm của nhân viên
    private int loaiChucVu; // Chức vụ là lính hay sếp

    public NhanVienFullTime() {
    }

    public NhanVienFullTime(int ngayLamThem, int loaiChucVu, String tenNhanVien, String maNhanVien, String ngaySinh, String que) {
        super(tenNhanVien, maNhanVien, ngaySinh, que);
        this.ngayLamThem = ngayLamThem;
        this.loaiChucVu = loaiChucVu;
    }

    @Override
    public void input(){
        Scanner scan = new Scanner(System.in);
        super.input();
        System.out.println("Nhập số ngày làm thêm: ");
        ngayLamThem = Integer.parseInt(scan.nextLine());
        System.out.println("Loại chức vụ: "
                + "(1- Giám đốc; 2- Phó giám đốc; 3- Chủ tịch;"
                + "\n4- Phó chủ tịch; 5- Trưởng phòng; 6- Nhân viên thường)");
        loaiChucVu = Integer.parseInt(scan.nextLine());
        System.out.println("--------------------");
    }

    @Override
    public void showInfor(){
        super.showInfor();
        System.out.println(loaiNhanVien());
        if(khenThuong()==true){
            System.out.print(" =====Lương: "+(tinhLuong()+1000000)+" =====");
        }
        else{
            System.out.print(" =====Lương: "+tinhLuong()+" =====");
        }

        System.out.println("");
    }


    @Override
    public String loaiNhanVien() {
        if (loaiChucVu == Configs.NHAN_VIEN_THUONG) {
            return "=====Nhân viên thường toàn thời gian" + (ngayLamThem > 0 ? " (có làm thêm ngày)=====":"");
        } else if(loaiChucVu ==Configs.NHAN_VIEN_SEP){
            return "=====Sếp toàn thời gian" + (ngayLamThem > 0 ? " (có làm thêm ngày)=====":"");
        }
        else if(loaiChucVu == Configs.NHAN_VIEN_PHOGIAMDOC){
            return "=====Phó giám đốc toàn thời gian"+ (ngayLamThem>0 ? " (có làm thêm ngày)=====": "");
        }
        else if(loaiChucVu ==Configs.NHAN_VIEN_CHUTICH){
            return "=====Chủ tịch toàn thời gian"+ (ngayLamThem>0 ? " (có làm thêm ngày)=====": "");
        }
        else if(loaiChucVu == Configs.NHAN_VIEN_PHOCHUTICH){
            return "=====Phó chủ tịch toàn thời gian: "+(ngayLamThem>0 ? " (có làm thêm ngày)=====": "");
        }
        if(loaiChucVu == Configs.LUONG_NHAN_VIEN_FULL_TIME_TRUONGPHONG) {
            return "=====Trưởng phòng toàn thời gian: "+(ngayLamThem>0 ? "có làm thêm ngày)=====": "");
        }
        return null;
    }
    @Override
    public long tinhLuong() {
        if (loaiChucVu ==Configs.NHAN_VIEN_THUONG) {
            return luong = Configs.LUONG_NHAN_VIEN_FULL_TIME_THUONG + ngayLamThem * Configs.LUONG_LAM_THEM_MOI_NGAY-soNgayDiMuon*200000;
        } else if (loaiChucVu ==Configs.NHAN_VIEN_SEP) {
            return luong = Configs.LUONG_NHAN_VIEN_FULL_TIME_SEP + ngayLamThem * Configs.LUONG_LAM_THEM_MOI_NGAY-soNgayDiMuon*200000;
        }
        else if(loaiChucVu == Configs.NHAN_VIEN_PHOGIAMDOC){
            return  luong = Configs.LUONG_NHAN_VIEN_FULL_TIME_PHOGIAMDOC +ngayLamThem*Configs.LUONG_LAM_THEM_MOI_NGAY-soNgayDiMuon*200000;
        }
        else if(loaiChucVu==Configs.NHAN_VIEN_CHUTICH){
            return luong = Configs.LUONG_NHAN_VIEN_FULL_TIME_CHUTICH +ngayLamThem*Configs.LUONG_LAM_THEM_MOI_NGAY-soNgayDiMuon*200000;
        }
        else if(loaiChucVu == Configs.NHAN_VIEN_PHOCHUTICH){
            return  luong =Configs.LUONG_NHAN_VIEN_FULL_TIME_PHOCHUTICH+ngayLamThem*Configs.LUONG_LAM_THEM_MOI_NGAY-soNgayDiMuon*200000;
        }
        else if(loaiChucVu==Configs.NHAN_VIEN_TOTRUONG){
            return luong = Configs.LUONG_NHAN_VIEN_FULL_TIME_TRUONGPHONG +ngayLamThem*Configs.LUONG_LAM_THEM_MOI_NGAY-soNgayDiMuon*200000;
        }
        return 0;
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
        if(soNgayNghi>9|soNgayDiMuon>15){
            return true;
        }
        return false;
    }
}
