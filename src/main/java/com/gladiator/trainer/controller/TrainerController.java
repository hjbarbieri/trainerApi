package com.gladiator.trainer.controller;

import com.gladiator.trainer.model.Trainer;
import com.gladiator.trainer.model.TrainerDTO;
import com.gladiator.trainer.service.TrainerService;
import com.gladiator.trainer.validator.ErrorValidator;
import com.gladiator.trainer.validator.TrainerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping
    public List<TrainerDTO> getTrainers() {
        return trainerService.getAll().stream().map(trainer -> new TrainerDTO(trainer)).collect(Collectors.toList());
    }

    @GetMapping(path = "{id}")
    public TrainerDTO getTrainerById(@PathVariable("id") Long id) {
        return new TrainerDTO(trainerService.getByID(id));
    }

    @PostMapping
    public ResponseEntity<?> saveTrainer(@RequestBody TrainerDTO trainerDTO) {
        //FE validation check if trainerId is into the DTO
        TrainerValidation trainerValidation = new TrainerValidation();
        List<ErrorValidator> errors = trainerValidation.validate(trainerDTO);
        if(errors.size() > 0) {
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        //BE validation check if trainerId exist
        Optional<Trainer> trainer = trainerService.getByTrainerId(trainerDTO.getTrainerId());
        if(trainer.isPresent()) {
            return new ResponseEntity<>("trainerId exist", HttpStatus.BAD_REQUEST);
        }
        trainerService.saveTrainer(Trainer.convertFromDTO(trainerDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
