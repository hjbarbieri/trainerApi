package com.gladiator.trainer.service;

import com.gladiator.trainer.dao.TrainerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class TrainerServiceImplTest {

    private TrainerService trainerService;
    @Mock
    private TrainerRepository trainerRepository;

    @BeforeEach
    void setUp() {
        trainerService = new TrainerServiceImpl(trainerRepository);
    }

    @Test
    void getAllTrainers() {
        trainerService.getAll();
        verify(trainerRepository).findAll();
    }
}