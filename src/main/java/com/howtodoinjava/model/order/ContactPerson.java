/*package com.howtodoinjava.model.order;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({ @AttributeOverride(name = "firstName", column = @Column(name = "contact_first_name")),
		@AttributeOverride(name = "lastName", column = @Column(name = "contact_last_name")),
		@AttributeOverride(name = "phone", column = @Column(name = "contact_phone")) })
public class ContactPerson {

	private String firstName;

	private String lastName;

	private String phone;

}*/