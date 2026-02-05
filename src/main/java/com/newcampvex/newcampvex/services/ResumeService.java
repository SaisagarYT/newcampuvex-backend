package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Resume;
import java.util.List;
import java.util.Optional;

public interface ResumeService {
    Resume createResume(Resume resume);
    Resume updateResume(String id, Resume resume);
    Optional<Resume> getResume(String id);
    void deleteResume(String id);
    List<Resume> getUserResumes(String userId);
    Optional<Resume> getDefaultResume(String userId);
}
