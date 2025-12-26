package StudentManager;

import java.util.*;
import java.util.stream.Collectors;

public class QuanLiSinhVien {
    private final List<SinhVien> sinhViens;

    public QuanLiSinhVien() {
        this.sinhViens = new ArrayList<>();
    }

    public List<SinhVien> getSinhViens() {
        return sinhViens;
    }


    /**
     * (chọn 2 câu để làm hoặc làm hết)
     * Lọc danh sách
     * - Lọc ra những sinh viên có điểm trung bình từ n đưa vào trở lên
     * - Lọc ra sinh viên có khoa quản lí
     * - Lọc ra sinh viên thuộc ngành nào đó
     * - Lọc ra sinh viên có cùng last name (ví dụ Ngô Gia Huy thì lấy tên Huy)
     * - Lọc ra sinh viên tưừng đi học vào ca 5
     *
     * Tìm
     * - Tìm sinh viên có mssv yêu cầu
     * - Tìm ra sinh viên có điểm trung bình cao nhất
     * - Tìm ra sinh viên có điểm trung bình thấp nhất
     *
     * Thống kê
     * - Thống kê ds sinh viên theo khoa
     * - Thống kê ds sinh viên theo khoa (xắp xếp sinh viên theo mssv)
     * - Thống kê ds sinh viên theo ngaành
     * - Thống kê ds sinh viên theo ngaành (xắp xếp sinh viên theo mssv)
     * - Thống kê ds sinh viên theo ngày trong tuần học
     * - Thống kê ds sinh viên theo ngày trong tuần học (xáp xếp sv theo mssv)
     *
     * Đếm
     * - Yêu cầu như mấy câu thống kê trên
     *
     * Xắp xếp
     * - theo mssv (tăng hoặc giảm)
     * - theo điểm tb tổng (tăng hoặc giảm)
     */

    public List<SinhVien> sortBy() {
        var c = Comparator
                .comparing(SinhVien::getHoVaTen)
                .thenComparing(SinhVien::trungBinhMon)
                .reversed();

        return sinhViens
                .stream()
                .sorted(c)
                .toList();
    }


    public Map<String, Set<SinhVien>> thongkesinhvientheonganhtangdan() {
        var comp = Comparator.comparing(SinhVien::getHoVaTen);
        TreeSet<SinhVien> s = new TreeSet<>(comp);
        return sinhViens
                .stream()
                .collect(
                        Collectors.groupingBy(
                                SinhVien::getNganhHoc,
                                Collectors.toCollection(() -> s)));
    }

    public List<SinhVien> filterStudentByLastName(String lastName) {
        return sinhViens
                .stream()
                .filter(sinhVien -> sinhVien.sameLastName(lastName))
                .toList();
    }


    public List<SinhVien> locSinhVienDiHocCa5() {
        return sinhViens
                .stream()
                .filter(
                        sinhVien -> sinhVien.getMonDangKis()
                                .stream()
                                .anyMatch(monDangKi -> monDangKi
                                        .getCaHoc()
                                        .getThoiGianHoc()
                                        .equals(ThoiGianHoc.CA_5))
                )
                .toList();
    }

    public Map<String, Set<SinhVien>> thongkesinhvientheonganhoc() {
        return sinhViens
                .stream()
                .filter(sinhVien -> sinhVien.trungBinhMon() >= 8.5)
                .collect(Collectors.groupingBy(
                        SinhVien::getNganhHoc,
                        TreeMap::new,
                        Collectors.toCollection(
                            () -> new TreeSet<>(Comparator.comparing(SinhVien::getMssv, Comparator.reverseOrder()))
                        )
                ));
    }


    /**
     * ═══════════════════════════════════════════════════════════════════════════
     * CÁC BÀI TẬP JAVA 8 NÂNG CAO (⚠ ĐỘ KHÓ CAO)
     * ═══════════════════════════════════════════════════════════════════════════
     */

    /**
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ 1. THỐNG KÊ & PHÂN TÍCH PHỨC TạP                                        │
     * └─────────────────────────────────────────────────────────────────────────┘
     */

