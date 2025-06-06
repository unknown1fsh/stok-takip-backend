Elbette Sahip. Aşağıda, **yalnızca stok takip backend projen** için özel olarak hazırlanmış, profesyonel düzeyde, özgün ve detaylı bir `README.md` içeriği sunuyorum. Bu içerik, gerçek bir **Senior Full Stack Java Developer** eliyle hazırlanmış gibi tüm detaylarıyla sunulmuştur.

# 🏷️ SmartWorkflow Stok Takip Backend

Java 17 ve Spring Boot tabanlı olarak geliştirilen bu backend uygulaması, kurumların malzeme, demirbaş ve depo hareket süreçlerini dijitalleştirerek izlenebilir, denetlenebilir ve genişletilebilir bir altyapı sunar. Katmanlı mimari, RESTful servisler, DTO kullanımı ve transactional servis mantığıyla modern ve sürdürülebilir bir yapı hedeflenmiştir.

---

## 📌 Proje Amacı

Bu uygulama, aşağıdaki temel hedefleri gerçekleştirmek için geliştirilmiştir:

- 🧾 Depo giriş, çıkış, iade ve hurda işlemlerinin yönetimi  
- 🏷️ Malzeme (stok) kartlarının oluşturulması ve takibi  
- 🔐 Kullanıcı rolleriyle yetkilendirilmiş işlem akışları  
- 🔄 Zimmet, terkin ve sayım işlemlerinin dijital yürütülmesi  
- 🗃️ Veritabanı işlemlerinde tam izlenebilirlik (audit)  


## 🧰 Kullanılan Teknolojiler

| Katman        | Teknoloji / Kütüphane |
|---------------|------------------------|
| Programlama   | Java 17                |
| Framework     | Spring Boot 3.x        |
| ORM           | Spring Data JPA, Hibernate |
| Veritabanı    | MySQL 8.x              |
| Güvenlik      | Spring Security (hazır) |
| Loglama       | SLF4J, Logback         |
| Audit         | Hibernate Envers       |
| Kodlama Hızlılığı | Lombok             |
| Test Aracı    | Postman (collection mevcut) |


## 🧱 Katmanlı Mimari

```

📦 com.smartworkflow\.stoktakip
├── controller         → REST endpoint'leri
├── service
│   └── impl           → İş mantığı (business logic)
├── repository         → JPA arayüzleri
├── dto               → Dışa açılan veri transfer objeleri
├── entity            → Veritabanı tabloları
├── mapper            → DTO ↔ Entity dönüşümleri
├── enums             → Enum tanımlamaları
├── exception         → Hata yönetimi
├── config            → Uygulama yapılandırmaları
└── util              → Yardımcı sınıflar



## ⚙️ Kurulum Adımları

### 1. Veritabanı Oluştur
sql
CREATE DATABASE stok_takip CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

### 2. `application.properties` Ayarları

properties
spring.datasource.url=jdbc:mysql://localhost:3306/stoktakip
spring.datasource.username=root
spring.datasource.password=12345
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

### 3. Uygulamayı Derleyip Başlat

bash
./mvnw clean install
./mvnw spring-boot:run

## 📦 Öne Çıkan Modüller

| Modül              | Açıklama                                        |
| ------------------ | ----------------------------------------------- |
| 🏷️ `StokKart`     | Malzeme/demirbaş bilgileri                      |
| 📦 `StokHareket`   | Giriş, çıkış, iade, hurda işlemleri             |
| 🏢 `Depo`          | Malzeme hareketlerinin yapıldığı depo bilgileri |
| 👤 `Kullanıcı/Rol` | Role-based yetkilendirme (hazır)                |
| 🔁 `Zimmet`        | Kullanıcıya atama işlemleri                     |
| ❌ `Terkin`         | Malzemenin imha edilmesi                        |
| 🧮 `Sayım`         | Sayım farkı takibi                              |
| 📜 `Audit`         | Tüm değişikliklerin geçmişi                     |

---

## 🔌 API Endpoint Örnekleri

| Endpoint              | Method | Açıklama                        |
| --------------------- | ------ | ------------------------------- |
| `/api/stok-kart`      | GET    | Tüm stok kartlarını getirir     |
| `/api/stok-kart/{id}` | GET    | Belirli stok kartını getirir    |
| `/api/stok-kart`      | POST   | Yeni stok kartı ekler           |
| `/api/stok-hareket`   | POST   | Stok hareketi kaydeder          |
| `/api/depo/{id}`      | DELETE | Depoyu siler (ilişkili değilse) |
| `/api/terkin/toplu`   | POST   | Toplu terkin işlemi             |

---

## 🔐 Güvenlik Katmanı

> Projede Spring Security yapılandırmasına hazır bir temel bulunmaktadır. JWT tabanlı kullanıcı doğrulama ve token üretimi entegre edilebilir.

---

## 🧪 Postman Collection

Tüm endpoint’lerin test edilmesi için `stoktakip_collection.json` dosyası projeyle birlikte verilmiştir.
Import ettikten sonra `localhost:8080` altında test edebilirsiniz.

---

## 💡 Geliştirme Notları

* Tüm servis işlemleri `@Transactional` olarak çalışır
* DTO ↔ Entity dönüşümleri `mapper` klasöründe yapılır (MapStruct opsiyonel)
* Global exception handler `@ControllerAdvice` ile merkezi olarak yönetilir
* Bazı alanlarda `Specification` API ile dinamik filtreleme sağlanır
* Zaman damgası ve kullanıcı izi için `BaseEntity` ve Envers kullanılır
* Soft delete yerine mantıksal `aktifPasif` yapısı tercih edilmiştir

---

## 🔄 Gelecek Sürüm Planları

* 📈 Swagger/OpenAPI entegrasyonu
* 📩 Mail bildirim modülü (onay/ret)
* 🧑‍💼 EBYS ve LDAP servis entegrasyonları
* 🖼️ Demirbaş görsel yükleme ve görüntüleme
* 📊 JasperReports ile gelişmiş rapor çıktıları

---

## 📇 Geliştirici

**Selim Sercan Çınar**
Senior Full Stack Java Developer
💼 \[[LinkedIn Profiliniz](https://www.linkedin.com/in/ssercanc/)]


📝 Lisans

Bu yazılım özel projeler için geliştirilmiştir. Kodun tamamı geliştiriciye aittir ve ticari kullanımı lisansa tabidir.
