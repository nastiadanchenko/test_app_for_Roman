package com.nastiadanchtnko;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.*;

public class Controller {
    @FXML
    public TextArea taTextFile;
    final FileChooser fileChooser = new FileChooser();

    @FXML
    public void handleBtnOpenTextFile(ActionEvent actionEvent) {
        fileChooser.setTitle("File Chooser");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File", "*.txt"));

        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            taTextFile.appendText(readerText(file));
        } else {
            System.out.println("A file is invalid!");

        }
    }

    public String readerText(File file) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}