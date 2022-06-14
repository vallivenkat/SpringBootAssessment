package org.generation.SpringAssessment.repository.entity;

import org.generation.SpringAssessment.controller.dto.ItemDto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;



@Entity
public class Item {
        //To inform Hibernate to map to a table with this class object


        //using Wrapper Class Integer (Object) instead int(Primitive Data type)
        //We need to identify which attribute is the id(Primary Key), and how the id is generated
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;         // need to pass the id to a method findItemById
        private String Title;
        private String Description;
        private LocalDate TargetDate;

    public Item () {}

    public Item( ItemDto itemDto )
    {
        this.Title = itemDto.getTitle();
        this.Description = itemDto.getDescription();
        this.TargetDate = itemDto.getTargetDate();
    }

    public Integer getid() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + Title + '\'' +
                ", description='" + Description + '\'' +
                ", targetDate='" + TargetDate + '\'' +
                '}';
    }
}

