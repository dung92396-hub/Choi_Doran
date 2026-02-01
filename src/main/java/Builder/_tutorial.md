## Mẫu ``Builder``
<hr>

### Mục lục
- [Vấn đề phổ thông](#vấn-đề)
- [Mẫu Builder](#mẫu-builder)
- [Ví dụ mẫu Bulder](#ví-dụ-mẫu-bulider)
- [Nhược điểm](#nhược-điểm)

### Vấn đề
<hr>

Trong lập trình hướng đối tượng, bạn tạo một class `User` có quá nhiều thuộc tính và gây ra những bất tiện như
- Không nhớ được hết tên thuộc tính
- Không nhớ thứ tự truyền vào constructor
- Set thủ công từng thuộc tính sau khi tạo đối tượng, ví dụ `setName("Nguyen van A")`

Code:
```java
public class User {
    private Long id;
    private String fullName;
    private LocalDate birthday;
    private String ethnic;
    private Education education;
    private String religion;
    private Double salaryPerYear;

    public User(Long id, String fullName, LocalDate birthday, String ethnic, Education education, String religion, Double salaryPerYear) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.ethnic = ethnic;
        this.education = education;
        this.religion = religion;
        this.salaryPerYear = salaryPerYear;
    }
    
    // Getter Setter toString
}
```
Và mẫu `Builder` sẽ là giải pháp cho trường hợp này!

### Mẫu `Builder`
<hr>

Mẫu `Bulder` thuộc nhóm mẫu `Creational` đóng vai trò như là một phương pháp giúp khắc phục những vấn đề ở trên, những tiện ích mà `Builder` mang lại như:
- Truyền thuộc tính mà không cần theo thứ tự
- Cho phép truyền những thuộc tính tự chọn, không bắt buộc phải truyền hết

### Ví dụ mẫu `Bulider`
<hr>

Chúng ta quay lại class `User` nhưng ở đây ta tạo một **Inner Class** là `Builder` ngay trong lớp `User`</br>

Code:
```java
public class User {
    private Long id;
    private String fullName;
    private LocalDate birthday;
    private String ethnic;
    private Education education;
    private String religion;
    private Double salaryPerYear;

    // mau builder
    public static class Builder {
        private User user = new User();

        // id va fullName la 2 thuoc tinh bac buoc, con lai la thuoc tinh tu chon
        public Builder(Long id, String fullName) {
            this.user.id = id;
            this.user.fullName = fullName;
        }

        public Builder setBirthday(LocalDate birthday) {
            this.user.birthday = birthday;
            return this;
        }

        public Builder setEthnic(String ethnic) {
            this.user.ethnic = ethnic;
            return this;
        }

        public Builder setEducation(Education education) {
            this.user.education = education;
            return this;
        }

        public Builder setReligion(String religion) {
            this.user.religion = religion;
            return this;
        }

        public Builder setSalaryPerYear(Double salaryPerYear) {
            this.user.salaryPerYear = salaryPerYear;
            return this;
        }

        public User build() {
            return user;
        }
    }

    // getter setter toString
}
```
Sau đó chúng ta gọi đối tượng `User` này ra nhưng với cách khởi tạo khác một chút

Code:
```java
public class Main {
    public static void main(String[] args) {
        User user = new User.Builder(1L, "Hoang Phuc")
                .setEducation(Education.UNIVERSITY)
                .setReligion(null)
                .setEthnic("Kinh")
                .build();
        System.out.println(user);

        User user2 = new User.Builder(2L, "Van Thanh").build();
        System.out.println(user2);
    }
}
```
Như vậy việc khởi tạo đã đơn giản hơn phần nào

### Nhược điểm
<hr>

Mặc dù vậy `Bulider` vẫn có các **nhược điểm** sau
- Code thiết lập rất dài vì khởi tạo `InnerClass` bên trong
- Nếu class rất ít thuộc tính thì việc sử dụng `Builder` trở nên cồng kềnh và ta cũng có thể nhớ được lượng thuộc tính đó nên việc sử dụng `Builder` là không cần thiết
>**Mẹo**<br>
Để trách việc setup mẫu rườm rà, ta có thể dùng `@Bulider`  để đơn giản hoá quá trình thiết lập và đi kèm `@Data` để sinh `Getter`,`Setter` tự động từ thư viện `Lombok`
> 
Code:
 ```java
@Data
@Builder
public class UserCollapse {
    private Long id;
    private String fullName;
    private LocalDate birthday;
    private String ethnic;
    private Education education;
    private String religion;
    private Double salaryPerYear;
}
```