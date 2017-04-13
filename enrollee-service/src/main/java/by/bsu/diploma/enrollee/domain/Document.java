package by.bsu.diploma.enrollee.domain;

import by.bsu.diploma.enrollee.domain.enums.DocumentTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Document extends AbstractEntity {

	@Lob
	@Column(name = "document_binary")
	private byte[] documentBinary;

	@Enumerated(EnumType.STRING)
	private DocumentTypeEnum type;

	@ManyToOne(optional = false)
	@JoinColumn(name = "enrollee_id", nullable = false)
	private Enrollee enrollee;

}
