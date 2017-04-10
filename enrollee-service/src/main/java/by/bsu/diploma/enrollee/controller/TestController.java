package by.bsu.diploma.enrollee.controller;

import by.bsu.diploma.enrollee.domain.Subject;
import by.bsu.diploma.enrollee.domain.Test;
import by.bsu.diploma.enrollee.domain.University;
import by.bsu.diploma.enrollee.dto.TestAddContext;
import by.bsu.diploma.enrollee.dto.TestResultContext;
import by.bsu.diploma.enrollee.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tests")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/universities")
    public List<University> getUniversities()
    {
        return testService.getUniversities();
    }

    @GetMapping("/subjects/university/{id}")
    public List<Subject> getSubjectsByUniversityId(@PathVariable Long id)
    {
        return testService.getSubjectsByUniversityId(id);
    }

    @GetMapping("/university/{universityId}/subject/{subjectId}")
    public List<Test> findTestsByUniversityIdAndSubjectId(@PathVariable Long universityId, @PathVariable Long subjectId)
    {
        return testService.findTestsByUniversityIdAndSubjectId(universityId, subjectId);
    }

    @PostMapping("/result")
    public ResponseEntity<?> addTestResults(@Valid @RequestBody List<TestResultContext> testResults) {
        testService.addTestResults(testResults);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTest(@Valid @RequestBody TestAddContext testAddContext) {
        return testService.addTest(testAddContext) ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}
