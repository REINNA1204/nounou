package nounou.commun.dto;

import java.io.Serializable;


@SuppressWarnings("serial")
public class DtoAgrement implements Serializable {
    
    // Champs
    
    private int         id;
    private String      libelle;
	
	
	// Constructeurs
    
    public DtoAgrement() {
		super();
	}
    
    public DtoAgrement(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
    
    
    // Getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
