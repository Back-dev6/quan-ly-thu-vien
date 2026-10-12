// Lớp cha trừu tượng: chứa thuộc tính chung của mọi tài liệu
public abstract class TaiLieu {
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
