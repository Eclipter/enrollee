package by.bsu.diploma.enrollee.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Methodist extends User {

	@ManyToOne
	private University university;

}
