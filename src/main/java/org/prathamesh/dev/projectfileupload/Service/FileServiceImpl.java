package org.prathamesh.dev.projectfileupload.Service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.prathamesh.dev.projectfileupload.Entity.DataBlackCoffee;
import org.prathamesh.dev.projectfileupload.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    private DataRepository dataRepository;

    @Override
    public boolean hasCSVFormat(MultipartFile file) {
        String  type = "text/csv";
        return type.equalsIgnoreCase(file.getContentType());
    }

    @Override
    public void processAndSaveData(MultipartFile file) throws IOException {
        List<DataBlackCoffee> blackCoffeeList = csvToDataBlackFile(file.getInputStream());
        dataRepository.saveAll(blackCoffeeList);
    }

    private List<DataBlackCoffee> csvToDataBlackFile(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        CSVParser csvParser;
        try {
            csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

        List<DataBlackCoffee> blackCoffeeList = new ArrayList<>();
        List<CSVRecord> records = csvParser.getRecords();
        for (CSVRecord record : records) {
            DataBlackCoffee blackCoffee = new DataBlackCoffee(Integer.parseInt(record.get("end_year")),
                    record.get("citylng"), record.get("citylat"),Integer.parseInt(record.get("intensity")),
                    record.get("sector"),record.get("topic"), record.get("insight"), record.get("swot"),
                    record.get("url"),record.get("region"), record.get("start_year"),
                    record.get("impact"), record.get("added"), record.get("published"),
                    record.get("city"), record.get("country"), Integer.parseInt(record.get("relevance")),
                    record.get("pestle"), record.get("source"), record.get("title"),
                    Integer.parseInt(record.get("likelihood")));
            blackCoffeeList.add(blackCoffee);
        }
        return blackCoffeeList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
