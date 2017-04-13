package by.bsu.diploma.enrollee.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Room extends AbstractEntity {

	private Integer capacity;

	private String number;

	@ManyToOne
	private University university;

	@OneToMany(mappedBy = "room")
	private List<Test> tests;

	public Test addTest(Test test) {
		getTests().add(test);
		test.setRoom(this);
		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setRoom(null);
		return test;
	}

}
