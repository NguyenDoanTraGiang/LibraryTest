package controller;

import entity.Reader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/readers")
public class ReaderController {
    private List<Reader> readers = new ArrayList<>();

    @PostMapping("/addReader")
    public ResponseEntity addReader(@RequestBody Reader reader){
        readers.add(reader);
        return ResponseEntity.ok().body(reader);
    }
}
