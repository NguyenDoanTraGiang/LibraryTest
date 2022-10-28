package com.service;

import com.Exception.ResourceNotFoundException;
import com.Repository.ReaderRepository;
import com.entity.Reader;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReaderServiceImpl implements ReaderService {

    private ReaderRepository readerRepository;

    public ReaderServiceImpl(ReaderRepository readerRepository) {
        super();
        this.readerRepository = readerRepository;
    }


    @Override
    public List<Reader> getReaderList() {
        return readerRepository.findAll();
    }

    @Override
    public Reader getReaderById(Integer readerId) throws ResourceNotFoundException {
        Reader result = readerRepository.findById(readerId).orElseThrow(() -> new ResourceNotFoundException("Reader not found by this id: " + readerId));
        return result;

    }

    @Override
    public Reader createReader(Reader reader) {
        return readerRepository.save(reader);
    }

    @Override
    public Reader updateReader(Integer readerId, Reader readerDetails) throws ResourceNotFoundException {
        Reader reader = readerRepository.findById(readerId)
                .orElseThrow(() -> new ResourceNotFoundException("Reader not found by this id: " + readerId));

        reader.setEmail(readerDetails.getEmail());
        reader.setName(readerDetails.getName());
        reader.setPhoneNum(readerDetails.getPhoneNum());

        final Reader updatedReader = readerRepository.save(reader);
        return updatedReader;
    }

    @Override
    public Map<String, Boolean> deleteReader(Integer readerId) throws ResourceNotFoundException {
        Reader reader = readerRepository.findById(readerId)
                .orElseThrow(() -> new ResourceNotFoundException("Reader not found by this id: " + readerId));

        readerRepository.delete(reader);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