    /**
     * Thống kê sinh viên theo khoa, nhưng chỉ lấy top 3 sinh viên có điểm cao nhất mỗi khoa
     * Return: Map<String (Khoa), List<SinhVien> (Top 3 theo điểm TB)>
     */
    public Map<String, List<SinhVien>> thongKeTop3SinhVienTheoKhoa() {
        return sinhViens
                .stream()
                .collect(
                        Collectors.groupingBy(
                                SinhVien::getKhoa,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        l -> l.stream()
                                                .sorted(Comparator.comparing(SinhVien::trungBinhMon))
                                                .limit(3)
                                                .collect(Collectors.toList())
                                )
                        )
                );
    }

    /**
     * Tìm sinh viên có số môn đăng ký nhiều nhất và trả về kèm số lượng môn
     * Return: Map.Entry<SinhVien, Long> (Sinh viên và số môn đã đăng ký)
     */
    public Map.Entry<SinhVien, Long> sinhVienDangKyNhieuMonNhat() {
        return null;
    }

    /**
     * Phân loại sinh viên thành các nhóm: Xuất sắc (>=9), Giỏi (>=8), Khá (>=7), TB (>=5), Yếu (<5)
     * Mỗi nhóm sắp xếp sinh viên theo điểm giảm dần
     * Return: Map<String (Xếp loại), List<SinhVien> (Đã sắp xếp)>
     */
    public Map<String, List<SinhVien>> phanLoaiSinhVienTheoHocLuc() {
        return sinhViens
                .stream()
                .collect(
                        Collectors.groupingBy(
                                sinhVien -> {
                                    if (sinhVien.trungBinhMon() >= 9) {
                                        return "Excellent";
                                    } else if (sinhVien.trungBinhMon() >= 8) {
                                        return "Best";
                                    } else if (sinhVien.trungBinhMon() >= 6.5) {
                                        return "Cool";
                                    } else if (sinhVien.trungBinhMon() >= 5) {
                                        return "Middle";
                                    }
                                    return "Bad";
                                }
                        )
                );
    }

    /**
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ 3. TÍNH TOÁN & THỐNG KÊ SÂU                                             │
     * └─────────────────────────────────────────────────────────────────────────┘
     */

    /**
     * Tính điểm trung bình chung của từng khoa (trung bình điểm TB của tất cả sinh viên trong khoa)
     * Return: Map<String (Khoa), Double (ĐTB chung của khoa)>
     */
    public Map<String, Double> diemTrungBinhTheoKhoa() {
        return sinhViens
                .stream()
                .collect(Collectors.groupingBy(
                        SinhVien::getNganhHoc,
                        Collectors.averagingDouble(SinhVien::trungBinhMon)));
    }

    /**
     * Tìm khoa có điểm trung bình cao nhất
     * Return: Map.Entry<String (Khoa), Double (Điểm TB)>
     * ⚠ Khó: Kết hợp tính TB theo khoa + tìm max
     */
    public Map.Entry<String, Double> khoaCoĐiemCaoNhat() {
        return diemTrungBinhTheoKhoa()
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();
    }

    public List<MonDangKi> getMonDangKi() {
        return sinhViens
                .stream()
                .flatMap(sinhVien -> sinhVien.getMonDangKis().stream())
                .toList();
    }

    /**
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ 4. XẮP XẾP & LỌC NÂNG CAO                                               │
     * └─────────────────────────────────────────────────────────────────────────┘
     */

    /**
     * Xắp xếp sinh viên theo nhiều tiêu chí:
     * 1. Điểm TB giảm dần
     * 2. Nếu điểm bằng nhau -> Số môn đăng ký giảm dần
     * 3. Nếu vẫn bằng -> MSSV tăng dần
     * Return: List<SinhVien> (Đã sắp xếp)
     */
    public List<SinhVien> sapXepDaNangTheoNhieuTieuChi() {
        return sinhViens
                .stream()
                .sorted(Comparator
                        .comparing(SinhVien::trungBinhMon)
                        .reversed()
                        .thenComparing(SinhVien::soMonDangKy)
                        .reversed()
                        .thenComparing(SinhVien::getMssv))
                .toList();
    }

    /**
     * Lọc ra các sinh viên "siêu sao" thỏa mãn TẤT CẢ điều kiện:
     * - Điểm TB >= 8.5
     * - Đăng ký ít nhất 5 môn
     * - Có ít nhất 1 môn thực hành
     * - Không có môn nào rớt (điểm < 4.0)
     * Return: List<SinhVien>
     */
    public List<SinhVien> locSinhVienSieuSao() {
        return sinhViens
                .stream()
                .filter(
                        s -> s.trungBinhMon() >= 8.5 &&
                                s.getMonDangKis().size() >= 5 &&
                                s.getMonDangKis()
                                        .stream()
                                        .anyMatch(monDangKi -> monDangKi
                                                .getMonHoc()
                                                .getMonThucHanh() != null) &&
                                s.getMonDangKis()
                                        .stream()
                                        .noneMatch(
                                                monDangKi -> monDangKi.getDiemTrungBinhTongKet() < 4)
                )
                .toList();
    }

    /**
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ 5. PARTITIONING & CUSTOM COLLECTORS                                     │
     * └─────────────────────────────────────────────────────────────────────────┘
     */

    /**
     * Phân chia sinh viên thành 2 nhóm: Đạt (>=5.0) và Không đạt (<5.0)
     * Mỗi nhóm sắp xếp theo điểm TB
     * Return: Map<Boolean (true=Đạt, false=Không đạt), List<SinhVien>>
     */
    public Map<Boolean, List<SinhVien>> phanChiaSinhVienDatVaKhongDat() {
        return null;
    }

    /**
     * Tạo báo cáo tổng hợp chi tiết cho từng ngành:
     * - Tổng số sinh viên
     * - Điểm TB chung
     * - Sinh viên có điểm cao nhất
     * - Sinh viên có điểm thấp nhất
     * Return: Map<String (Ngành), String (Báo cáo text)>
     * ⚠ Rất khó: Cần kết hợp nhiều operation
     */
    public Map<String, String> taoBaoCaoChiTietTheoNganh() {
        // TODO: Implement this method
        return null;
    }

    /**
     * Tìm những cặp sinh viên (pair) có điểm trung bình gần nhau nhất (chênh lệch < 0.5 điểm)
     * và cùng khoa
     * Return: List<String> (Format: "MSSV1 - MSSV2: chênh lệch X điểm")
     * ⚠ Cực khó: Cần so sánh từng cặp sinh viên với nhau
     */
    public List<String> timCapSinhVienDiemGanNhau() {
        // TODO: Implement this method
        return null;
    }

}
