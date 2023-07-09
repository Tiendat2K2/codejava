import java.util.Scanner;

// Lớp HoaDon
class HoaDon {
    private String maHoaDon;
    private int ngay;
    private int thang;
    private int nam;
    private String tenKhachHang;
    private String maPhong;
    private double donGia;

    // Constructor không có tham số
    public HoaDon() {
    }

    // Constructor có tham số
    public HoaDon(String maHoaDon, int ngay, int thang, int nam, String tenKhachHang, String maPhong, double donGia) {
        this.maHoaDon = maHoaDon;
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
        this.tenKhachHang = tenKhachHang;
        this.maPhong = maPhong;
        this.donGia = donGia;
    }

    // Getter và Setter cho thuộc tính
    public String getMaHoaDon() {

        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {

        this.maHoaDon = maHoaDon;
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {

        return nam;
    }

    public void setNam(int nam) {

        this.nam = nam;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    // Phương thức nhập thông tin hóa đơn
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã hóa đơn: ");
        maHoaDon = scanner.nextLine();
        System.out.print("Nhập ngày hóa đơn: ");
        ngay = scanner.nextInt();
        System.out.print("Nhập tháng hóa đơn: ");
        thang = scanner.nextInt();
        System.out.print("Nhập năm hóa đơn: ");
        nam = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng new line
        System.out.print("Nhập tên khách hàng: ");
        tenKhachHang = scanner.nextLine();
        System.out.print("Nhập mã phòng: ");
        maPhong = scanner.nextLine();
        System.out.print("Nhập đơn giá: ");
        donGia = scanner.nextDouble();
    }

    // Phương thức xuất thông tin hóa đơn
    public void output() {
        System.out.println("Mã hóa đơn: " + maHoaDon);
        System.out.println("Ngày hóa đơn: " + ngay + "/" + thang + "/" + nam);
        System.out.println("Tên khách hàng: " + tenKhachHang);
        System.out.println("Mã phòng: " + maPhong);
        System.out.println("Đơn giá: " + donGia);
    }
}

// Lớp HoaDonTheoGio kế thừa từ lớp HoaDon
class HoaDonTheoGio extends HoaDon {
    private int soGio;

    // Constructor không có tham số
    public HoaDonTheoGio() {
    }

    // Constructor có tham số
    public HoaDonTheoGio(String maHoaDon, int ngay, int thang, int nam, String tenKhachHang, String maPhong, double donGia, int soGio) {
        super(maHoaDon, ngay, thang, nam, tenKhachHang, maPhong, donGia);
        this.soGio = soGio;
    }

    // Getter và Setter cho thuộc tính
    public int getSoGio() {
        return soGio;
    }

    public void setSoGio(int soGio) {
        this.soGio = soGio;
    }

    // Phương thức nhập thông tin hóa đơn theo giờ
    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số giờ: ");
        soGio = scanner.nextInt();
    }
}

// Lớp HoaDonTheoNgay kế thừa từ lớp HoaDon
class HoaDonTheoNgay extends HoaDon {
    private int soNgay;

    // Constructor không có tham số
    public HoaDonTheoNgay() {
    }

    // Constructor có tham số
    public HoaDonTheoNgay(String maHoaDon, int ngay, int thang, int nam, String tenKhachHang, String maPhong, double donGia, int soNgay) {
        super(maHoaDon, ngay, thang, nam, tenKhachHang, maPhong, donGia);
        this.soNgay = soNgay;
    }

    // Getter và Setter cho thuộc tính
    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    // Phương thức nhập thông tin hóa đơn theo ngày
    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số ngày: ");
        soNgay = scanner.nextInt();
    }
}

// Lớp quản lý danh sách khách hàng
class QuanLyKhachHang {
    private HoaDon[] danhSachHoaDon;
    private int soLuongHoaDon;

    // Constructor
    public QuanLyKhachHang(int capacity) {
        danhSachHoaDon = new HoaDon[capacity];
        soLuongHoaDon = 0;
    }

