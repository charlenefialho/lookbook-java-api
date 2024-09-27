package com.leadtech.lookbook.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "lookbook")
public class Lookbook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Nome do lookbook é obrigatório")
	private String nome;
	
	@CreationTimestamp
	@Column(name = "data_criacao", updatable = false)
	private LocalDate dataCriacao;
	
	@ManyToMany
    @JoinTable(
        name = "lookbook_clothing_item", // Tabela associativa  para n:n
        joinColumns = @JoinColumn(name = "lookbook_id"), // pk tabela Lookbook
        inverseJoinColumns = @JoinColumn(name = "clothing_item_id") // pk tabela ClothingItem
    )

	@Valid
	@Size(min = 1, message = "É necessário selecionar pelo menos uma peça")
	private List<ClothingItem> clothingItems;
	
	@Override
	public String toString() {
	    return "Lookbook{" +
	            "id=" + id +
	            ", nome='" + nome + '\'' +
	            '}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<ClothingItem> getClothingItems() {
		return clothingItems;
	}

	public void setClothingItems(List<ClothingItem> clothingItems) {
		this.clothingItems = clothingItems;
	}
	
	

}
