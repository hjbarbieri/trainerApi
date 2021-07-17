package com.gladiator.trainer.model;

public class TrainerDTO {

    private Long id;
    private String trainerId;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;

    public TrainerDTO() {
    }

    public TrainerDTO(Trainer trainer) {
        this.id = trainer.getId();
        this.trainerId = trainer.getTrainerId();
        this.email = trainer.getEmail();
        this.phone = trainer.getPhone();
        this.firstName = trainer.getFirstName();
        this.lastName = trainer.getLastName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