    // Phương thức thêm hóa đơn vào danh sách
    public void themHoaDon(HoaDon hoaDon) {
        danhSachHoaDon[soLuongHoaDon] = hoaDon;
        soLuongHoaDon++;
    }

    // Phương thức tính tổng số lượng hóa đơn theo loại
    public void tinhTongSoLuongHoaDon() {
        int soLuongHoaDonTheoGio = 0;
        int soLuongHoaDonTheoNgay = 0;

        for (int i = 0; i < soLuongHoaDon; i++) {
            if (danhSachHoaDon[i] instanceof HoaDonTheoGio) {
                soLuongHoaDonTheoGio++;
            } else if (danhSachHoaDon[i] instanceof HoaDonTheoNgay) {
                soLuongHoaDonTheoNgay++;
            }
        }

        System.out.println("Số lượng hóa đơn thuê theo giờ: " + soLuongHoaDonTheoGio);
        System.out.println("Số lượng hóa đơn thuê theo ngày: " + soLuongHoaDonTheoNgay);
    }

    // Phương thức tính trung bình thành tiền cho hóa đơn thuê phòng
    public void tinhTrungBinhThanhTien() {
        double tongThanhTien = 0;
        int soLuongHoaDonThuPhong = 0;

        for (int i = 0; i < soLuongHoaDon; i++) {
            if (!(danhSachHoaDon[i] instanceof HoaDonTheoGio) && !(danhSachHoaDon[i] instanceof HoaDonTheoNgay)) {
                tongThanhTien += danhSachHoaDon[i].getDonGia();
                soLuongHoaDonThuPhong++;
            }
        }

        if (soLuongHoaDonThuPhong > 0) {
            double trungBinhThanhTien = tongThanhTien / soLuongHoaDonThuPhong;
            System.out.println("Trung bình thành tiền cho hóa đơn thuê phòng: " + trungBinhThanhTien);
        } else {
            System.out.println("Không có hóa đơn thuê phòng để tính trung bình thành tiền.");
        }
    }

    // Phương thức xuất danh sách thông tin hóa đơn cho các khách hàng
    public void xuatDanhSachHoaDon() {
        for (int i = 0; i < soLuongHoaDon; i++) {
            System.out.println("Thông tin hóa đơn thứ " + (i + 1) + ":");
            danhSachHoaDon[i].output();
            System.out.println();
        }
    }
}

// Lớp chứa hàm main để chạy chương trình
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng hóa đơn: ");
        int capacity = scanner.nextInt();
        QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang(capacity);

        // Nhập danh sách thông tin hóa đơn cho các khách hàng
        for (int i = 0; i < capacity; i++) {
            System.out.println("Nhập thông tin cho hóa đơn thứ " + (i + 1) + ":");
            System.out.print("Loại hóa đơn (1 - Hóa đơn theo giờ, 2 - Hóa đơn theo ngày, khác - Hóa đơn thuê phòng): ");
            int loaiHoaDon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng new line

            if (loaiHoaDon == 1) {
                HoaDonTheoGio hoaDonTheoGio = new HoaDonTheoGio();
                hoaDonTheoGio.input();
                quanLyKhachHang.themHoaDon(hoaDonTheoGio);
            } else if (loaiHoaDon == 2) {
                HoaDonTheoNgay hoaDonTheoNgay = new HoaDonTheoNgay();
                hoaDonTheoNgay.input();
                quanLyKhachHang.themHoaDon(hoaDonTheoNgay);
            } else {
                HoaDon hoaDon = new HoaDon();
                hoaDon.input();
                quanLyKhachHang.themHoaDon(hoaDon);
            }

            System.out.println();
        }

        // Xuất danh sách thông tin hóa đơn cho các khách hàng
        System.out.println("Danh sách thông tin hóa đơn cho các khách hàng:");
        quanLyKhachHang.xuatDanhSachHoaDon();

        // Tính tổng số lượng hóa đơn theo loại
        quanLyKhachHang.tinhTongSoLuongHoaDon();

        
        // Tính trung bình thành tiền cho hóa đơn thuê phòng
        quanLyKhachHang.tinhTrungBinhThanhTien();
    }
}