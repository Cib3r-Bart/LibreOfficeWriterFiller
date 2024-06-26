package es.jrcastle.libof;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class LibOffController {
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtApel;

    @FXML
    private TextField txtDoc;

    @FXML
    private TextField txtPais;

    @FXML
    private ProgressBar progressBar;

    private static final String writerTemplate = System.getProperty("user.dir")+ File.separator+"\\template.odt";

    @FXML
    void generaDoc() {
        try{
            progressBar.progressProperty().unbind();
            //Parameters for the service
            List<String> placeHolders = Arrays.asList("\\$\\{nombre\\}","\\$\\{apellido\\}","\\$\\{id\\}","\\$\\{pais\\}");
            List<String> newContents = Arrays.asList(txtName.getText(),txtApel.getText(),txtDoc.getText(),txtPais.getText());
            String outputPath = System.getProperty("user.dir")+File.separator + "output.odt";

            //Create and start the service
            WriterService writerService = new WriterService(writerTemplate,outputPath,placeHolders,newContents);
            writerService.start();
            //Bind the progressBar
            progressBar.progressProperty().bind(writerService.progressProperty());
            writerService.setOnSucceeded(e->{
                Alert info = new Alert(Alert.AlertType.CONFIRMATION);
                info.setTitle("Confirmación");
                info.setContentText("Documento creado exitosamente/Document successfully created");
                info.showAndWait();
                progressBar.progressProperty().unbind();
            });
            writerService.setOnFailed(e->{
                Alert info = new Alert(Alert.AlertType.ERROR);
                info.setTitle("Error");
                info.setContentText("Fallo al crear el documento/Process failed");
                info.showAndWait();
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void limpiar(){
        txtName.clear();
        txtApel.clear();
        txtDoc.clear();
        txtPais.clear();
        progressBar.setProgress(0d);
    }

}//ClassKey
