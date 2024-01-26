package com.mediLaboSolutions.backendnote.configData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediLaboSolutions.backendnote.models.Note;
import com.mediLaboSolutions.backendnote.repositories.NoteRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Slf4j
@Component
public class InitData implements CommandLineRunner {

    @Value("${spring.profiles.active:defaultProfile}")
    private String activeProfile;

    private final NoteRepository noteRepository;

    public InitData(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public void run(String... args) {

        if (activeProfile.contains("test")) {

            log.info("|||||||||||||  Initialisation des données désactivé pour le profil 'test'.  |||||||||||||");
        } else {

            TypeReference<List<Note>> typeReference = new TypeReference<>() {
            };
            ObjectMapper objectMapper = new ObjectMapper();

            InputStream inputStream = TypeReference.class.getResourceAsStream("/notesData.json");

            try {
                noteRepository.deleteAll();

                List<Note> entities = objectMapper.readValue(inputStream, typeReference);

                noteRepository.saveAll(entities);
                log.info("|||||||||||||  Initialisation des données réussie!  |||||||||||||");

            } catch (Exception e) {
                log.error("|||||||||||||  Erreur lors de l'initialisation des données : " + e.getMessage() + "  |||||||||||||");
            }
        }
    }
}


