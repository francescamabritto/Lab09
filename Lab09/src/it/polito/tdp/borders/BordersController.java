/**
 * Skeleton for 'Borders.fxml' Controller Class
 */

package it.polito.tdp.borders;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.borders.exceptions.CampoVuotoException;
import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;

public class BordersController {

	Model model;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;
	
	@FXML // fx:id="CmbStati"
    private ComboBox<String> CmbStati; // Value injected by FXMLLoader

    @FXML // fx:id="btnTrovaVicini"
    private Button btnTrovaVicini; // Value injected by FXMLLoader

	@FXML // fx:id="txtAnno"
	private TextField txtAnno; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

	@FXML
	void doCalcolaConfini(ActionEvent event) {
		try {
			String annoStr = txtAnno.getText();
			if(annoStr == null || annoStr.isEmpty())
				throw new CampoVuotoException("Attenzione sono presenti dei campi vuoti.");
			
			int anno = Integer.parseInt(annoStr);
			
			if(anno<1816 || anno > 2006) {
				throw new InvalidParameterException();
			}
			
			model.createGraph(anno);
			List<Country> confini = model.getCountries();
			txtResult.setText(confini.toString());
			
			CmbStati.getItems().addAll(model.getCountryNames(confini));
			
		} catch(NumberFormatException e) {
			e.printStackTrace();
			this.txtResult.appendText("Inserire un valore intero per l'anno.\n");
			return;
		}catch(InvalidParameterException ipe) {
			this.txtResult.appendText("Inserire un anno compreso fra 1816 e 2006.\n");
			ipe.printStackTrace();
			return;
		} catch (CampoVuotoException e) {
			this.txtResult.appendText("Attento, sono presenti campi vuoti.\n");
			e.printStackTrace();
			return;
		}
	}
	
	@FXML
    void doTrovaVicini(ActionEvent event) {
		txtResult.clear();
		String stato = CmbStati.getValue();
		List<String> vicini = model.getTuttiVicini(stato);
		txtResult.appendText(vicini.toString());
		
    }

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";
		assert CmbStati != null : "fx:id=\"CmbStati\" was not injected: check your FXML file 'Borders.fxml'.";
        assert btnTrovaVicini != null : "fx:id=\"btnTrovaVicini\" was not injected: check your FXML file 'Borders.fxml'.";
 
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	
}
