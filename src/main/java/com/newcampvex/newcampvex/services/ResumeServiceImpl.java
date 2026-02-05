package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Resume;
import com.newcampvex.newcampvex.repositories.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {
    private final ResumeRepository resumeRepository;

    @Override
    public Resume createResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    @Override
    public Resume updateResume(String id, Resume resume) {
        resume.setId(id);
        return resumeRepository.save(resume);
    }

    @Override
    public Optional<Resume> getResume(String id) {
        return resumeRepository.findById(id);
    }

    @Override
    public void deleteResume(String id) {
        resumeRepository.deleteById(id);
    }

    @Override
    public List<Resume> getUserResumes(String userId) {
        return resumeRepository.findByUserId(userId);
    }

    @Override
    public Optional<Resume> getDefaultResume(String userId) {
        return resumeRepository.findByUserIdAndIsDefault(userId, true);
    }
}
