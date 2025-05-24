# NewsApp Ứng dụng đọc báo
1. Mục tiêu:
Xây dựng một ứng dụng Android Native đọc tin tức theo API miễn phí.
2. Tính năng:
a. Trang danh sách tin tức:
- Hiển thị danh sách các bài viết: ảnh, tiêu đề, mô tả ngắn
- Tải từ 1 trong các API miễn phí (xem gợi ý bên dưới)
- Xử lý load more
b. Trang chi tiết bài viết:
- Khi nhấn vào bài viết → chuyển sang màn hình chi tiết
- Hiển thị ảnh lớn, tiêu đề, nội dung đầy đủ
3. Công nghệ
- MVVM (ViewModel + LiveData/StateFlow)
- Retrofit
- RecyclerView
- Coroutine
4. Giao diện
  a. Giao diện danh sách tin tức
![image](https://github.com/user-attachments/assets/d397dc8d-4b6a-4ae0-9825-ae3e334d6fc9)
b. Giao diện chi tiết bài viết
![image](https://github.com/user-attachments/assets/6b348ed3-4449-4d41-9c56-520901f9d691)
