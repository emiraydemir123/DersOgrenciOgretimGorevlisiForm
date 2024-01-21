package Services;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;



public class DosyaService {

    public static void kaydet(String dersKodu, String dersIsim, String dersDonem) {
        // Specify the path of the file
        String filePath = "src/Data/ders.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Append the input values to the file
            writer.write("Ders Kodu: " + dersKodu + ",Ders Isim: " + dersIsim + ",Ders Donem: " + dersDonem );
            writer.newLine(); // Move to the next line for the next entry
            System.out.println("Veriler dosyaya kaydedildi."); // Optional: Print a message
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., log it or show an error message)
        }
    }
    public void kaydet2(String ogrenciNo, String ogrenciAd, String ogrenciSoyad, String ogrenciBolum, String ogrenciDers) {
        // Specify the path of the file
        String filePath = "src/Data/ogrenci.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Append the input values to the file
            writer.write("Ogrenci No: " + ogrenciNo + "\tOgrenci Ad: " + ogrenciAd + "\tOgrenci Soyad: " + ogrenciSoyad + "\tOgrenci Dersi: " + ogrenciDers + "\tOgrenci Bölümü; " + ogrenciBolum);
            writer.newLine(); // Move to the next line for the next entry
            System.out.println("Veriler dosyaya kaydedildi."); // Optional: Print a message
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., log it or show an error message)
        }
    }
    public void kaydet3(String OgretmenNo, String Ad, String Soyad, String Bolum) {
        // Specify the path of the file
        String filePath = "src/Data/OgretimGorevlisi.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Append the input values to the file
            writer.write("Ogretmen No: " + OgretmenNo + "\tOgretmen Ad: " + Ad + "\tOgretmen Soyad: " + Soyad + "\tOgretmen Bölümü; " + Bolum);
            writer.newLine(); // Move to the next line for the next entry
            System.out.println("Veriler dosyaya kaydedildi."); // Optional: Print a message
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., log it or show an error message)
        }
    }

    public static List<String> getDersIsimList(String s) {
        List<String> dersIsimList = new ArrayList<>();
        String filePath = "src/Data/ders.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line based on commas and get the Ders Isim value
                String[] parts = line.split(",");
                for (String part : parts) {
                    if (part.startsWith("Ders Isim:")) {
                        // Extract and add the Ders Isim value to the list
                        dersIsimList.add(part.substring("Ders Isim: ".length()));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return dersIsimList;
    }


    public static List<String[]> dersBilgileriniGetir(String dosyaYolu) {
        List<String[]> dersListesi = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaYolu))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dersBilgileri = line.split(",");
                for (int i = 0; i < dersBilgileri.length; i++) {
                    // Temizleme işlemleri: Örneğin, baştaki ve sondaki boşlukları kaldırabilirsiniz.
                    dersBilgileri[i] = dersBilgileri[i].trim();
                }
                dersListesi.add(dersBilgileri);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Hata durumunu ele alabilirsiniz: loglama, hata mesajı gösterme, vb.
        }

        return dersListesi;
    }
    public static void main(String[] args) {
        DosyaService dosyaService = new DosyaService();
        List<String> dersIsimList = dosyaService.getDersIsimList("src/Data/ders.txt");

        // Print the Ders Isim values
        System.out.println("Ders Isim Listesi:");
        for (String dersIsim : dersIsimList) {
            System.out.println(dersIsim);
        }
    }

}