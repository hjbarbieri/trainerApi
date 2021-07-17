package com.gladiator.trainer.service;

import com.gladiator.trainer.dao.TrainerRepository;
import com.gladiator.trainer.model.Trainer;
import com.gladiator.trainer.model.TrainerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepository trainerRepository;

    @Autowired
    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public List<Trainer> getAll() {
       return trainerRepository.findAll();
    }

    @Override
    public Trainer getByID(Long id) {
        return trainerRepository.getById(id);
    }

    @Override
    public Optional<Trainer> getByTrainerId(String trainerId) {
        Optional<Trainer> trainerByTrainerId = trainerRepository.findTrainerByTrainerId(trainerId);

        return trainerByTrainerId;
    }

    @Override
    public void saveTrainer(Trainer trainer) {
        Optional<Trainer> trainerByTrainerId =  trainerRepository.findTrainerByTrainerId(trainer.getTrainerId());
        if(trainerByTrainerId.isPresent()) {
         throw new IllegalStateException("trainer Id is already");
        }
        trainerRepository.save(trainer);
    }
}
