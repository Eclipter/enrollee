package by.bsu.diploma.enrollee.dto;

import by.bsu.diploma.commons.domain.Enrollee;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class SignUpRequestContext implements Serializable {

	private static final long serialVersionUID = 2182028318030583190L;

	@Email
	private String email;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	private String middleName;

	@NotNull
	@Min(5)
	private String password;

	@NotBlank
	private String passportId;

	@NotBlank
	private String phoneNumber;

	public Enrollee toEnrolee(PasswordEncoder passwordEncoder) {
		Enrollee enrollee = new Enrollee();
		enrollee.setEmail(email);
		enrollee.setFirstName(firstName);
		enrollee.setLastName(lastName);
		enrollee.setMiddleName(middleName);
		enrollee.setPassword(passwordEncoder.encode(password));
		enrollee.setPassportId(passportId);
		enrollee.setPhoneNumber(phoneNumber);
		return enrollee;
	}
}
