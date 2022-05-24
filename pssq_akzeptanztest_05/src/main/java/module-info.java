module de.pssq.akzeptanztest.pssq_akzeptanztest_05 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;

    opens de.pssq.akzeptanztest.pssq_akzeptanztest_05 to javafx.fxml, javafx.control, javafx.graphics;
    exports de.pssq.akzeptanztest.pssq_akzeptanztest_05;
    
    opens de.pssq.akzeptanztest.pssq_akzeptanztest_05.gui to javafx.fxml, javafx.control, javafx.graphics;
    exports de.pssq.akzeptanztest.pssq_akzeptanztest_05.gui;
    
    exports de.pssq.akzeptanztest.pssq_akzeptanztest_05.business;
}
