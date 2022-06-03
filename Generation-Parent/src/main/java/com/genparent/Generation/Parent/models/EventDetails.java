package com.genparent.Generation.Parent.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class EventDetails extends AbstractEntity {

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message = "Date is required")
    @DateTimeFormat
    private String eventDate;

    public EventDetails(@Size(max = 500, message = "Description too long!") String description, @NotBlank(message = "Email is required") @Email(message = "Invalid email. Try again.") String contactEmail, @NotBlank(message = "Date is required")
    @DateTimeFormat String eventDate) {
        this.description = description;
        this.contactEmail = contactEmail;
        this.eventDate = eventDate;
    }

    public EventDetails() {}

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

}
