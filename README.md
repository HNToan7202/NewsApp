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
<img width="379" alt="image" src="https://github.com/user-attachments/assets/945661a6-2bf2-45e4-9858-297b2aada163" />

  b. Giao diện chi tiết bài viết
<img width="381" alt="image" src="https://github.com/user-attachments/assets/d626190d-7810-4d18-a634-e97203924a94" />
