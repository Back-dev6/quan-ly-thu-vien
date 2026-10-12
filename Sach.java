public class Sach extends TaiLieu {
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
