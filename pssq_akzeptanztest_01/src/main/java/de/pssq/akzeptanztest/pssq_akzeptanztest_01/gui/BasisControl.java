package de.pssq.akzeptanztest.pssq_akzeptanztest_01.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

import de.pssq.akzeptanztest.pssq_akzeptanztest_01.business.Artikel;
import de.pssq.akzeptanztest.pssq_akzeptanztest_01.business.BasisModel;

public class BasisControl implements Initializable {
	@FXML
	private TableColumn<Artikel, Integer> artikelIDColumn;
	@FXML
	private TableColumn<Artikel, String> bezeichnungColumn;
	@FXML
	private TableColumn<Artikel, Integer> lagerbestandColumn;
	@FXML
	private TableColumn<Artikel, Double> preisColumn;
	@FXML
	private TableView<Artikel> tableView;
	@FXML
	private TextField artikelIDField;
	@FXML
	private TextField bezeichnungField;
	@FXML
	private TextField lagerbestandField;
	@FXML
	private TextField preisField;

	private BasisModel basisModel;

	public BasisControl() {
		this.basisModel = BasisModel.getInstance();
	}

	@FXML
	public void addArtikel(ActionEvent event) {

		if (!artikelIDField.getText().isEmpty() && !bezeichnungField.getText().isEmpty()
				&& !lagerbestandField.getText().isEmpty() && !preisField.getText().isEmpty()) {
			Artikel artikel = new Artikel(Integer.parseInt(artikelIDField.getText()), bezeichnungField.getText(),
					Integer.parseInt(lagerbestandField.getText()), Double.parseDouble(preisField.getText()));

			this.basisModel.fuegeArtikelHinzu(artikel);

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Eintrag hinzufuegen");
			alert.setHeaderText("Daten unvollstaendig.");
			alert.setContentText("Bitte Daten vervollstaendigen.");
			alert.show();
		}

		this.artikelIDField.setText("");
		this.bezeichnungField.setText("");
		this.lagerbestandField.setText("");
		this.preisField.setText("");

		this.refreshArtikel();
	}
	
	@FXML
	public void loescheArtikel(ActionEvent event) {
		if(this.tableView.getSelectionModel().getSelectedItem() != null) {
			Artikel martierteArtikelReihe = this.tableView.getSelectionModel().getSelectedItem();
			this.basisModel.loescheArtikel(martierteArtikelReihe);
		}
		
	}

	@FXML
	public void refreshArtikel(ActionEvent event) {
		this.refreshArtikel();
	}

	public ObservableList<Artikel> getArtikelListe() {
		return this.basisModel.getArtikelListe();
	}

	public void refreshArtikel() {
		this.tableView.setItems(this.getArtikelListe());
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		artikelIDColumn.setCellValueFactory(new PropertyValueFactory<Artikel, Integer>("artikelID"));
		bezeichnungColumn.setCellValueFactory(new PropertyValueFactory<Artikel, String>("bezeichnung"));
		lagerbestandColumn.setCellValueFactory(new PropertyValueFactory<Artikel, Integer>("lagerbestand"));
		preisColumn.setCellValueFactory(new PropertyValueFactory<Artikel, Double>("preis"));

		this.refreshArtikel();
	}

}