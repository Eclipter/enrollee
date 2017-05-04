package by.bsu.diploma.enrollee.service.impl;

import by.bsu.diploma.commons.domain.Subject;
import by.bsu.diploma.commons.domain.Test;
import by.bsu.diploma.commons.domain.TestAssignment;
import by.bsu.diploma.commons.domain.University;
import by.bsu.diploma.enrollee.dto.TestAddContext;
import by.bsu.diploma.enrollee.dto.TestResultContext;
import by.bsu.diploma.enrollee.repository.*;
import by.bsu.diploma.enrollee.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestAssignmentRepository testAssignmentRepository;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public List<University> getUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public List<Subject> getSubjectsByUniversityId(Long universityId) {
        return subjectRepository.findByUniversitiesId(universityId);
    }

    @Override
    public List<Test> findTestsByUniversityIdAndSubjectId(Long universityId, Long subjectId) {
        return testRepository.findByRoomUniversityIdAndSubjectId(universityId, subjectId);
    }

    @Override
    @Transactional
    public void addTestResults(List<TestResultContext> testResults) {
        testResults.forEach(testResult -> {
            Optional<TestAssignment> testOptional = Optional.ofNullable(testAssignmentRepository.findOne(testResult.getTestAssignmentId()));
            TestAssignment testAssignment = testOptional
                    .orElseThrow(() -> new ValidationException("Test assignment not found: " + testResult.getTestAssignmentId()));
            testAssignment.setPoints(testResult.getPoints());
        });
    }

    @Override
    @Transactional
    public boolean addTest(TestAddContext testAddContext) {
        Test existingTest = testRepository.findFirstByRoomIdAndDate(testAddContext.getRoomId(), testAddContext.getDate());
        if (existingTest != null) {
            return false;
        }
        Test test = new Test();
        test.setRoom(roomRepository.findOne(testAddContext.getRoomId()));
        test.setSubject(subjectRepository.findOne(testAddContext.getSubjectId()));
        test.setDate(testAddContext.getDate());
        test.setType(testAddContext.getType());
        testRepository.save(test);
        return true;
    }
}
