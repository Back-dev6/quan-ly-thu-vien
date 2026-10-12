import java.util.ArrayList;
import java.util.Scanner;

// ===================== YÊU CẦU 1: CÁC LỚP TÀI LIỆU =====================

// Lớp cha trừu tượng: chứa thuộc tính chung
abstract class TaiLieu {
    private String maTaiLieu;
    private String tenNXB;
    private int soBanPhatHanh;

    public TaiLieu(String maTaiLieu, String tenNXB, int soBanPhatHanh) {
        this.maTaiLieu = maTaiLieu;
        this.tenNXB = tenNXB;
        this.soBanPhatHanh = soBanPhatHanh;
    }

    public String getMaTaiLieu() { return maTaiLieu; }
    public String getTenNXB() { return tenNXB; }
    public int getSoBanPhatHanh() { return soBanPhatHanh; }

    // Mỗi lớp con tự trả về tên loại của mình
    public abstract String getLoai();

    public void hienThiThongTin() {
        System.out.printf("[%s] Mã: %s | NXB: %s | Số bản phát hành: %d",
                getLoai(), maTaiLieu, tenNXB, soBanPhatHanh);
    }
}

class Sach extends TaiLieu {
    private String tenTacGia;
    private int soTrang;

    public Sach(String ma, String nxb, int soBan, String tenTacGia, int soTrang) {
        super(ma, nxb, soBan);
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
    }

    @Override
    public String getLoai() { return "Sách"; }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.printf(" | Tác giả: %s | Số trang: %d%n", tenTacGia, soTrang);
    }
}

class TapChi extends TaiLieu {
    private int soPhatHanh;
    private int thangPhatHanh;

    public TapChi(String ma, String nxb, int soBan, int soPhatHanh, int thangPhatHanh) {
        super(ma, nxb, soBan);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    @Override
    public String getLoai() { return "Tạp chí"; }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.printf(" | Số phát hành: %d | Tháng phát hành: %d%n", soPhatHanh, thangPhatHanh);
    }
}

class Bao extends TaiLieu {
    private String ngayPhatHanh;

    public Bao(String ma, String nxb, int soBan, String ngayPhatHanh) {
        super(ma, nxb, soBan);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    @Override
    public String getLoai() { return "Báo"; }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.printf(" | Ngày phát hành: %s%n", ngayPhatHanh);
    }
}

// ===================== YÊU CẦU 2: LỚP QUẢN LÝ =====================

class QuanLyThuVien {
    private ArrayList<TaiLieu> danhSach = new ArrayList<>();

    // Kiểm tra mã đã tồn tại chưa (mã phải duy nhất)
    public boolean tonTai(String ma) {
        for (TaiLieu tl : danhSach) {
            if (tl.getMaTaiLieu().equalsIgnoreCase(ma)) return true;
        }
        return false;
    }

    // Thêm tài liệu (Sách / Tạp chí / Báo đều dùng chung nhờ đa hình)
    public boolean them(TaiLieu tl) {
        if (tonTai(tl.getMaTaiLieu())) return false;
        danhSach.add(tl);
        return true;
    }

    // Xoá theo mã
    public boolean xoa(String ma) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaTaiLieu().equalsIgnoreCase(ma)) {
                danhSach.remove(i);
                return true;
            }
        }
        return false;
    }

    // Hiển thị toàn bộ
    public void hienThiTatCa() {
        if (danhSach.isEmpty()) {
            System.out.println("Thư viện chưa có tài liệu nào.");
            return;
        }
        for (TaiLieu tl : danhSach) tl.hienThiThongTin();
    }

    // Tìm theo loại: "Sách", "Tạp chí", "Báo"
    public void timTheoLoai(String loai) {
        boolean thay = false;
        for (TaiLieu tl : danhSach) {
            if (tl.getLoai().equals(loai)) {
                tl.hienThiThongTin();
                thay = true;
            }
        }
        if (!thay) System.out.println("Không có tài liệu thuộc loại: " + loai);
    }
}

// ===================== CHƯƠNG TRÌNH CHÍNH =====================

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
