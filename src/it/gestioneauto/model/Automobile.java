package it.gestioneauto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Automobile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String marca;
	private String modello;
	private String colore;
	private Integer cilindrata;

	public Automobile() {
	}

	public Automobile(String marca, String modello, String colore) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.colore = colore;
	}

	public Automobile(String marca, String modello, String colore, Integer cilindrata) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.colore = colore;
		this.cilindrata = cilindrata;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public Integer getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(Integer cilindrata) {
		this.cilindrata = cilindrata;
	}

}
