import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class EtudiantService implements IEtdSrv{
	
	public boolean inscription (int matricule, String nom, String pr�nom, String email,String pwd, int id_universite) throws SQLException	
	{
		IEtdRep StudRep= new EtudiantRepository();
	    Etudiant stud = new Etudiant(matricule, nom, pr�nom, email, pwd, id_universite);
	    System.out.println("Log: d�but de l'op�ration d'ajout de l'�tudiant avec matricule "+matricule);
	    
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
		 System.out.println("Log: Fin de l'op�ration d'ajout de l'�tudiant avec matricule "+matricule);
		 return true;
	}
	
	public void AddNbrBooksAllStudent (TypePackage pac) throws SQLException
	{
		 ArrayList<Etudiant> etudiants = GetEtudiatparLivreEmprunte();
		 for (Etudiant E : etudiants) 
		 {
			 if (pac == TypePackage.Standard)
		     {
				 E.setNbLivreMensuel_Autorise(15);
		     }
		     else if (pac == TypePackage.Premium)
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
