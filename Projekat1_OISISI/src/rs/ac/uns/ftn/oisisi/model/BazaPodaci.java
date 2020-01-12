package rs.ac.uns.ftn.oisisi.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BazaPodaci {
	private BazaStudenta bazaStudent;
	private BazaPredmeta bazaPredmeta;
	private BazaProfesora bazaProfesor;
	
	
	
	public BazaPodaci() {
		bazaStudent = BazaStudenta.getInstance();
		bazaProfesor = BazaProfesora.getInstance();
		bazaPredmeta  = BazaPredmeta.getInstance();
	}
	
	public void citanje() {
		ObjectInputStream o = null;
		try {
			o = new ObjectInputStream(new BufferedInputStream(new FileInputStream("podaci.raw")));
			bazaStudent.studenti = (ArrayList<Student>) o.readObject();
			bazaProfesor.profesori = (ArrayList<Profesor>) o.readObject();
			bazaPredmeta.predmeti  =(ArrayList<Predmet>) o.readObject();
			bazaStudent.broj_studenata =bazaStudent.studenti.size();
			bazaProfesor.broj_profesora= bazaProfesor.profesori.size();
			bazaPredmeta.broj_predmeta = bazaPredmeta.predmeti.size();
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				o.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
	
	
	public void cuvanje() {
		ObjectOutputStream os = null;
		try {
			
			os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("podaci.raw")));
			os.writeObject(bazaStudent.studenti);
			os.writeObject(bazaProfesor.profesori);
			os.writeObject(bazaPredmeta.predmeti);
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				os.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
		
	}
	
}
