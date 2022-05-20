package de.pssq.akzeptanztest.pssq_akzeptanztest_01.gui;

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
		if (!this.artikelIDField.getText().isEmpty() && !this.lagerbestandField.getText().isEmpty()
				&& !this.bezeichnungBox.getValue().isEmpty() && !this.preisField.getText().isEmpty()) {
			Artikel artikel = new Artikel(Integer.parseInt(this.artikelIDField.getText()),
					this.bezeichnungBox.getSelectionModel().selectedItemProperty().getValue(),
					Integer.parseInt(this.lagerbestandField.getText()), Double.parseDouble(this.preisField.getText()));
			this.basisModel.fuegeArtikelHinzu(artikel);
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Eintrag hinzufügen");
			alert.setHeaderText("Daten unvollständig.");
			alert.setContentText("Bitte Daten vervollständigen.");
			alert.show();
		}
		this.artikelIDField.setText("");
		this.bezeichnungBox.getSelectionModel().clearSelection();
		this.bezeichnungBox.setValue("");
		this.lagerbestandField.setText("");
		this.preisField.setText("");

		this.refreshArtikel();
	}

	@FXML
	public void btnLoescheArtikel() {
		if (this.tableView.getSelectionModel().getSelectedItem() != null) {
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
				artikel.setPreis(preis / 1.19);
				this.btnMwSt.setText("Mit MwSt");
			} else {
				artikel.setPreis(preis * 1.19);
				this.btnMwSt.setText("Ohne MwSt");
			}
			artikelListe.add(artikel);
		}
		this.tableView.getItems().clear();
		this.basisModel.setArtikelListe(artikelListe);
		this.mitMwSt = !this.mitMwSt;
		this.refreshArtikel();
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

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		artikelIDColumn.setCellValueFactory(new PropertyValueFactory<Artikel, Integer>("artikelID"));
		bezeichnungColumn.setCellValueFactory(new PropertyValueFactory<Artikel, String>("bezeichnung"));
		lagerbestandColumn.setCellValueFactory(new PropertyValueFactory<Artikel, Integer>("lagerbestand"));
		preisColumn.setCellValueFactory(new PropertyValueFactory<Artikel, Double>("preis"));
		this.refreshArtikel();
	}
}