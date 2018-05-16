/**
 * Skeleton for 'Borders.fxml' Controller Class
 */

package it.polito.tdp.borders;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BordersController {

	private Model model;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtAnno"
	private TextField txtAnno; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader
	
	@FXML
	private ComboBox<String> comboStato;

	@FXML
	private void doCalcolaConfini(ActionEvent event) {
		txtResult.clear();
		int year;
		try {
			year = Integer.parseInt(txtAnno.getText().trim());
		} catch (NumberFormatException e) {
			txtResult.setText("Inserisci un valore numerico da 1816 a 2016");
			return;
		}
		
		model.creaGrafo(year);
		
		StringBuilder res = new StringBuilder();
		for(Country c : model.getCountries())
			res.append("Stato: "+c.getName()+ " - Grado: " + model.degree(c)+"\n");
		
		txtResult.appendText(res.toString());
		
		txtResult.appendText("\nNumero componenti connesse: "+model.getNumberOfConnectedComponents()+"\n");
	}
	
	@FXML
	private void doTrovaVicini(ActionEvent event) {
		txtResult.appendText("\n-----------------------------------------------------");
		Set<Country> vicini = model.trovaVicini(comboStato.getValue());
		
		for(Country c : vicini)
			txtResult.appendText(c.toString()+"\n");
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	private void initialize() {
		assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";
	}

	public void setModel(Model m) {
		this.model = m;
		
		for(Country c : model.getCountries())
			comboStato.getItems().add(c.getName());
	}
}
