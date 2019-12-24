package TinhLuong;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hãy nhập số lượng nhân viên: ");
        int tongNhanVien = Integer.parseInt(scanner.nextLine());


        NhanVien[] mangNhanVien = new NhanVien[tongNhanVien];
        for (int i = 0; i < tongNhanVien; i++) {

            System.out.print("Tên nhân viên " + (i + 1) + ": ");
            String ten = scanner.nextLine();
            System.out.print("Là nhân viên (1-Toàn thời gian; 2-Bán thời gian;): ");
            int laNhanVien = Integer.parseInt(scanner.nextLine());

            if (laNhanVien == 1) {
                // Nhân viên toàn thời gian
                System.out.print("Chức vụ nhân viên (1-Sếp; 2-Phó giám đốc; 3- Chủ tịch;\n 4-Phó chủ tịch; "
                        + "5-Trưởng phòng; 6-Nhân viên lính: ");
                int chucVu = Integer.parseInt(scanner.nextLine());
                System.out.print("Ngày làm thêm (nếu có): ");
                int ngayLamThem = Integer.parseInt(scanner.nextLine());
                mangNhanVien[i] = new NhanVienFullTime(ten, ngayLamThem, chucVu);
            } else {
                System.out.print("Giờ làm: ");
                int gioLamViec = Integer.parseInt(scanner.nextLine());
                mangNhanVien[i] = new NhanVienPartTime(ten, gioLamViec);
            }
            System.out.println("");
        }

        System.out.println("\nKết quả tính lương\n");


        for (NhanVien nhanVien : mangNhanVien) {
            nhanVien.tinhLuong();
            nhanVien.xuatThongTin();
        }
    }

}

