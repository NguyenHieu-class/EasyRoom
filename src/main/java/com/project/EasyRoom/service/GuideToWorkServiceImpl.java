package com.project.EasyRoom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EasyRoom.model.GuideToWork;
import com.project.EasyRoom.repository.GuideToWorkRepository;

@Service
public class GuideToWorkServiceImpl implements GuideToWorkService {

    @Autowired
    private GuideToWorkRepository repository;

    @Override
    public void saveGuideToWork(GuideToWork entity) {
        repository.save(entity);
    }

    @Override
    public void deleteGuideToWorkById(int id) {
        repository.deleteById(id);
    }

    @Override
    public GuideToWork getGuideToWorkById(int id) {
        Optional<GuideToWork> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<GuideToWork> getAllGuideToWorks() {
        return repository.findAll();
    }

    @Override
    public long countGuideToWorks() {
        return repository.count();
    }
}
