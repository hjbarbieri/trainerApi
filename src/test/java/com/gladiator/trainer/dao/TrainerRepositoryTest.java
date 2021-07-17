package com.gladiator.trainer.dao;


import com.gladiator.trainer.model.Trainer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TrainerRepositoryTest {

    @Autowired
    private TrainerRepository trainerRepository;

    @Test
    void itShouldSelectExistingTrainerId() {
        //given
        Trainer trainer = new Trainer();
        trainer.setTrainerId("someTrainer");
        trainer.setEmail("someEmail");
        trainer.setFirstName("Javier");
        trainer.setLastName("lastName");

        trainerRepository.save(trainer);
        //when
        Optional<Trainer> optionalTrainer =  trainerRepository.findTrainerByTrainerId("someTrainer");
        //then
        assertThat(optionalTrainer.isPresent()).isTrue();

    }

    @Test
    void itShouldNotSelectExistingTrainerId() {
        //given
        Trainer trainer = new Trainer();
        trainer.setTrainerId("someTrainer");
        trainer.setEmail("someEmail");
        trainer.setFirstName("Javier");
        trainer.setLastName("lastName");

        trainerRepository.save(trainer);
        //when
        Optional<Trainer> optionalTrainer =  trainerRepository.findTrainerByTrainerId("someTrainer2");
        //then
        assertThat(optionalTrainer.isPresent()).isFalse();

    }


    @AfterEach
    void tearDown() {
        trainerRepository.deleteAll();
    }
}