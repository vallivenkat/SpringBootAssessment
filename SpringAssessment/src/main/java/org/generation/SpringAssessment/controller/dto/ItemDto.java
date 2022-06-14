package org.generation.SpringAssessment.controller.dto;

import java.time.LocalDate;

public class ItemDto {
    private String Title;
    private String Description;
    private LocalDate TargetDate;

    public ItemDto(String Title, String Description, LocalDate TargetDate)
    {
        this.Title = Title;
        this.Description = Description;

        this.TargetDate = TargetDate;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public LocalDate getTargetDate() {
        return TargetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.TargetDate = targetDate;
    }
}