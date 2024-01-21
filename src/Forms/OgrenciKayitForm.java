package Forms;

import Models.Ogrenci;
import Services.DosyaService;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class OgrenciKayitForm extends JFrame {
    private JPanel OgrenciKayitForm;
    private JTextField tfOgrenciNo;
    private JTextField tfOgrenciAd;

    private JTextField tfOgrenciSoyad;
    private JTextField tfOgrenciBolum;
    private JButton btnClear;
    private JButton btnSubmit;
    private JComboBox cbOgrenciDers;
    private JButton btnDersGoster;

    Ogrenci ogrenci = new Ogrenci();
    String ogrenciNo= ogrenci.OgrenciNo;

    String ogrenciAd= ogrenci.OgrenciAd;
    String ogrenciSoyad= ogrenci.OgrenciSoyad;
    String ogrenciDers= ogrenci.OgrenciDers;
    String ogrenciBolum= ogrenci.ogrenciBolum;
    public OgrenciKayitForm() {
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ogrenciNo = tfOgrenciNo.getText();
                ogrenciAd= tfOgrenciAd.getText();
                ogrenciSoyad= tfOgrenciSoyad.getText();
                ogrenciDers = (String) cbOgrenciDers.getSelectedItem();
                ogrenciBolum= tfOgrenciBolum.getText();

                DosyaService dosyaService = new DosyaService();
                dosyaService.kaydet2(ogrenciNo, ogrenciAd, ogrenciSoyad, ogrenciBolum, ogrenciDers);


            }

        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfOgrenciAd.setText("");
                tfOgrenciSoyad.setText("");
                tfOgrenciNo.setText("");
                cbOgrenciDers.setSelectedIndex(-1);
                tfOgrenciBolum.setText("");
            }
        });
        setContentPane(OgrenciKayitForm);
        setTitle("OgrenciKayitForm");
        setMinimumSize(new Dimension(600,500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);



        btnDersGoster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbOgrenciDers.removeAllItems();
                List<String> derslist = DosyaService.getDersIsimList("src/Data/ders.txt");

                if (derslist != null) {
                    for (String ders : derslist) {
                        cbOgrenciDers.addItem(ders);
                    }

                }
                else {
                    System.out.println("Ders listesi bulunamadı.");
                }
            }
        });
        tfOgrenciBolum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cbOgrenciDers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public static void main(String[] args){
        OgrenciKayitForm ogrenciKayitForm = new OgrenciKayitForm();
    }
}


