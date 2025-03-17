# Child Vaccine Schedule Tracking System

## Giới thiệu

Hệ thống theo dõi lịch tiêm chủng cho trẻ em giúp quản lý lịch tiêm chủng và cung cấp thông tin về vaccine. Hệ thống này cho phép người dùng đăng ký, đăng nhập, đặt lịch tiêm chủng, xem danh sách vaccine và thông tin giới thiệu về hệ thống.

## Các tính năng chính

- Đăng ký người dùng
- Đăng nhập người dùng
- Đặt lịch tiêm chủng
- Xem danh sách vaccine
- Trang giới thiệu về hệ thống
- Bảng điều khiển cho quản trị viên

## Cấu trúc dự án

- `src/main/java/edu/uth/childvaccinesystem/controllers`: Chứa các controller xử lý các yêu cầu HTTP.
- `src/main/java/edu/uth/childvaccinesystem/models`: Chứa các lớp mô hình (entities).
- `src/main/java/edu/uth/childvaccinesystem/repositories`: Chứa các repository để tương tác với cơ sở dữ liệu.
- `src/main/java/edu/uth/childvaccinesystem/services`: Chứa các service để xử lý logic nghiệp vụ.
- `src/main/resources/templates`: Chứa các file HTML sử dụng Thymeleaf.
- `src/main/resources/css`: Chứa các file CSS để định dạng giao diện.

## Cài đặt và chạy dự án

### Yêu cầu hệ thống

- Java 17
- Maven 3.6+
- MySQL

### Cấu hình cơ sở dữ liệu

Cập nhật thông tin kết nối cơ sở dữ liệu trong file `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/childvaccinesystem
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp

spring.application.name=restapi
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.api-docs.path=/v3/api-docs
server.port=8090
```

### Chạy dự án

#### Sử dụng dòng lệnh

Di chuyển đến thư mục chứa pom.xml, sau đó chạy lại lệnh.

Windows (CMD hoặc PowerShell):
```
cd C:\Users\Xuan Hai\IdeaProjects\ChildVaccineScheduleTrackingSystem
mvn clean install
mvn spring-boot:run
```

#### Sử dụng IDE (IntelliJ IDEA, Eclipse, VS Code, v.v.)

Mở dự án Spring Boot của bạn.
Xác định vị trí lớp chính (Class có chú thích @SpringBootApplication).
Nhấp vào Run hoặc Debug trong IDE của bạn.
