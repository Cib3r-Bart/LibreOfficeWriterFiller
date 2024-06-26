package es.jrcastle.libof;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.common.navigation.InvalidNavigationException;
import org.odftoolkit.simple.common.navigation.TextNavigation;
import org.odftoolkit.simple.common.navigation.TextSelection;

import java.io.File;
import java.util.List;

public class WriterService extends Service<Void> {
    //Parameters of the service
    private final String templateName, outputWriter;
    private final List<String> placeHolders;
    private final List<String> newContents;

    //Constructor
    public WriterService(String templateName, String outputWriter, List<String> placeHolders,
                         List<String> newContents) {
        this.templateName = templateName;
        this.outputWriter = outputWriter;
        this.placeHolders = placeHolders;
        this.newContents = newContents;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                // Load template
                TextDocument document = TextDocument.loadDocument(new File(templateName));
                //Modify it
                int totalPlaceHolders = placeHolders.size();
                for(int i = 0; i < placeHolders.size(); i++){
                    replaceText(document,placeHolders.get(i), newContents.get(i));
                    // Counter to use with the ProgressBar
                    updateProgress((double) (i+1)/totalPlaceHolders,1.0d);
                }
                //Save the document
                document.save(outputWriter);
                updateProgress(1d,1d);
                return null;
            }
        };

    }

    private void replaceText (TextDocument document, String placeHolder, String newContent){
        TextNavigation search = new TextNavigation(placeHolder,document);
        while (search.hasNext()){
            TextSelection item = (TextSelection) search.nextSelection();
            try {
                item.replaceWith(newContent);
            } catch (InvalidNavigationException e) {
                throw new RuntimeException("Error remplazando placeholder" + placeHolder,e);
            }
        }
    }
}
