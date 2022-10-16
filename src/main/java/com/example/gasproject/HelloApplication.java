package com.example.gasproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.setTitle("Brian Nason: Capstone Project!");
        stage.setScene(new Scene(root, 800, 400));
        stage.show();
    }

    /**
     * This will set up the data in its initial form by parsing in from the .csv files and creating
     * the subsequent arrays before the program runs.
     *
     * Consider it as a pre-load
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        DataHandlers.createData();
        DataHandlers.checkSizeOfArrays();

        // FIXME: Consider making this a feature of the UI instead of happen on INIT
        DataHandlers.matchEndDatesInArrays();

        FormattingStuff.createLineBreak();
        DataHandlers.checkSizeOfArrays();

        launch();
    }
}


/*
    // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
    // Scene scene = new Scene(fxmlLoader.load(), 320, 240);

    Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.setTitle("Brian Nason: Capstone Project!");
                // stage.setScene(scene);
                stage.setScene(new Scene(root, 800, 400));
                stage.show();*/
