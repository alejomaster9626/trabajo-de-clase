package Ventana;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public final class Ingreso extends JFrame {

     JPanel panelIzquierdo = new JPanel();
     JPanel panelCentral = new JPanel();
     JPanel panelInf = new JPanel();
     JPanel panelInferior = new JPanel();
     JPanel panelInferior2 = new JPanel();
     JPanel panelFormulario= new JPanel();
     
    JTabbedPane pestaña = new JTabbedPane();
     
     JTextField txtcedula = new JTextField();
     JTextField txtnombre = new JTextField();
     JTextField txtapellido = new JTextField();
     JTextField txtcargo = new JTextField();
     JTextField txtnohorastrabajadas = new JTextField();
     JTextField txtvalordelahora = new JTextField();
     JTextField txttotaldevengado = new JTextField();
     JTextField txtdctosalud = new JTextField();
     JTextField txtdctopension = new JTextField();
     JTextField txttotaldeducidos = new JTextField();
     JTextField txtnetoapagar = new JTextField();
     
 
     JButton guardarnomina = new JButton ("Guardar Nomina");
     JButton calcularnomina = new JButton ("Calcular Nomina");
     JTable tabla;
     JScrollPane jscrollPane;
     DefaultTableModel modelodelatabla;

    public Ingreso(){
        
        setSize(900,400);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle ("INGRESAR EMPLEADOS");
        
        
        
        creaPanel(); 
        getContentPane().add(pestaña);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
        
    }
        public void creaPanel(){
     
        panelIzquierdo.setLayout(new GridLayout(11,1));
        panelIzquierdo.add(new JLabel("Cedula"));
        panelIzquierdo.add(new JLabel("Apellidos"));
        panelIzquierdo.add(new JLabel("Nombres"));
        panelIzquierdo.add(new JLabel("Cargo"));
        panelIzquierdo.add(new JLabel("No Horas Trabajadas"));
        panelIzquierdo.add(new JLabel("Valor De La Hora"));
        panelIzquierdo.add(new JLabel("Total Devengado"));
        panelIzquierdo.add(new JLabel("Dcto Salud"));
        panelIzquierdo.add(new JLabel("Dcto Pension"));
        panelIzquierdo.add(new JLabel("Total Deducidos"));
        panelIzquierdo.add(new JLabel("Neto A Pagar"));
        
        panelCentral.setLayout(new GridLayout(11,1));
        panelCentral.add(txtcedula);
        panelCentral.add(txtnombre);
        panelCentral.add(txtapellido);
        panelCentral.add(txtcargo);
        panelCentral.add(txtnohorastrabajadas);
        panelCentral.add(txtvalordelahora);  
        panelCentral.add(txttotaldevengado);
        panelCentral.add(txtdctosalud);
        panelCentral.add(txtdctopension);
        panelCentral.add(txttotaldeducidos);
        panelCentral.add(txtnetoapagar);
      
        txttotaldevengado.setEditable(false);
        txtdctosalud.setEditable(false);
        txtdctopension.setEditable(false);
        txttotaldeducidos.setEditable(false);
        txtnetoapagar.setEditable(false);
        
        panelInferior.setLayout(new FlowLayout());
        panelInferior.add(guardarnomina);
        panelInferior.add(calcularnomina);
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(22, 22, 22, 22));
        panelFormulario.setLayout(new BorderLayout(11,1));
        panelFormulario.add(panelIzquierdo,BorderLayout.WEST);
        panelFormulario.add(panelCentral,BorderLayout.CENTER);
        panelFormulario.add(panelInferior, BorderLayout.SOUTH);
        
        
       
        
  pestaña.addTab("Registro_De_Datos", panelFormulario);
  panelFormulario.setBackground(Color.LIGHT_GRAY);
  panelIzquierdo.setBackground(Color.LIGHT_GRAY);
  panelInferior.setBackground(Color.LIGHT_GRAY);
   panelCentral.setBackground(Color.LIGHT_GRAY);
   
   
    }

   void iniciarComponentes() {
       
        Object [][] datosIngresados = new Object [][]{};
        
        String Cabeceras[] = {"Cedula","Nombres","Apellidos","Cargo","Horas Trabajadas","Valor Hora","TotalDevengado","Dcto Salud","Dcto Pension","Total Deducidos","Neto A Pagar"};
        
        modelodelatabla = new DefaultTableModel (datosIngresados,Cabeceras)
            {
                @Override
                public boolean isCellEditable(int row, int col)
                {
                    return false;
                }
                
            };
        
        tabla = new JTable(modelodelatabla);
        jscrollPane = new JScrollPane(tabla);
        pestaña.addTab("Reporte Ingreso", jscrollPane);
        pestaña.setBackground(Color.lightGray);
        
        calcularnomina.addActionListener(new ActionListener(){
        public void actionPerformed (ActionEvent a) {
        
                
            if((txtnohorastrabajadas.getText().length()==0)){
             JOptionPane.showMessageDialog(null, "No puede calcular si falta el numero de horas");
             
               
            }
            
            else
            
            if((txtvalordelahora.getText().length()==0)) {
                JOptionPane.showMessageDialog(null, "No puede calcular si falta el valor de la hora");
                
            }
            
            
            
            else{
            
           String ced = txtcedula.getText();
           String nom = txtnombre.getText();
           String ape = txtapellido.getText();
           String car = txtcargo.getText();
           double not = Double.parseDouble(txtnohorastrabajadas.getText());
           double vho = Double.parseDouble ( txtvalordelahora.getText());
           
          double tde = not*vho;
          String tdet = Double.toString(tde);
          
          double dsa = tde*0.04;
          String dsat = Double.toString(dsa);
          
          double dpe = tde*0.04;
          String dpet = Double.toString(dpe);
          
          double tdi = dsa + dpe;
          String tdit = Double.toString(tdi);
          
          double npa = tde - tdi;
          String npat = Double.toString(npa);
          
          
          Object datos2 [] = {ced, ape, nom, car, not, vho, tde , dsa , dpe , tdi , npa};
          
          
          txttotaldevengado.setText(tdet);
          txtdctosalud.setText(dsat);
          txtdctopension.setText(dpet);
          txttotaldeducidos.setText(tdit);
          txtnetoapagar.setText(npat);             
          
    
            }

 
        }});
  
        
        guardarnomina.addActionListener(new ActionListener(){
            
           public void actionPerformed(ActionEvent e) {  
               
                         
                             
           String ced = txtcedula.getText();
           String nom = txtnombre.getText();
           String ape = txtapellido.getText();
           String car = txtcargo.getText();
           String not = txtnohorastrabajadas.getText();
           String vho = txtvalordelahora.getText();
           String tde = txttotaldevengado.getText();
           String dsa = txtdctosalud.getText();
           String dpe = txtdctopension.getText();
           String tdi = txttotaldeducidos.getText();
           String npa = txtnetoapagar.getText();
           
           if((txtcedula.getText().length()==0)){
             JOptionPane.showMessageDialog(null, "DEBE INGRESAR EL APELLIDO PARA GUARDAR EL REPORTE");      
               
            }else{ 
            
               
           }
                                   
            if((txtnombre.getText().length()==0)) {
                JOptionPane.showMessageDialog(null, "DEBE INGRESAR LA CEDULA PARA GUARDAR EL REPORTE");
                
            }    else{ 
           
               
           } 
            
            if((txtapellido.getText().length()==0)) {
                JOptionPane.showMessageDialog(null, "DEBE INGRESAR EL NOMBRE PARA GUARDAR EL REPORTE");
                
            }    else{ 
              
               
           }
            
                
            if((txtcargo.getText().length()==0)) {
                JOptionPane.showMessageDialog(null, "DEBE INGRESAR EL CARGO PARA GUARDAR EL REPORTE");
                
            }     
            
                else{

        
           Object datos2 [] = {ced, ape, nom, car, not, vho, tde, dsa, dpe, tdi, npa};
           
           modelodelatabla.addRow(datos2);
           
           txtcedula.setText("");
           txtnombre.setText("");
           txtapellido.setText("");
           txtcargo.setText("");
           txtnohorastrabajadas.setText("");
           txtvalordelahora.setText("");
           txttotaldevengado.setText("");
           txtdctosalud.setText("");
           txtdctopension.setText("");
           txttotaldeducidos.setText("");
           txtnetoapagar.setText("");
        tabla.getTableHeader().setReorderingAllowed(false) ;
        }

         }});
   
    }
    
    
}   