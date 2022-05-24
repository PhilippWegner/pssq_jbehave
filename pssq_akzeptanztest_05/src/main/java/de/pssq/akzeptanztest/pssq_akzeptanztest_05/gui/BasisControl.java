package de.pssq.akzeptanztest.pssq_akzeptanztest_05.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import de.pssq.akzeptanztest.pssq_akzeptanztest_05.business.Artikel;
import de.pssq.akzeptanztest.pssq_akzeptanztest_05.business.BasisModel;

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
	private ComboBox<String> bezeichnungBox;
	@FXML
	private TextField lagerbestandField;
	@FXML
	private TextField preisField;
	@FXML
	private Button btnMwSt;

	private BasisModel basisModel;
	private boolean mitMwSt = true;

	public BasisControl() {
		this.basisModel = BasisModel.getInstance();
	}

	@FXML
	public void addArtikel() {
		this.addArtikel(
				this.artikelIDField.getText(), 
				this.bezeichnungBox.getValue(), 
				this.lagerbestandField.getText(), 
				this.preisField.getText()
		);
		
		this.artikelIDField.setText("");
		this.bezeichnungBox.getSelectionModel().clearSelection();
		this.bezeichnungBox.setValue("");
		this.lagerbestandField.setText("");
		this.preisField.setText("");
		
		this.refreshArtikel();
	}
	
	public void addArtikel(String artikelIDField, String bezeichnungBoxField, String lagerbestandField, String preisField) {
		try {
			int artikelID = Integer.parseInt(artikelIDField);
			String bezeichnung = bezeichnungBoxField;
			int lagerbestand = Integer.parseInt(lagerbestandField);
			double preis = Double.parseDouble(preisField);
			
			if (artikelID < 0 | preis < 0) {
				this.showAlert();
			} else {
				Artikel artikel = new Artikel(artikelID, bezeichnung, lagerbestand, preis);
				this.basisModel.fuegeArtikelHinzu(artikel);				
			}
		} catch (Exception e) {
			this.showAlert();
		}
	}

	@FXML
	public void btnLoescheArtikel() {
		if(this.tableView.getSelectionModel().getSelectedItem() != null) {
			Artikel martierteArtikelReihe = this.tableView.getSelectionModel().getSelectedItem();
			this.basisModel.loescheArtikel(martierteArtikelReihe);
		}
		this.refreshArtikel();
	}

	@FXML
	public void btnRefreshArtikel() {
		this.refreshArtikel();
	}

	@FXML
	public void btnToggleMwSt() {
		ObservableList<Artikel> artikelListe = FXCollections.observableArrayList();
		for (Artikel artikel : this.getArtikelListe()) {
			double preis = artikel.getPreis();
			if (this.mitMwSt) {
				this.btnMwSt.setText("Mit MwSt");
			} else {
				this.btnMwSt.setText("Ohne MwSt");
			}
			artikel.setPreis(this.berechneMwSt(preis));
			artikelListe.add(artikel);
		}
		this.tableView.getItems().clear();
		this.basisModel.setArtikelListe(artikelListe);
		this.mitMwSt = !this.mitMwSt;
		this.refreshArtikel();
	}
	
	public double berechneMwSt(double preis) {
		if (this.mitMwSt) {
			return preis / 1.19;
		} else {
			return preis * 1.19;
		}
	}
	
	public double mitMwSt(double preis) {
		return preis * 1.19;
	}

	public ObservableList<Artikel> getArtikelListe() {
		ObservableList<Artikel> artikelListe = FXCollections.observableArrayList();
		for (Artikel artikel : this.basisModel.getArtikelListe()) {
			double roundedPreis = Math.round(artikel.getPreis() * 100.0) / 100.0;
			artikel.setPreis(roundedPreis);
			artikelListe.add(artikel);
		}
		return artikelListe;
	}

	public void refreshArtikel() {
		this.tableView.setItems(this.getArtikelListe());
	}

	public void showAlert() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Eintrag hinzufügen");
		alert.setHeaderText("Daten unvollständig.");
		alert.setContentText("Bitte Daten vervollständigen.");
		alert.show();
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		this.artikelIDColumn.setCellValueFactory(new PropertyValueFactory<Artikel, Integer>("artikelID"));
		this.bezeichnungColumn.setCellValueFactory(new PropertyValueFactory<Artikel, String>("bezeichnung"));
		this.lagerbestandColumn.setCellValueFactory(new PropertyValueFactory<Artikel, Integer>("lagerbestand"));
		this.preisColumn.setCellValueFactory(new PropertyValueFactory<Artikel, Double>("preis"));
		this.refreshArtikel();
	}
}