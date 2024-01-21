package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel menuPanel;
    private JButton btnDers;
    private JButton btnOgrenci;
    private JPanel panel12;
    private JButton btnOgretimGorevlisi;

    public Menu() {
        menuPanel = new JPanel();
        panel12 = new JPanel();

        btnDers = new JButton("Ders Kayıt Formu");
        btnOgrenci = new JButton("Öğrenci Kayıt Formu");

        btnDers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DersKayitForm dersKayitForm = new DersKayitForm();
                dersKayitForm.setVisible(true);
                dispose();
            }
        });

        btnOgrenci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OgrenciKayitForm ogrenciKayitForm = new OgrenciKayitForm();
                ogrenciKayitForm.setVisible(true);
                dispose();
            }
        });

        menuPanel.add(btnDers);
        menuPanel.add(btnOgrenci);

        setContentPane(menuPanel);

        setTitle("Menu");
        setMinimumSize(new Dimension(600, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnOgretimGorevlisi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Menu();
        });
    }
}