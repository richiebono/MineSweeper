package com.authentication.domain.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Users")
public class User implements UserDetails {

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

  @Column
	private String email;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Profile> profiles = new ArrayList<>();

	@Transient
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

  @Transient
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

  @Transient
	public Long getId() {
		return id;
	}

  @Transient
	public void setId(Long id) {
		this.id = id;
	}

  @Transient
	public String getName() {
		return name;
	}

  @Transient
	public void setNome(String name) {
		this.name = name;
	}

  @Transient
	public String getEmail() {
		return email;
	}

  @Transient
	public void setEmail(String email) {
		this.email = email;
	}

  @Transient
	public void setPassword(String password) {
		this.password = password;
	}

  @Transient
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.profiles;
	}

  @Transient
	@Override
	public String getPassword() {
		return this.password;
	}

  @Transient
	@Override
	public String getUsername() {
		return this.email;
	}

  @Transient
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

  @Transient
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

  @Transient
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

  @Transient
	@Override
	public boolean isEnabled() {
		return true;
	}

}
