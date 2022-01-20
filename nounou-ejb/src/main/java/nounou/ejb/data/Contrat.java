package nounou.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table( name = "contrat"  )
public class Contrat {
	
	
	// Champs
	
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "idcontrat" )
	private int				id;
	
	@Column( name = "nomenfant" )
	private String			nomenfant;
	
	@Column( name = "prenomenfant" )
	private String			prenomenfant;
	
	@Column( name = "datenaissanceenfant" )
	private Date			datenaissanceenfant;
	
	@Column( name = "datedebut" )
	private Date			datedebut;
	
	@Column( name = "datefin" )
	private Date			datefin;
	
	@Column( name = "tarifhoraire" )
	private double			tarifhoraire;
	
//	@OneToOne( cascade = CascadeType.MERGE ) 
//  @JoinColumn( name="idparent" )
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="idparent")
    private Parent parent;
	
//	@OneToOne( cascade = CascadeType.MERGE ) 
//    @JoinColumn( name="idpersonnel" )
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="idpersonnel")
    private Personnel personnel;
	
	
	// Constructeurs
	
	public Contrat() {
	}

	public Contrat(int id, String nomenfant, String prenomenfant, Date datenaissanceenfant, Date datedebut, Date datefin, double tarifhoraire, Parent parent, Personnel personnel ) {
		setId(id);
		setNomenfant(nomenfant);
		setPrenomenfant(prenomenfant);
		setDatenaissanceenfant(datenaissanceenfant);
		setDatedebut(datedebut);
		setDatefin(datefin);
		setTarifhoraire(tarifhoraire);
		setParent(parent);
		setPersonnel(personnel);
	}
	
	
	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomenfant() {
		return nomenfant;
	}

	public void setNomenfant(String nomenfant) {
		this.nomenfant = nomenfant;
	}

	public String getPrenomenfant() {
		return prenomenfant;
	}

	public void setPrenomenfant(String prenomenfant) {
		this.prenomenfant = prenomenfant;
	}

	public Date getDatenaissanceenfant() {
		return datenaissanceenfant;
	}

	public void setDatenaissanceenfant(Date datenaissanceenfant) {
		this.datenaissanceenfant = datenaissanceenfant;
	}

	public Date getDatedebut(){
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public double getTarifhoraire() {
		return tarifhoraire;
	}

	public void setTarifhoraire(double tarifhoraire) {
		this.tarifhoraire = tarifhoraire;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	
	// Actions
	
	
	// hashcode() + equals()
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrat other = (Contrat) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

}
