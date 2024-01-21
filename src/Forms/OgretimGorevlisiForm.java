package Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import Models.OgretimGorevlisi;
import Services.DosyaService;

public class OgretimGorevlisiForm extends JFrame {
    private JTextField tfOgretmenNo;
    private JTextField tfAd;
    private JTextField tfSoyad;
    private JButton btnClear;
    private JButton btnSubmit;

    private JTextField tfBolum;
    private JPanel OgretimGorevlisiForm;

    OgretimGorevlisi ogretim = new OgretimGorevlisi();

    String OgretmenNo= ogretim.OgretmenNo;

    String Ad= ogretim.Ad;
    String Soyad= ogretim.Soyad;
    String Bolum= ogretim.Bolum;

    public OgretimGorevlisiForm() {

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfOgretmenNo.setText("");
                tfAd.setText("");
                tfSoyad.setText("");
                tfBolum.setText("");

            }
        });


        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

             OgretmenNo = tfOgretmenNo.getText();
             Ad = tfAd.getText();
            Soyad = tfSoyad.getText();
            Bolum = tfBolum.getText();

            System.out.println("Ogretmen No" + OgretmenNo + "Ogretmen Ad" + Ad + "Ogretmen Soyad" + Soyad + "Bolum" + Bolum);

            DosyaService dosyaService= new DosyaService();

            dosyaService.kaydet3(OgretmenNo,Ad,Soyad,Bolum);

            }
        });
        setContentPane(OgretimGorevlisiForm);
        setTitle("Ogretim Görevlisi Form");
        setMinimumSize(new Dimension(600, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

        public static void main(String[] args) {

            OgretimGorevlisiForm ogretimGorevlisiForm = new OgretimGorevlisiForm();

        }

    }

