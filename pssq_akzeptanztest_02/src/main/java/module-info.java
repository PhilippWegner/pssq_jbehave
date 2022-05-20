module de.pssq.akzeptanztest.pssq_akzeptanztest_02 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;

    opens de.pssq.akzeptanztest.pssq_akzeptanztest_02 to javafx.fxml, javafx.control, javafx.graphics;
    exports de.pssq.akzeptanztest.pssq_akzeptanztest_02;
    
    opens de.pssq.akzeptanztest.pssq_akzeptanztest_02.gui to javafx.fxml, javafx.control, javafx.graphics;
    exports de.pssq.akzeptanztest.pssq_akzeptanztest_02.gui;
    
    exports de.pssq.akzeptanztest.pssq_akzeptanztest_02.business;
}
