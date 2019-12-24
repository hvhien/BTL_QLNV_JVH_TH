package TinhLuong;

public class NhanVienFullTime extends NhanVien {
    private int ngayLamThem; // Ngày làm thêm của nhân viên
    private int loaiChucVu; // Chức vụ là lính hay sếp

    public NhanVienFullTime(String ten, int ngayLamThem, int loaiChucVu) {
        super(ten);
        this.ngayLamThem = ngayLamThem;
        this.loaiChucVu = loaiChucVu;
    }

    @Override
    public String loaiNhanVien() {
        if (loaiChucVu == Configs.NHAN_VIEN_THUONG) {
            return "Lính toàn thời gian" + (ngayLamThem > 0 ? " (có làm thêm ngày)":"");
        } else if(loaiChucVu ==Configs.NHAN_VIEN_SEP){
            return "Sếp toàn thời gian" + (ngayLamThem > 0 ? " (có làm thêm ngày)":"");
        }
        else if(loaiChucVu == Configs.NHAN_VIEN_PHOGIAMDOC){
            return "Phó giám đốc toàn thời gian"+ (ngayLamThem>0 ? " (có làm thêm ngày không)": "");
        }
        else if(loaiChucVu ==Configs.NHAN_VIEN_CHUTICH){
            return "Chủ tịch toàn thời gian"+ (ngayLamThem>0 ? " (có làm thêm ngày nào không)": "");
        }
        else if(loaiChucVu == Configs.NHAN_VIEN_PHOCHUTICH){
            return "Phó chủ tịch toàn thời gian: "+(ngayLamThem>0 ? " (có làm thêm ngày nào không)": "");
        }
        else {
            return "Trưởng phòng toàn thời gian: "+(ngayLamThem>0 ? "có làm thêm ngày nào không)": "");
        }

    }

    @Override
    public void tinhLuong() {
        if (loaiChucVu == Configs.NHAN_VIEN_THUONG) {
            luong = Configs.LUONG_NHAN_VIEN_FULL_TIME_THUONG + ngayLamThem * Configs.LUONG_LAM_THEM_MOI_NGAY;
        } else if (loaiChucVu == Configs.NHAN_VIEN_SEP) {
            luong = Configs.LUONG_NHAN_VIEN_FULL_TIME_SEP + ngayLamThem * Configs.LUONG_LAM_THEM_MOI_NGAY;
        }
        else if(loaiChucVu == Configs.NHAN_VIEN_PHOGIAMDOC){
            luong = Configs.LUONG_NHAN_VIEN_FULL_TIME_PHOGIAMDOC +ngayLamThem*Configs.LUONG_LAM_THEM_MOI_NGAY;
        }
        else if(loaiChucVu==Configs.NHAN_VIEN_CHUTICH){
            luong = Configs.LUONG_NHAN_VIEN_FULL_TIME_CHUTICH +ngayLamThem*Configs.LUONG_LAM_THEM_MOI_NGAY;
        }
        else if(loaiChucVu == Configs.LUONG_NHAN_VIEN_FULL_TIME_PHOCHUTICH){
            luong = Configs.LUONG_NHAN_VIEN_FULL_TIME_CHUTICH+ngayLamThem*Configs.LUONG_LAM_THEM_MOI_NGAY;
        }
        else if(loaiChucVu==Configs.NHAN_VIEN_TOTRUONG){
            luong = Configs.LUONG_NHAN_VIEN_FULL_TIME_TRUONGPHONG +ngayLamThem*Configs.LUONG_LAM_THEM_MOI_NGAY;
        }
    }

}
