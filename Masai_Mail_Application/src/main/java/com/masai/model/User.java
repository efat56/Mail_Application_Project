package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	private String email;

	@NotNull(message = "First name can't be null")
	private String firstName;

	@NotNull(message = "Last name can't be null")
	private String lastName;

	@NotNull(message = "Mobile no can't be null")
	@Size(min = 10, max = 10, message = "Mobile no requires 10 digits only")
	private String mobileNumber;

	@NotNull(message = "Date of birth can't be null")
	@Past(message = "Date of birth should not be in future date")
	private LocalDate dateOfBirth;

	@NotNull(message = "Password can't be null")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]")
	@Size(min=6,max=12)
	private String password;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Email> emailList = new ArrayList<>();

}
