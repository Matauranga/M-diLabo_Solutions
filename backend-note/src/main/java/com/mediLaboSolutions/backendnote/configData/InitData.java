package com.mediLaboSolutions.backendnote.configData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediLaboSolutions.backendnote.models.Note;
import com.mediLaboSolutions.backendnote.repositories.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * This component initializes data in the database on application startup.
 * It implements the CommandLineRunner interface to execute code after the application context is loaded.
 */
@Slf4j
@Component
public class InitData implements CommandLineRunner {

    @Value("${spring.profiles.active:defaultProfile}")
    private String activeProfile;

    private final NoteRepository noteRepository;

    public InitData(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    /**
     * If the active profile contains "test," data initialization is skipped.
     * Otherwise, it loads data from a JSON file and saves it in mongoDB via Node Repository.
     *
     */
    @Override
    public void run(String... args) {

        if (activeProfile.contains("test")) {

            log.info("|||||||||||||  Data initialization disabled for 'test' profile.  |||||||||||||");
        } else {

            TypeReference<List<Note>> typeReference = new TypeReference<>() {
            };
            ObjectMapper objectMapper = new ObjectMapper();

            InputStream inputStream = TypeReference.class.getResourceAsStream("/notesData.json");

            try {
                noteRepository.deleteAll();

                List<Note> entities = objectMapper.readValue(inputStream, typeReference);

                noteRepository.saveAll(entities);
                log.info("|||||||||||||  Data initialization successful!  |||||||||||||");

            } catch (Exception e) {
                log.error("|||||||||||||  Error during data initialization : " + e.getMessage() + "  |||||||||||||");
            }
        }
    }
}


