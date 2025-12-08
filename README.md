# 💬 MiniChat — Ứng dụng chat nhỏ xíu nhưng đầy sự vô dụng 😎

Chào mừng bạn đến với **MiniChat**, nơi mà:

* Không có bảo mật 🔒
* Không có database 💾
* Không có AI 🤖
* Nhưng **có tình thương** ❤️ (và bug)

## 🧠 MiniChat là gì?

Một cái web chat tự chế bằng **Blazor**.
Dùng để chat? Không.
Dùng để học Blazor? Cũng… không nốt.
**Dùng để flex với bạn bè rằng bạn biết viết WebAssembly** 😤

## ✨ Tính năng đỉnh cao

* Gửi tin nhắn… mà không lưu được 🧨
* Không có tài khoản, ai cũng tên **Anonymous** nếu thích 👻
* Không realtime nhưng trông giống realtime 😭
* UI tự code nhưng nhìn cũng tạm đẹp 😎
* Code ít nhưng bug nhiều 💥

## 🚀 Cách chạy project

1. Clone repo về:

   ```
   git clone https://github.com/ban-tinh-te/minichat.git
   ```

2. Chạy:

   ```
   dotnet run
   ```

3. Mở:
   👉 [http://localhost:42069/chat](http://localhost:42069/chat)
   (port random cho nó sang)

4. Chat một mình như một lập trình viên cô đơn 😔

## 🧩 Cấu trúc project

```
MiniChat/
 ├─ Data/
 │   └─ ChatService.cs  // Nơi lưu tin nhắn vô tri vô giác
 ├─ Pages/
 │   └─ Chat.razor      // Trang chat nhìn như Discord bản lậu
 └─ Shared/
     └─ MainLayout.razor // Layout cho sang
```

## 🤡 Contribute

Pull request được chào đón!
Trừ pull request nào sửa bug — **bug là linh hồn của project**.

## 🏆 Credits

* Tôi: viết code
* Bạn: đọc README này
* Bug: luôn ở đó, âm thầm ủng hộ

## ❤️ Kết luận

MiniChat sinh ra không phải để hữu ích.
Nó sinh ra để **cho bạn cảm giác mình là lập trình viên Blazor chuyên nghiệp**,
mặc dù thật ra bạn chỉ đang gõ vài cái input và gọi vài cái service 😭
