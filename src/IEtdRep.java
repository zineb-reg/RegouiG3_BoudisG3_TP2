import java.sql.SQLException;
//justification :
// d'aprés le principe d'inversion de contronle les modules de haut niveau ne doivent pas dependre des modules de bas niveau. en utilisant l'interface 'Idependency' la classe 'EtudiantService' ne depond 
public interface IEtdRep{

	boolean Exists(int matricule) throws SQLException;

	boolean Exists(String email) throws SQLException;

	void add(Etudiant stud) throws SQLException;
	

}
