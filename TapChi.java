public class TapChi extends TaiLieu {
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
