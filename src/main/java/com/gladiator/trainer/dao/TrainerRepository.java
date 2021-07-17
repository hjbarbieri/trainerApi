package com.gladiator.trainer.dao;

import com.gladiator.trainer.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainerRepository  extends JpaRepository<Trainer, Long> {

    @Query("SELECT t FROM Trainer t where t.trainerId = ?1")
    Optional<Trainer> findTrainerByTrainerId(String trainerId);
}
