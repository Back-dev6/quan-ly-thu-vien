import java.util.ArrayList;

public class QuanLyThuVien {
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
