package by.bsu.diploma.enrollee.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TestResultContext implements Serializable {

	private static final long serialVersionUID = 1601793892219354292L;

	@NonNull
	private Long testAssignmentId;

	@NonNull
	private Integer points;

}
