package iyteyazilim.projects.haydos.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping
public class FeedingController {
    /***Java'da yerel tarihi ve saat bilgisini almak için java.time paketini kullanabilirsiniz. Özellikle LocalDateTime sınıfı, yerel tarih ve saati almanıza olanak tanır. Aşağıda Java'da yerel tarihi ve saati JSON formatında nasıl döndürebileceğinizi gösteren bir örnek bulunmaktadır.

     Java'da Yerel Tarih ve Saat Almak
     java
     Copy code
     import java.time.LocalDateTime;
     import java.time.format.DateTimeFormatter;
     import org.springframework.http.ResponseEntity;
     import org.springframework.web.bind.annotation.GetMapping;
     import org.springframework.web.bind.annotation.RestController;

     @RestController
     public class DateController {

     @GetMapping("/local-date")
     public ResponseEntity<String> getLocalDate() {
     LocalDateTime now = LocalDateTime.now(); // Yerel tarih ve saat
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
     String formattedDate = now.format(formatter); // Formatlı tarih ve saat

     return ResponseEntity.ok("{\"localDate\": \"" + formattedDate + "\"}");
     }
     }
     Açıklamalar:
     LocalDateTime.now(): Bu metod, sistemin yerel tarih ve saatini alır.
     DateTimeFormatter: Bu sınıf, tarih ve saat bilgisini belirli bir formatta döndürmenize olanak sağlar. Yukarıdaki örnekte format "yyyy-MM-dd HH:mm:ss" olarak belirlenmiştir.
     ResponseEntity: JSON formatında yanıt döndürmek için kullanılır. "{\"localDate\": \"" + formattedDate + "\"}" şeklinde bir JSON string oluşturulmuştur.
     Örnek JSON Çıktısı
     Yukarıdaki metodu çağırdığınızda, aşağıdaki gibi bir JSON çıktısı alırsınız:

     json
     Copy code
     {
     "localDate": "2024-10-10 15:00:00"
     }
     Bu şekilde, Java'da yerel tarihi ve saati alabilir ve JSON formatında döndürebilirsiniz!


     ChatGPT can make mistakes. Check important info.**/

}
