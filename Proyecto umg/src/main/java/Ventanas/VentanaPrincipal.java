package Ventanas;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {

    public static JPanel panel = new JPanel();
    public static JTextField cajasTexto1 = new JTextField();
    public static JTextField cajasTexto2 = new JTextField();
    public static JTextField cajasTexto3 = new JTextField();
    public static JTextField cajasTexto4 = new JTextField();


    private ArrayList<Producto> listaDeProductos = new ArrayList<>();

    public VentanaPrincipal() throws HeadlessException {
        this.setSize(1600, 1600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("CARRITO DE COMPRAS");
        this.getContentPane().setBackground(Color.cyan);
        iniciarComponentes();
        cajasTexto();
        botones();
    }

    public void iniciarComponentes() {
        this.getContentPane().add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.white);

        JLabel etiqueta = new JLabel("Catalogo de productos");
        etiqueta.setBounds(220, 10, 350, 30);
        panel.add(etiqueta);
        etiqueta.setFont(new Font("arial", Font.PLAIN, 30));

        JLabel imagen = new JLabel(new ImageIcon("CAMARA.png"));
        imagen.setBounds(50, 100, 192, 134);
        JLabel etiqueta1 = new JLabel("Camara Canon");
        etiqueta1.setBounds(95, 230, 100, 30);
        panel.add(etiqueta1);
        panel.add(imagen);

        JLabel imagen2 = new JLabel(new ImageIcon("DISCO.png"));
        imagen2.setBounds(350, 100, 192, 134);
        panel.add(imagen2);
        JLabel etiqueta2 = new JLabel("Disco Duro 1TB");
        etiqueta2.setBounds(400, 230, 100, 30);
        panel.add(etiqueta2);

        JLabel imagen3 = new JLabel(new ImageIcon("RELOJ.png"));
        imagen3.setBounds(700, 100, 192, 134);
        panel.add(imagen3);
        JLabel etiqueta3 = new JLabel("Reloj Lambo");
        etiqueta3.setBounds(750, 230, 100, 30);
        panel.add(etiqueta3);

        JLabel imagen4 = new JLabel(new ImageIcon("NOTEBOOK.png"));
        imagen4.setBounds(1050, 100, 192, 134);
        panel.add(imagen4);
        JLabel etiqueta4 = new JLabel("Laptop dell i5");
        etiqueta4.setBounds(1100, 230, 100, 30);
        panel.add(etiqueta4);
    }

    public void cajasTexto() {
        cajasTexto1.setBounds(95, 260, 40, 30);
        panel.add(cajasTexto1);
        cajasTexto2.setBounds(400, 260, 40, 30);
        panel.add(cajasTexto2);
        cajasTexto3.setBounds(750, 260, 40, 30);
        panel.add(cajasTexto3);
        cajasTexto4.setBounds(1100, 260, 40, 30);
        panel.add(cajasTexto4);
    }

    public void botones() {
        JButton botonIngresar1 = new JButton();
        JButton botonIngresar2 = new JButton();
        JButton botonIngresar3 = new JButton();
        JButton botonIngresar4 = new JButton();
        JButton botoncarrito = new JButton();

        botonIngresar1.setBounds(135, 260, 100, 40);
        botonIngresar1.setText("Ingresar");
        panel.add(botonIngresar1);
        botonIngresar1.addActionListener(e -> {
            int cantidad = Integer.parseInt(cajasTexto1.getText());
            listaDeProductos.add(new Producto("Camara Canon", 500.0, cantidad));
        });

        botonIngresar2.setBounds(440, 260, 100, 40);
        botonIngresar2.setText("Ingresar");
        panel.add(botonIngresar2);
        botonIngresar2.addActionListener(e -> {
            int cantidad = Integer.parseInt(cajasTexto2.getText());
            listaDeProductos.add(new Producto("Disco Duro 1TB", 120.0, cantidad));
        });

        botonIngresar3.setBounds(790, 260, 100, 40);
        botonIngresar3.setText("Ingresar");
        panel.add(botonIngresar3);
        botonIngresar3.addActionListener(e -> {
            int cantidad = Integer.parseInt(cajasTexto3.getText());
            listaDeProductos.add(new Producto("Reloj Lambo", 250.0, cantidad));
        });

        botonIngresar4.setBounds(1140, 260, 100, 40);
        botonIngresar4.setText("Ingresar");
        panel.add(botonIngresar4);
        botonIngresar4.addActionListener(e -> {
            int cantidad = Integer.parseInt(cajasTexto4.getText());
            listaDeProductos.add(new Producto("Laptop dell i5", 700.0, cantidad));
        });

        botoncarrito.setBounds(120, 30, 100, 40);
        botoncarrito.setText("Carrito");
        panel.add(botoncarrito);
        botoncarrito.addActionListener(e -> {
            VentanaCompra ventanacarrito = new VentanaCompra(listaDeProductos);
            ventanacarrito.setVisible(true);
            dispose();
        });
    }
}