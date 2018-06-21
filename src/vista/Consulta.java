/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.FiltroDao;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Filtro;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;


/**
 *
 * @author gabyordoenz
 */
public class Consulta extends JFrame{
    
    public JLabel lblAfp, lblNombre,lblApellido, lblEdad, lblProfesion, lblEstado;
    public JTextField afp, nombre, apellido, edad;
    public JComboBox profesion;
    
    ButtonGroup estado=new ButtonGroup();
    public JRadioButton no;
    public JRadioButton si;
    public JTable resultados;
    
    public JPanel table;
    
    public JButton insertar, actualizar, eliminar, vaciar;
    private static final int ANCHOC=130, ALTOC=30;
    
    DefaultTableModel tm;
    
    public Consulta(){
        super("Inscripciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container =getContentPane();
        container.add(lblAfp);
        container.add(lblNombre);
        container.add(lblApellido);
        container.add(lblEdad);
        container.add(lblProfesion);
        container.add(lblEstado); 
        container.add(afp);
        container.add(nombre);
        container.add(apellido);
        container.add(si);
        container.add(no);
        container.add(insertar);
        container.add(actualizar);
        container.add(eliminar);
        container.add(vaciar);
        container.add(table);
        setSize(600,600);
        eventos();
    }

    private void agregarLabels() {
        lblAfp=new JLabel("Afp");
        lblNombre=new JLabel("Nombres");
        lblApellido=new JLabel("Apellidos");
        lblEdad=new JLabel("Edad");
        lblProfesion=new JLabel("Profesion");
        lblEstado=new JLabel("Estado");
        lblAfp.setBounds(10,10,ANCHOC, ALTOC);
        lblNombre.setBounds(10,60,ANCHOC, ALTOC);
        lblApellido.setBounds(10,100,ANCHOC, ALTOC);
        lblEdad.setBounds(10,140,ANCHOC, ALTOC);
        lblProfesion.setBounds(10,180,ANCHOC, ALTOC);
        lblEstado.setBounds(10,210,ANCHOC, ALTOC);
    }

    private void formulario() {
        afp=new JTextField();
        nombre=new JTextField();
        apellido=new JTextField();
        profesion=new JComboBox();
        edad=new JTextField();
        si=new JRadioButton("si", true);
        no=new JRadioButton("no");
        resultados=new JTable();
        insertar=new JButton("Insertar");
        eliminar=new JButton("Eliminar");
        actualizar=new JButton("Actualizar");
        vaciar=new JButton("Limpiar");
        
        table=new JPanel();
        
        profesion.addItem("Ingeniero");
        profesion.addItem("Doctor");
        profesion.addItem("Licenciado");
        
        estado=new ButtonGroup();
        estado.add(si);
        estado.add(no);
        
        afp.setBounds(300, 10, ANCHOC, ALTOC);
        insertar.setBounds(10, 210, ANCHOC, ALTOC);
        actualizar.setBounds(150, 210, ANCHOC, ALTOC);
        eliminar.setBounds(300, 210, ANCHOC, ALTOC);
        vaciar.setBounds(4500, 210, ANCHOC, ALTOC);
        resultados=new JTable();
        table.setBounds(10,250,500,200);
        table.add(new JScrollPane(resultados));
    }

    private void llenarTabla() {
        tm=new DefaultTableModel(){
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 0:
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                        
                    case 3: 
                        return String.class; 
                        
                    default:
                        return Boolean.class;
                }
            }
        };
        tm.addColumn("Afp");
        tm.addColumn("Nombre");
        tm.addColumn("Apellido");
        tm.addColumn("Pofesion");
        tm.addColumn("Estado");
        
        FiltroDao fd =new FiltroDao();
        ArrayList<Filtro> filtros= fd.readAll();
        
        for(Filtro fi: filtros){
            tm.addRow(new Object[]{fi.getAfp(), fi.getNombre(), fi.getApellido(),fi.getProfesion(), fi.getEstado()});
        
    }
        resultados.setModel(tm);
    }

    private void eventos() {
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd =new FiltroDao();
                Filtro f=new Filtro(afp.getText(),nombre.getText(), apellido.getText(), profesion.getSelectedItem().toString(), nombre.getText(), apellido.getText(), Integer.parseInt(estado.getText()),true);
                if(no.isSelected()){
                    f.setEstado(false);
                }
                if(fd.create(f)){
                    JOptionPane.showMessageDialog(null, "Filtro registrado con exito.");
                    limpiarCampos();
                    llenarTabla();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de crear el filtro.");
                }
            }
        });
        actualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd= new FiltroDao();
                Filtro f=new Filtro(afp.getText(), nombre.getText(), apellido.getText(), profesion.getSelectedItem().toString(), estado.getSelectedItem()), true);
                if(no.isSelected()){
                    f.setEstado(false);
                }
                if(fd.create(f)){
                    JOptionPane.showMessageDialog(null, "Filtro modificado con exito.");
                    limpiarCampos();
                    llenarTabla();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de modificar el filtro.");
                }
            }
            
        });
        eliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd= new FiltroDao();
                if(fd.delete(afp.getText())){
                    JOptionPane.showMessageDialog(null, "Filtro eliminado con exito.");
                    limpiarCampos();
                    llenarTabla();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de eliminar el filtro.");
                }
            }
        });

        vaciar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        }); 
    }
    public void limpiarCampos(){
        afp.setText("");
        nombre.setText("");
        apellido.setText("");
        profesion.setSelectedItem("Ingeniero");
    }
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }
    }
