# SpringBoot Document
## Controller

<p>Get all users using GET method</p>

```java
@GetMapping('/users')
public ResponseEntity<?> getAllUsers() {
    return userServices.getAllUsers();
}
```

<p></p>

### 4. Mẹo Nhỏ Để README Thu Hút Hơn
* **Thêm Visual:** Một hình ảnh giao diện hoặc một file GIF demo tính năng sẽ giá trị hơn ngàn lời nói.
* **Giữ sự ngắn gọn:** Đừng viết văn xuôi quá dài dòng. Dùng gạch đầu dòng bất cứ khi nào có thể.
* **Cập nhật thường xuyên:** README lỗi thời (sai lệnh cài đặt) sẽ gây ức chế cho người mới tiếp cận.

Bạn có muốn tôi tạo một file mẫu `README.md` cụ thể cho một loại dự án nào (ví dụ: Web App, Library, hay Tool) không?