package com.gladiator.trainer.validator;

import com.gladiator.trainer.model.TrainerDTO;

import java.util.ArrayList;
import java.util.List;

public class TrainerValidation {

    List<ErrorValidator> errorsValidator = new ArrayList<>();

    public List<ErrorValidator> validate(TrainerDTO trainerDTO) {
        validateTrainerId(trainerDTO);

        return errorsValidator;
    }

    private void validateTrainerId(TrainerDTO trainerDTO) {
        if(trainerDTO.getTrainerId() == null) {
            ErrorValidator errorValidator = populateErrorValidator("trainerID", "REQUIRED", "Please complete the trainerID");
            errorsValidator.add(errorValidator);
        }
    }

    private ErrorValidator populateErrorValidator(String errorField, String typeError, String description) {
        ErrorValidator errorValidator = new ErrorValidator();
        errorValidator.setErrorField(errorField);
        errorValidator.setTypeError(typeError);
        errorValidator.setDescription(description);

        return errorValidator;
    }
}
