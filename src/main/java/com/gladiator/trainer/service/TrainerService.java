package com.gladiator.trainer.service;

import com.gladiator.trainer.model.Trainer;

import java.util.List;
import java.util.Optional;

public interface TrainerService {
    List<Trainer> getAll();
    Trainer getByID(Long id);
    Optional<Trainer> getByTrainerId(String trainerId);
    void saveTrainer(Trainer trainer);
}
