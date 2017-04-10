package by.bsu.diploma.enrollee.service;

import by.bsu.diploma.enrollee.domain.Subject;
import by.bsu.diploma.enrollee.domain.Test;
import by.bsu.diploma.enrollee.domain.University;
import by.bsu.diploma.enrollee.dto.TestAddContext;
import by.bsu.diploma.enrollee.dto.TestResultContext;

import java.util.List;

public interface TestService {

    List<University> getUniversities();

    List<Subject> getSubjectsByUniversityId(Long universityId);

    List<Test> findTestsByUniversityIdAndSubjectId(Long universityId, Long subjectId);

    void addTestResults(List<TestResultContext> testResults);

    boolean addTest(TestAddContext testAddContext);
}
