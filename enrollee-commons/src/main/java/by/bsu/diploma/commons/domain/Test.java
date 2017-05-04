package by.bsu.diploma.commons.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Test extends AbstractEntity {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(columnDefinition = "DATETIME")
	private LocalDateTime date;

	private String type;

	@ManyToOne(optional = false)
    private Room room;

	@ManyToOne(optional = false)
	private Subject subject;

	@OneToMany(mappedBy = "test")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<TestAssignment> testAssignments;

	public TestAssignment addTestAssignment(TestAssignment testAssignment) {
		getTestAssignments().add(testAssignment);
		testAssignment.setTest(this);

		return testAssignment;
	}

	public TestAssignment removeTestAssignment(TestAssignment testAssignment) {
		getTestAssignments().remove(testAssignment);
		testAssignment.setTest(null);

		return testAssignment;
	}

}
