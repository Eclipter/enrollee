package by.bsu.diploma.enrollee.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class PasswordChangeContext implements Serializable {

	private static final long serialVersionUID = -85542521769860044L;

	@NotNull
	@Min(5)
	private String oldPassword;

	@NotNull
	@Min(5)
	private String newPassword;

}
