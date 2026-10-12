# Quản lý thư viện

Bài tập Java OOP: quản lý tài liệu thư viện gồm Sách, Tạp chí, Báo.

## Chức năng
- Thêm mới tài liệu (Sách, Tạp chí, Báo)
- Xoá tài liệu theo mã
- Hiển thị thông tin tài liệu
- Tìm kiếm tài liệu theo loại
- Thoát chương trình

## Cách chạy
```
javac -encoding UTF-8 *.java
java Main
```

## Phân công công việc

| | **Trưởng nhóm** | **Thành viên 2** | **Thành viên 3** |
|---|---|---|---|
| **File** | `TaiLieu.java`, `QuanLyThuVien.java`, `Main.java`, `README.md` | `Sach.java`, `TapChi.java` | `Bao.java` |
| **Việc chính** | Thiết kế khung chương trình, viết lớp cha, lớp quản lý, menu, ghép code | Viết 2 lớp con kế thừa `TaiLieu` | Viết lớp con `Bao` và phần tài liệu hỗ trợ |
| **Chi tiết** | `TaiLieu`: lớp cha trừu tượng (mã, NXB, số bản phát hành, `getLoai()`, `hienThiThongTin()`).<br>`QuanLyThuVien`: `tonTai`, `them` (chặn trùng mã), `xoa`, `hienThiTatCa`, `timTheoLoai`.<br>`Main`: menu 5 chức năng, `docSo`, `docChuoi`, `themTaiLieu`, bắt lỗi nhập sai. | `Sach`: thêm tác giả, số trang.<br>`TapChi`: thêm số phát hành, tháng phát hành.<br>Mỗi lớp ghi đè `getLoai()` và `hienThiThongTin()`. | `Bao`: thêm ngày phát hành.<br>Ghi đè `getLoai()` và `hienThiThongTin()`. |
| **Thêm** | Chốt quy ước tên lớp, hàm trước khi cả nhóm làm.<br>Tạo repo GitHub, review và ghép code của 2 bạn, push lên.<br>Chạy thử toàn bộ chương trình, sửa lỗi.<br>Viết README, đại diện nộp bài và trả lời thầy cô. | Vẽ sơ đồ lớp UML.<br>Tự test lớp của mình bằng vài dữ liệu mẫu.<br>Chạy thử các chức năng thêm, hiển thị Sách và Tạp chí. | Soạn danh sách ca kiểm thử (thêm 3 loại, trùng mã, xoá, tìm theo loại, thoát).<br>Viết báo cáo hoặc slide ngắn nếu thầy cô yêu cầu. |

### Quy ước chung
- `TaiLieu` có `getMaTaiLieu()`, `getLoai()` (trả về `"Sách"`, `"Tạp chí"`, `"Báo"`) và `hienThiThongTin()`.
- Constructor: `Sach(ma, nxb, soBan, tacGia, soTrang)`, `TapChi(ma, nxb, soBan, soPhatHanh, thang)`, `Bao(ma, nxb, soBan, ngayPhatHanh)`.

### Thứ tự làm
Trưởng nhóm viết `TaiLieu.java` trước và gửi cho 2 bạn, vì các lớp con kế thừa từ nó. Trong lúc 2 bạn viết lớp con, trưởng nhóm làm tiếp `QuanLyThuVien` và `Main`. Cuối cùng cả nhóm gộp vào một thư mục, biên dịch bằng `javac -encoding UTF-8 *.java` rồi chạy `java Main`.
