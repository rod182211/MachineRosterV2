package org.optaplanner.examples.common.persistence;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.jdom.JDOMException;

import javafx.fxml.Initializable;





public abstract class AbstractXlsxSolutionExporter  <Solution_> extends AbstractSolutionExporter<Solution_> {

    protected static final String DEFAULT_OUTPUT_FILE_SUFFIX = "xlxs";

    @Override
    public String getOutputFileSuffix() {
        return DEFAULT_OUTPUT_FILE_SUFFIX;
    }
    
    public abstract XlxsOutputBuilder<Solution_> createXlxsOutputBuilder() ;

    @Override
    public void writeSolution(Solution_ solution, File outputFile) {
  
    	XlxsOutputBuilder<Solution_> xlxsOutputBuilder = createXlxsOutputBuilder();
            xlxsOutputBuilder.setSolution(solution);
           	xlxsOutputBuilder.writeSolution(outputFile);
			 
			}
    
         public static abstract class XlxsOutputBuilder<Solution_> extends OutputBuilder {
		
     
        public abstract void setSolution(Solution_ solution);

        public abstract void writeSolution(File outputFile);

		

    }

}
