package StudentManager;

import java.util.ArrayList;
import java.util.List;

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
}
