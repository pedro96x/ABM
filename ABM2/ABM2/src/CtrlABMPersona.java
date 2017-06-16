import java.util.ArrayList;

public class CtrlABMPersona {

	
	 private static ArrayList<Persona> personas;
		
		
		
	 public void CtrlABMPersona(){
		 personas = new ArrayList<Persona>();
		 
	 }
	 
	
	
	
	public void alta(Persona p) {
		personas.add(p);
		
	}

	public void baja(int dni) {
		Persona p = buscar(dni);
		personas.remove(p);

		
	}
	
	




	public void modific() {

		
	}
    public void mostrar() {
    	for(Persona p:personas){
    		System.out.println("DNI: "+ p.getDni());
    		System.out.println("Nombre: "+ p.getNombre());
    		System.out.println("Apellido: "+ p.getApellido());
    		
    	}
		
	}
    Persona buscar(int dni) {
    	for(Persona p:personas){
    		if(p.getDni()== dni ){
    			return p;
    		}
    		
    	}
    	return null;
	}
}
