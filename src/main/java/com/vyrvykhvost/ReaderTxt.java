package com.vyrvykhvost;

import com.vyrvykhvost.model.Souvenir;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;



public class ReaderTxt {
    private static final Logger LOG = LogManager.getLogger(ReaderTxt.class);
    public List<Souvenir> takeSouvenirFromTxt(String fileName) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
           return reader.lines().map(Souvenir::convert).toList();
        } catch (IOException e) {
            LOG.info("Input-Output Exception");
            return Collections.emptyList();
        }

    }
}
