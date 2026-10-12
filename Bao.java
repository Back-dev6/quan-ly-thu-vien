public class Bao extends TaiLieu {
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
