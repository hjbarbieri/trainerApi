package com.gladiator.trainer.model;

import javax.persistence.*;

@Entity
@Table
public class Trainer {
    @Id
    @SequenceGenerator(name = "trainer_sequence", sequenceName = "trainer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainer_sequence")
    private Long id;
    private String trainerId;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;

    public Trainer() {
    }

    public Long getId() {
        return id;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static final Trainer convertFromDTO(TrainerDTO trainerDTO) {
        Trainer trainer = new Trainer();
        trainer.setTrainerId(trainerDTO.getTrainerId());
        trainer.setEmail(trainerDTO.getEmail());
        trainer.setFirstName(trainerDTO.getFirstName());
        trainer.setLastName(trainerDTO.getLastName());
        trainer.setPhone(trainerDTO.getPhone());

        return trainer;
    }
}
