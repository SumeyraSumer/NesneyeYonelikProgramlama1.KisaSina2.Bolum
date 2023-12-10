import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

// Nesneye Yönelik Programlama Dersi Kısa Sınav 1.2 Ödevi
// Sümeyra Sümer
// 5210505067

class CustomButtonApp {
    private static final int GRID_SIZE = 4; // Buton ekranı boyutlarını belirtir.

    // Bu HashMap buton durumlarını takip etmek için kullanılır.
    static Map<CustomButton, Boolean> buttonStates = new HashMap<>();

    // Bu HttpClient, HTTP istekleri için kullanılır.
    static HttpClient httpClient = HttpClient.newHttpClient();

    // Ana uygulama fonksiyonu.
    public static void main(String[] args) {
        // Ana pencere.
        JFrame frame = new JFrame("Button Kontrol Paneli");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250); // Her bir butonun boyutu.


        System.out.println("Nesneye Yönelik Programlama Dersi Kısa Sınav 1.2 Ödevi");
        System.out.println("Sümeyra Sümer");
        System.out.println("5210505067");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Yukarıdaki panelden istediğiniz kadar buton seçebilirsiniz...");
        System.out.println(".............................................................................");
        System.out.println("Panelde seçilen her bir buton öncesinde pasif(mavi renkte) ise seçildiğinde aktif(pembe renkte) olacaktır.\nEğer aktif(pembe renkte) olan bir buton tekrar seçilirse bu buton aktif\n(pembe renkte) kalır diğer tüm butonlar pasif(mavi renkte) olacaktır.");
        System.out.println("Basılan her buton için hayali bir GraphQL şemasında bir mutation çalıştırılır.");
        System.out.println(".............................................................................");
        System.out.println("");


        // Butonları içeren panel.
        JPanel panel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));

        // Belirlenen boyutta bir buton grid'i.
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                CustomButton button = new CustomButton("");
                button.setGraphQLSchema("http://example.com/graphql");
                button.setMutationData("mutation { addData(data: \\\"Sample Data\\\") { success message } }");
                panel.add(button);
                buttonStates.put(button, false);
            }
        }

        // Panel ana çerçeveye eklendi ve görünür hale getirildi.
        frame.add(panel);
        frame.setVisible(true);
    }
}

// Özel JButton sınıfı olan CustomButton.
class CustomButton extends JButton implements ActionListener {
    // Butonun aktif ve pasif renkleri.
    private Color activeColor = Color.PINK;
    private Color passiveColor = Color.BLUE;

    // Butonun aktif ve pasif ikonları.
    private Icon activeIcon = createIcon(Color.GREEN, 10, 10); // Aktif ikon
    private Icon passiveIcon = createIcon(Color.RED, 10, 10); // Pasif ikon

    // GraphQL şema URL'si ve mutasyon verisi.
    private String graphQLSchema; // GraphQL URL.
    private String mutationData; // GraphQL mutation sorgusu.

    // Kurucu metot.
    public CustomButton(String text) {
        super(text);
        this.setBackground(passiveColor);
        this.setIcon(passiveIcon);
        this.addActionListener(this);
    }

    // Buton tıklandığında gerçekleşen olay.
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean currentState = CustomButtonApp.buttonStates.get(this);
        if (currentState) {
            // Buton zaten aktifse, diğer butonları pasifleştirir.
            deactivateAllButtonsExcept(this);
        } else {
            // Butonu aktif hale getirir ve GraphQL mutasyonunu gerçekleştirir.
            this.setBackground(activeColor);
            this.setIcon(activeIcon);
            CustomButtonApp.buttonStates.put(this, true);
            performGraphQLMutation();
        }
    }

    // Verilen buton haricindeki tüm butonları pasifleştirir.
    private void deactivateAllButtonsExcept(CustomButton activeButton) {
        for (CustomButton button : CustomButtonApp.buttonStates.keySet()) {
            if (button != activeButton) {
                button.setBackground(passiveColor);
                button.setIcon(passiveIcon);
                CustomButtonApp.buttonStates.put(button, false);
            }
        }
    }

    // GraphQL şema URL'sini ayarlama metodu.
    public void setGraphQLSchema(String schema) {
        this.graphQLSchema = schema;
    }

    // GraphQL mutasyon verisini ayarlama metodu.
    public void setMutationData(String data) {
        this.mutationData = data;
    }

    // GraphQL mutasyonunu gerçekleştirme metodu.
    private void performGraphQLMutation() {
        // JSON formatında istek oluşturur.
        String jsonRequest = String.format("{\"query\": \"%s\"}", mutationData);

        // HTTP isteği oluşturma.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(graphQLSchema))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();

        // Asenkron HTTP isteği gönderme ve cevap alma.
        CustomButtonApp.httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }

    // Basit ikon oluşturma metodu.
    private Icon createIcon(Color color, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(color);
        g2d.fillRect(0, 0, width, height);
        g2d.dispose();
        return new ImageIcon(image);
    }
}
