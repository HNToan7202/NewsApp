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

  <img src="https://github.com/user-attachments/assets/88c41aa7-f746-42af-aaf2-b4ea6f226477" width="379"/>

  b. Giao diện chi tiết bài viết

 <img src="https://github.com/user-attachments/assets/f6ae092e-2959-4cfb-b4a9-c7909579d3e7" width="379"/>
