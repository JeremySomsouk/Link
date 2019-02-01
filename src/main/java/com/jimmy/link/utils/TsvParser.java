package com.jimmy.link.utils;

import com.jimmy.link.model.Position;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TsvParser {

    private static final Logger LOGGER = Logger.getLogger(TsvParser.class.getName());

    public List<Position> parseFileToPositionList(String filename) {

        List<Position> positionList = new ArrayList<>();
        try {
            InputStream inputStream = TsvParser.class.getResourceAsStream(filename);
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

            try (BufferedReader reader = new BufferedReader(streamReader)) {
                reader.readLine(); // skipping useless 1st line
                for (String line; (line = reader.readLine()) != null;) {
                    String[] position = line.split("\t");
                    if (position.length >= 3) {
                        double lon = MyMath.getHalfDownValue(Double.parseDouble(position[1]));
                        double lat = MyMath.getHalfDownValue(Double.parseDouble(position[2]));
                        positionList.add(new Position(lon, lat));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "TSV file not found", e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while parsing TSV file", e);
        }

        return positionList;
    }
}
