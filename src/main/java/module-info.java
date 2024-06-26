module es.jrcastle.libof {
    requires javafx.controls;
    requires javafx.fxml;
    requires simple.odf;
    requires org.apache.jena.base;


    opens es.jrcastle.libof to javafx.fxml;
     exports es.jrcastle.libof;
}