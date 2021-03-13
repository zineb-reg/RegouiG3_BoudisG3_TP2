import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class EtudiantService implements IEtdSrv{
	
	public boolean inscription (int matricule, String nom, String prénom, String email,String pwd, int id_universite) throws SQLException	
	{
		IEtdRep StudRep= new EtudiantRepository();
	    Etudiant stud = new Etudiant(matricule, nom, prénom, email, pwd, id_universite);
	    System.out.println("Log: début de l'opération d'ajout de l'étudiant avec matricule "+matricule);
	    
	    if(email == null || email.length() == 0)
	    {
	    	return false;
	    }
	    
	    if (StudRep.Exists(matricule))
	    {
	        return false;
	    }
	    
		if (StudRep.Exists(email))
	    {
	        return false;
	    }
		
		 StudRep.add(stud);
		 System.out.println("Log: Fin de l'opération d'ajout de l'étudiant avec matricule "+matricule);
		 return true;
	}
	
	public void AddNbrBooksAllStudent (int id_universite) throws SQLException
	{
		 List <Etudiant> etudiants = new ArrayList <Etudiant>();
		 UniversiteRepository UnivRep= new UniversiteRepository();
		 Universite univ = UnivRep.GetById(id_universite);
		 for (Etudiant E : etudiants) 
		 {
			 if (univ.getPack() == TypePackage.Standard)
		     {
				 E.setNbLivreMensuel_Autorise(15);
		     }
		     else if (univ.getPack() == TypePackage.Premium)
		     {
		    	 E.setNbLivreMensuel_Autorise(15*2);
		     } 
		}
	}
	

public ArrayList<Etudiant> GetEtudiantParUniversitye()
{
    //...
	return new ArrayList<>(4);
}

public ArrayList<Etudiant> GetEtudiatparLivreEmprunte()
{
    //...
	return new ArrayList<>(4);
	
}


	
}
