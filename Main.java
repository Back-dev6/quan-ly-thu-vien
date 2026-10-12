import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    // Đọc số nguyên, nhập sai thì yêu cầu nhập lại
    static int docSo(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ!");
            }
        }
    }

    static String docChuoi(String thongBao) {
        System.out.print(thongBao);
        return sc.nextLine().trim();
    }

    static void themTaiLieu(QuanLyThuVien ql) {
        System.out.println("1. Sách   2. Tạp chí   3. Báo");
        int loai = docSo("Chọn loại tài liệu: ");
        if (loai < 1 || loai > 3) {
            System.out.println("Loại không hợp lệ!");
            return;
        }

        String ma = docChuoi("Mã tài liệu: ");
        if (ql.tonTai(ma)) {
            System.out.println("Mã tài liệu đã tồn tại!");
            return;
        }
        String nxb = docChuoi("Tên nhà xuất bản: ");
        int soBan = docSo("Số bản phát hành: ");

        TaiLieu tl;
        if (loai == 1) {
            String tacGia = docChuoi("Tên tác giả: ");
            int soTrang = docSo("Số trang: ");
            tl = new Sach(ma, nxb, soBan, tacGia, soTrang);
        } else if (loai == 2) {
            int soPH = docSo("Số phát hành: ");
            int thang = docSo("Tháng phát hành (1-12): ");
            tl = new TapChi(ma, nxb, soBan, soPH, thang);
        } else {
            String ngay = docChuoi("Ngày phát hành (dd/MM/yyyy): ");
            tl = new Bao(ma, nxb, soBan, ngay);
        }
        ql.them(tl);
        System.out.println("Thêm thành công!");
    }

    public static void main(String[] args) {
        QuanLyThuVien ql = new QuanLyThuVien();
        int chon;
        do {
            System.out.println("\n===== QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Thêm mới tài liệu");
            System.out.println("2. Xoá tài liệu theo mã");
            System.out.println("3. Hiển thị thông tin tài liệu");
            System.out.println("4. Tìm kiếm tài liệu theo loại");
            System.out.println("5. Thoát");
            chon = docSo("Chọn chức năng: ");

            switch (chon) {
                case 1:
                    themTaiLieu(ql);
                    break;
                case 2:
                    String ma = docChuoi("Nhập mã tài liệu cần xoá: ");
                    System.out.println(ql.xoa(ma) ? "Đã xoá!" : "Không tìm thấy mã tài liệu!");
                    break;
                case 3:
                    ql.hienThiTatCa();
                    break;
                case 4:
                    System.out.println("1. Sách   2. Tạp chí   3. Báo");
                    int l = docSo("Chọn loại cần tìm: ");
                    if (l == 1) ql.timTheoLoai("Sách");
                    else if (l == 2) ql.timTheoLoai("Tạp chí");
                    else if (l == 3) ql.timTheoLoai("Báo");
                    else System.out.println("Loại không hợp lệ!");
                    break;
                case 5:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ!");
            }
        } while (chon != 5);
    }
}
