import java.util.Scanner;

public class Desktop {
	Scanner teclado = new Scanner(System.in);
	void start(){
		CtrlABMPersona ctrl = new CtrlABMPersona();
		int op = 0; int dni=0;
		while(op!=5){
		op = menu();
		Persona p;
		switch(op){
			case 1:
				p = cargaDatos();
				ctrl.alta(p);
				break;
			case 2:
				System.out.println("Ingrese DNI de la persona a borrar: ");
				dni = teclado.nextInt();
				ctrl.baja(dni);
				break;
			case 3:
				System.out.println("Ingrese DNI de la persona a modificar: ");
				dni = teclado.nextInt();
				ctrl.baja(dni);
				System.out.println("Ingrese datos de la persona a modificar: ");
				p = cargaDatos(dni);
				ctrl.alta(p);
				break;
			case 4:
				ctrl.mostrar();
				break;
		}}
		
		
	
		
	}

	private Persona cargaDatos() {
		Persona p = new Persona();
		System.out.println("Ingrese DNI: ");
		p.setDni(teclado.nextInt());
		System.out.println("Ingrese Nombre: ");
		p.setNombre(teclado.next());
		System.out.println("Ingrese Apellido: ");
		p.setApellido(teclado.next());
		return p;
	}

	private Persona cargaDatos(int dni) {
		Persona p = new Persona();
		p.setDni(dni);
		System.out.println("Ingrese Nombre: ");
		p.setNombre(teclado.next());
		System.out.println("Ingrese Apellido: ");
		p.setApellido(teclado.next());
		return p;
	}
	
	private int menu() {
		System.out.println("1)Alta \n2)Baja \n3)Modificacion \n4)Mostrar \n5)Salir");
		int op = teclado.nextInt();
		return op;
	}

	

}
