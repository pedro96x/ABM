import java.util.ArrayList;

public class CtrlABMPersona {

	private DataPersona dataPer;
	
	 private static ArrayList<Persona> personas;
		
		
		
	 public CtrlABMPersona(){
		 dataPer= new DataPersona();
		 personas = new ArrayList<Persona>();
		
	/*	 Persona pedro = new Persona(123123123,"Pedro","Routaboul");
		 personas.add(pedro);
		 Persona romeo = new Persona(456456456,"Romeo","Gomez");
		 personas.add(romeo);
		 Persona fausto = new Persona(789789789,"Fausto","Perez");
		 personas.add(fausto);
	*/	 
	 }
	 
	
	
	
	public void alta(Persona p) {
		//personas.add(p);
		dataPer.setPersona(p);
	}

	public void baja(int dni) {
		//Persona p = buscar(dni);
		//personas.remove(p);
		dataPer.deleteByDni(dni);
		
	}
	
	




	public void modific(Persona p){ //int dni, String nom, String ape) {
		//this.baja(dni);
		//Persona p = new Persona(dni,nom,ape);
		//personas.add(p);
		dataPer.actualiza(p);
		
	}
	/*
    public void mostrar() { //Esto era para consola
    	for(Persona p:personas){
    		System.out.println("DNI: "+ p.getDni());
    		System.out.println("Nombre: "+ p.getNombre());
    		System.out.println("Apellido: "+ p.getApellido());
    		
    	}
	}
    */
    
    
    Persona buscar(int dni) {
    	for(Persona p:personas){
    		if(p.getDni()== dni ){
    			return p;
    		}
    		
    	}
    	return null; 
	}




	public Persona getByDni(int document) {
		
		return dataPer.getByDni(document);
	}
    
}
