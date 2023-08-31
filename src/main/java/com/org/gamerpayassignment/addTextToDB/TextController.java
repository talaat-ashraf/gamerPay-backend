package com.org.gamerpayassignment.addTextToDB;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TextController {

    private final TextService textService;

    @GetMapping("/getText")
    public ResponseEntity<List<Text>> getAllText() {

        List<Text> allTexts = textService.getAllTexts();
        return new ResponseEntity<>(allTexts, HttpStatus.OK);
    }

    @GetMapping("/getText/{id}")
    public ResponseEntity<Text> getTextById(@PathVariable Long id) {

        Text text = textService.getAddTextToDbById(id);
        if (text != null) {
            return new ResponseEntity<>(text, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addText")
    public ResponseEntity<Text> addText(@RequestBody Text text) {

        Text savedText = textService.saveTextToDb(text);
        return new ResponseEntity<>(savedText, HttpStatus.OK);
    }

    @PutMapping("/editText/{id}")
    public ResponseEntity<Text> editTextById(@PathVariable Long id, @RequestBody Text text) {

        Text existingText = textService.getAddTextToDbById(id);
        if (existingText != null) {
            existingText.setText(text.getText());
            Text updatedText = textService.saveTextToDb(existingText);
            return new ResponseEntity<>(updatedText, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/deleteText/{id}")
    public ResponseEntity<Text> deleteTextById(@PathVariable Long id) {

        Text existingText = textService.getAddTextToDbById(id);
        if (existingText != null) {
            textService.deleteTextFromDb(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
