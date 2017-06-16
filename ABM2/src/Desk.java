import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Checkbox;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Desk {

	private JFrame frame;
	private JTextField txtDni; //DNI
	private JTextField txtApe; // Apellido
	private JTextField txtNom; // Nombre
	private static JLabel jlresultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Desk window = new Desk();
					window.frame.setVisible(true);
					} catch (Exception e) {
										e.printStackTrace();
										}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Desk() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(); 
		frame.setBounds(100, 100, 340, 300); //setea donde aparece y con que dimenciones 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CtrlABMPersona controlador = new CtrlABMPersona();
		//controlador.CtrlABMPersona(); //QUE CARAJOS HACE ACA?
		//No se por que se llamaba a un metodo CtrlABMPersona que devolvia void, lo cambien en el controlador para que sea un constructor
		Persona p = new Persona();
		
		JCheckBox chckbxHabilitado = new JCheckBox("Habilitado");
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblApellido = new JLabel("Apellido:");
		
		JLabel lblDni = new JLabel("DNI:");
	
		JLabel jlresultado = new JLabel("-");
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		txtApe = new JTextField();
		txtApe.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) { //Como funciona el mouseClicked? que le pasa de parametro?
				this.agregar2();
			}

			private void agregar2() {
				p.setNombre(txtNom.getText());
				p.setApellido(txtApe.getText());
				p.setDni(Integer.parseInt(txtDni.getText()));
				p.setHabilitado(true);
				controlador.alta(p);
				jlresultado.setText("Registrado");
			}
				
			});
		
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent q){
				this.baja2();
			}
			
			private void baja2(){
				controlador.baja(Integer.parseInt(txtDni.getText()));
				jlresultado.setText("Eliminado");
			}
			
		});
		
		
		JButton btnActualizar = new JButton("Actualizar");
		
		btnActualizar.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent q){
				this.actualizar2();
			}

			private void actualizar2() {
			//Persona p = controlador.buscar(Integer.parseInt(txtDni.getText()));
			controlador.modific(
					Integer.parseInt(txtDni.getText()),
					txtNom.getText(),
					txtApe.getText()
					);
			jlresultado.setText("Actualizado");
			}
			
		});
		
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override //Y este override que pito toca? por que en los otros botones no se pone?
			public void mouseClicked(MouseEvent e) {
				this.buscar2();
			}
			private void buscar2() {				//cuando busca dos veces se rompe todo *emoji de duda*
				Persona per = new Persona();
				//per = controlador.buscar(1234);
				
				per = controlador.buscar(Integer.parseInt(txtDni.getText()));
				if (per != null){
				jlresultado.setText("Encontrado");
				txtApe.setText(per.getApellido());
				txtNom.setText(per.getNombre());
				chckbxHabilitado.setSelected(per.habilitado);
								}
				else {
					jlresultado.setText("No Encontrado");
				}
			}
				
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxHabilitado)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblApellido)
										.addComponent(lblDni))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtApe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(jlresultado)
								.addComponent(btnBaja))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnActualizar)
						.addComponent(btnBuscar))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellido)
						.addComponent(txtApe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(18)
					.addComponent(chckbxHabilitado)
					.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
					.addComponent(jlresultado)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnBaja)
						.addComponent(btnActualizar))
					.addGap(26))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
