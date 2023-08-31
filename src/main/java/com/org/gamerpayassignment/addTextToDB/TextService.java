package com.org.gamerpayassignment.addTextToDB;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TextService {

    private final TextRepository textRepository;

    public List<Text> getAllTexts() {

        return textRepository.findAll();
    }

    public Text getAddTextToDbById(Long id) {

        return textRepository.findById(id).orElse(null);
    }

    public Text saveTextToDb(Text text) {

        return textRepository.save(text);
    }

    public void deleteTextFromDb(Long id) {

        textRepository.deleteById(id);
    }


}
