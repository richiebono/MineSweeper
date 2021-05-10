package com.minesweeper.domain.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Profiles")
public class Profile implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "id_generator")
	@SequenceGenerator(
			name = "id_generator",
			sequenceName = "id_generator",
			initialValue = 1000
	)
	private Long id;

	@Column
	private String name;

	@Transient
	public Long getId() {
		return id;
	}

	@Transient
	public void setId(Long id) {
		this.id = id;
	}

	@Transient
	public String getNome() {
		return name;
	}

	@Transient
	public void setNome(String nome) {
		this.name = nome;
	}

	@Transient
	@Override
	public String getAuthority() {
		return name;
	}
	
}
