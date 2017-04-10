package by.bsu.diploma.enrollee.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class TestAddContext implements Serializable {

	private static final long serialVersionUID = -9104484047722741720L;

	@NotNull
	private LocalDateTime date;

	@NotNull
	private Long roomId;

	@NotNull
	private Long subjectId;

	@NotNull
	private String type;
}
