/*package com.howtodoinjava.model.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DynamicUpdate
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String address;

	private String phone;

	@Embedded
	private ContactPerson contactPerson;

	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "branch", joinColumns = @JoinColumn(name = "company_id"))
	@Column(name = "branch", nullable = false)
	private List<String> branches = new ArrayList<>();

	@ElementCollection
	@MapKeyColumn(name = "lang_code")
	@Column(name = "client_name")
	@CollectionTable(name = "client_name_lang", joinColumns = @JoinColumn(name = "company_id"))
	private Map<String, String> clientNameLangMap = new HashMap<String, String>();;

}*/