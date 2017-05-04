package by.bsu.diploma.commons.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "test_assignment")
@Getter
@Setter
public class TestAssignment extends AbstractEntity {

	@Min(0)
	private Integer points;

	@ManyToOne
	@JoinColumn(name = "enrollee_id")
	private Enrollee enrollee;

	@ManyToOne
	private Test test;

}
