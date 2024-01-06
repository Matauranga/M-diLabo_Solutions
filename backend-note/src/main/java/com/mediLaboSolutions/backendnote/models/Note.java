package com.mediLaboSolutions.backendnote.models;

import com.mediLaboSolutions.backendnote.DTO.NoteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "notes")
public class Note {

    @Id
    private String id;

    private String patientId;

    private String content;

    private Date date;

    public Note update(NoteDTO noteDTO) {

        this.content = noteDTO.getContent();
        this.date = new Date();

        return this;
    }

}
