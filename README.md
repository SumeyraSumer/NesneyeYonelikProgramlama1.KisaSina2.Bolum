# NesneyeYonelikProgramlama1.KisaSina2.Bolum
4x4 bir buton ekranı tasarlanmıştır. HashMap kullanılarak buton durumları takip edilmektedir. “HttpClient” ile http işlemlerini işlemlerini gerçekleştirmek için kullanılacak bir örnek oluşturur. Bu, kod içerisinde birçok yerde aynı örneği kullanmak istediğimizde kullanılışlıdır. Butonun aktif ve pasif olduğunu belirtmek üzere 2 farklı renk, ikon ve bu ikonlara da 2 farklı renk verilmiştir. Butonun pasif olduğu durumda buton rengi mavi, ikon rengi kırmızı, butonun aktif olduğu durumda buton rengi pembe, ikon rengi yeşil olarak tanımlanmıştır. “graphQLSchema” “CustomButton” sınıfında GraphQL şemasının saklanması için kullanılır. “mutationData” “CustomButton” sınıfında bir GraphQL mutation sorgusunun saklanması için kullanılır. Bu özelliklerin ‘private’ olması, sınıf dışından doğrudan erişimlerini engeller ve bu özelliklere sadece sınıf içinde tanımlanan metotlar aracılığıyla erişilebilir. Her buton Java GUI butondan override edilerek oluşturulmuştur. Basılacak buton aktif ise kendisi haricindeki diğer butonları pasif hale getirir, eğer pasif ise aktif hale gelir ve GraphQL mutasyonunu gerçekleştirir. 
 GraphQL Facebook tarafından 2012 yılında geliştirilmiştir. Açık kaynak kodlu veri sorgulama ve işleme dilidir ve bu sorguları yerine getirmek için yazılmış bir uygulamadır. Temel amacı verileri özelleştirebilmelerini sağlamaktır. Verilerin yapısının tanımlanmasına olanak tanır ve veriler tanımlanan yapıda sunucudan döndürülür. Yalnızca istenilen verileri belirten bir sorgu gönderilir ve sunucu yalnızca istenilen verileri yapar. Bu ağ trafiğini azaltır, eksik veya aşırı veri alımını engeller. GraphQL’de tek bir endpoint vardır ve sorgular bunun üzerinden yapılır. API’nin (Application Programming Interface: Teorik olarak anlatmak gerekirse; kendine özgü veri ve prensiplere sahip olan, süreçleri hızlandırarak gereksiz code complexity’i yansıtmayan, uygulamaların birbirleri ile iletişim halinde olmasını sağlayan bir mimari çözümdür.) öngörülebilir olmasını sağlar. GraphQL servisleri, kullanılabilir veri modellerini tanımlayan bir şemaya sahiptir. Şema veri türlerinin, sorguların ve mutasyonların kullanılabileceğini belirtir. İstemciler, sadece ihtiyaç duydukları veriyi almak için özelleştirilmiş sorgular yapabilirler. Bu, aşırı veri transferini önler. GraphQL sorguları yalnızca veri alımı için değil aynı zamanda veri değişiklikleri için de kullanılabilir. Bu ‘mutasyonlar’ olarak adlandırılır ve sunucu tarafındaki veriyi değiştirmek için kullanılır. GraphQL çok sayıda ilişkisel veri kaynağını birleştirmek için uygundur. İstemci, ihtiyacı olan tüm veriyi tek bir sorguda alabilir. Bu yüzden GraphQL farklı istemcilerin ihtiyaçlarına uygun ve verimli bir şekilde hizmet verebilmek için özellikle büyük ve karmaşık uygulamalarda tercih edilir. Örneğin:
type Book {
    baslik: String
    yazar: String
}
type Query {
    kitaplar: [Book]
}
 Burada ‘book’ her kitabın bir başlık ve yazar özelliğini içerir. ‘Query’ sorguların yapıldığı bölümdür. Bu sorgu tüm kitapları getirir. Bu şema, GraphQL sorgularının nasıl yapılandırılacağını tanımlar. Örneğin, tüm kitapları almak için şu sorguyu yapabiliriz:
query {
  kitaplar {
      başlık
      yazar
   }
}
 Bu sorgu, sunucudan tüm kitapları ve her bir kitabın başlık ve yazarını alır. 
 Yazdığım kod çalıştırıldığında buton kontrol paneli açılır. 16 adet mavi buton ve bu butonların her birinin içerisinde kırmızı renkli kare ikon bulunur. Bu butonlar pasif durumdadır. İstediğimiz kadar butona basabiliriz. Bastığımızda butonlar pembe rengini alır ve içerisindeki kare ikonlar ise yeşil rengini alır. Bu renkler butonun aktif olduğunu belirtir. Bastığımız (aktifleştirdiğimiz) her buton için hayali bir GraphQL şemasında bir mutation çalıştırılır. Bastığımız her bir buton için ayrı ayrı bir mutation custombuttonapp’de (run araç penceresi konsol çıktısı) yazar. Daha sonra birden çok buton aktif halde iken basılan başka bir buton da aktif ise, basılan buton dışındaki bütün aktif haldeki butonlar pasif hale gelir. Basılan ve diğerlerinin pasif hale gelmesini sağlayan buton aktif kalır.


https://github.com/SumeyraSumer/NesneyeYonelikProgramlama1.KisaSina2.Bolum/assets/126922628/feaaf199-4fdc-48d2-964c-9e763f552a3c


https://github.com/SumeyraSumer/NesneyeYonelikProgramlama1.KisaSina2.Bolum/assets/126922628/e0ab07d9-c0b3-4a93-a077-7bc4e3a07c93

![nyp1](https://github.com/SumeyraSumer/NesneyeYonelikProgramlama1.KisaSina2.Bolum/assets/126922628/54a6cf52-390d-4027-9b5f-13a7a82953bc)

![nyp2](https://github.com/SumeyraSumer/NesneyeYonelikProgramlama1.KisaSina2.Bolum/assets/126922628/ef8552e5-4537-4816-943e-fa1fe24d8ead)

![basılan her buton için mutasyon](https://github.com/SumeyraSumer/NesneyeYonelikProgramlama1.KisaSina2.Bolum/assets/126922628/ea74e305-2e5a-4c46-9b19-2998b9b9d254)





