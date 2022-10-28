package com.service;

import com.Exception.ResourceNotFoundException;
import com.entity.Reader;

import java.util.*;

public interface ReaderService {
    List<Reader> getReaderList();
    Reader getReaderById(Integer readerId) throws ResourceNotFoundException;
    Reader createReader(Reader reader);
    Reader updateReader(Integer readerId, Reader readerDetails) throws ResourceNotFoundException;
    Map<String, Boolean> deleteReader(Integer readerId) throws ResourceNotFoundException;
}
