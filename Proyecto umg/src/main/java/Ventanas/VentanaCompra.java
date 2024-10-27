package Ventanas;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaCompra extends JFrame {

    public static JPanel panel = new JPanel();
    private JTable table;
    private DefaultTableModel model;
    private JLabel totalLabel;
    private ArrayList<Producto> productos;
    private double total;

    public VentanaCompra(ArrayList<Producto> productos) throws HeadlessException {
        this.productos = productos;
        this.total = 0.0;

        this.setSize(1600, 1600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("CARRITO");
        this.getContentPane().setBackground(Color.white);
        iniciarComponentes();
        botones();
        mostrarProductos();
        calcularTotal();
    }

    public void iniciarComponentes() {
        this.getContentPane().add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.white);

        JLabel etiqueta = new JLabel("Carrito Compra");
        etiqueta.setBounds(100, 10, 350, 30);
        panel.add(etiqueta);
        etiqueta.setFont(new Font("arial", Font.PLAIN, 30));


        model = new DefaultTableModel();
        model.addColumn("Producto");
        model.addColumn("Precio");
        model.addColumn("Cantidad");
        model.addColumn("Subtotal");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 100, 1000, 400);
        panel.add(scrollPane);


        totalLabel = new JLabel("Total: $0.00");
        totalLabel.setFont(new Font("arial", Font.PLAIN, 20));
        totalLabel.setBounds(1000, 510, 200, 30);
        panel.add(totalLabel);
    }

    public void botones() {
        JButton botonVaciar = new JButton();
        botonVaciar.setBounds(1000, 550, 100, 40);
        botonVaciar.setText("Vaciar");
        panel.add(botonVaciar);
        botonVaciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                total = 0;
                totalLabel.setText("Total: $0.00");
            }
        });

        JButton botonAtras = new JButton();
        botonAtras.setBounds(100, 550, 100, 40);
        botonAtras.setText("Atras");
        panel.add(botonAtras);
        botonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                ventanaPrincipal.setVisible(true);
                dispose();
            }
        });
    }


    public void mostrarProductos() {
        for (Producto producto : productos) {
            double subtotal = producto.getPrecio() * producto.getCantidad();
            model.addRow(new Object[]{producto.getNombre(), producto.getPrecio(), producto.getCantidad(), subtotal});
        }
    }


    public void calcularTotal() {
        total = productos.stream().mapToDouble(p -> p.getPrecio() * p.getCantidad()).sum();
        totalLabel.setText("Total: $" + total);
    }
}