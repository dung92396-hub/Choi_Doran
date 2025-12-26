package StudentManager;

import java.util.*;
import java.util.stream.Collectors;

public class SinhVien {
    private Long mssv;
    private String hoVaTen;
    private String nganhHoc;
    private String khoa;
    private final List<MonDangKi> monDangKis;

    public SinhVien(Long mssv, String hoVaTen, String nganhHoc, String khoa) {
        this.mssv = mssv;
        this.hoVaTen = hoVaTen;
        this.nganhHoc = nganhHoc;
        this.khoa = khoa;
        this.monDangKis = new ArrayList<>();
    }

    public boolean containsMonDangKi(MonDangKi monDangKi) {
        return this.monDangKis
                .stream()
                .anyMatch(monDangKi1 -> monDangKi.isSameCode(monDangKi));
    }

    public void addMonDangKi(MonDangKi monDangKi) {
        if (containsMonDangKi(monDangKi)) return;
        this.monDangKis.add(monDangKi);
    }

    /**
     * ═══════════════════════════════════════════════════════════════════════════
     * THỰC HIỆN CÁC YÊU CẦU SAU BẰNG CÚ PHÁP JAVA 8
     * (Chọn 2 câu để viết hoặc viết hết nếu thích)
     * ═══════════════════════════════════════════════════════════════════════════
     *
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ 1. LỌC (FILTER)                                                         │
     * └─────────────────────────────────────────────────────────────────────────┘
     *    • Lọc ra những môn đăng kí có ca thực hành
     *    • Lọc ra những môn đăng kí học vào thứ trong tuần
     *    • Lọc ra những môn đăng kí có điểm trung bình trở lên
     *    • Lọc ra những môn đăng kí rớt (dưới 4.0)
     *    • Lọc ra những môn đăng kí trùng tên giảng viên
     *    • Lọc ra những môn đăng kí có ca học yêu cầu (ca 1, 2, 3, 4 hoặc 5)
     *    • Lọc ra n môn đăng kí có điểm tổng cao nhất
     *    • Lọc ra môn đăng kí có ca học trễ nhất (⚠ khó)
     *
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ 2. MAX / MIN                                                            │
     * └─────────────────────────────────────────────────────────────────────────┘
     *    • Tìm ra môn đăng kí có điểm tổng cao nhất
     *    • Tìm ra môn đăng kí có điểm tổng thấp nhất
     *
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ 3. TÍNH TOÁN (CALCULATION)                                              │
     * └─────────────────────────────────────────────────────────────────────────┘
     *    • Tính tổng trung bình các môn
     *
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ 4. XẮP XẾP (SORTING)                                                    │
     * └─────────────────────────────────────────────────────────────────────────┘
     *    • Xắp xếp các môn đăng kí dựa trên tên môn (tăng dần)
     *    • Xắp xếp các môn đăng kí dựa trên tên môn (giảm dần)
     *    • Xắp xếp các môn đăng kí dựa trên điểm trung bình (tăng dần)
     *    • Xắp xếp các môn đăng kí dựa trên điểm trung bình (giảm dần)
     *    • Xắp xếp các môn đăng kí theo ca học (tăng/giảm dần) (⚠ khó)
     *
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ 5. THỐNG KÊ (GROUP BY)                                                  │
     * └─────────────────────────────────────────────────────────────────────────┘
     *    • Thống kê các môn học đăng kí theo giảng viên
     *    • Thống kê các môn đăng kí theo ca học
     *    • Thống kê các môn đăng kí theo thứ trong tuần
     *
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ 6. ĐẾM (COUNT)                                                          │
     * └─────────────────────────────────────────────────────────────────────────┘
     *    • Đếm các môn đăng kí dựa trên giảng viên dạy
     *    • Đếm các môn đăng kí theo ca học
     *    • Đếm các môn đăng kí theo thứ trong tuần
     *
     * ═══════════════════════════════════════════════════════════════════════════
     */

    public boolean sameLastName(String lastName) {
        String[] str = hoVaTen.split(" ");
        int n = str.length;
        return str[n - 1].equals(lastName);

        // Ngo Gia Huy
        // .split(" ")
        // ["Ngo", "Gia", "Huy"]
        // str[n - 1] = "Huy"
    }

    public int soMonDangKy() {
        return this.monDangKis.size();
    }

    public double trungBinhMon() {
        return monDangKis
                .stream()
                .collect(Collectors.averagingDouble(MonDangKi::getDiemTrungBinhTongKet));
    }

    public List<MonDangKi> xapXepMonTheoCaHoc() {
        return monDangKis
                .stream()
                .sorted((o1, o2) -> o1.comparingTime(o2.getCaHoc()))
                .toList();
    }

    public List<MonDangKi> sort() {
        return monDangKis
                .stream()
                .sorted(Comparator.comparing(
                        MonDangKi::getDiemTrungBinhTongKet)
                        .reversed())
                .toList();
    }

    public Set<MonDangKi> sort2() {
        var comp = Comparator.comparing(
                MonDangKi::getDiemTrungBinhTongKet,
                Comparator.reverseOrder());
        TreeSet<MonDangKi> treeSet = new TreeSet<>(comp);
        return monDangKis
                .stream()
                .collect(Collectors.toCollection(() -> treeSet));
    }


    public Long getMssv() {
        return mssv;
    }

    public void setMssv(Long mssv) {
        this.mssv = mssv;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public List<MonDangKi> getMonDangKis() {
        return monDangKis;
    }

}
