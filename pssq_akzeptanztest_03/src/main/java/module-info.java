module de.pssq.akzeptanztest.pssq_akzeptanztest_03 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;

    opens de.pssq.akzeptanztest.pssq_akzeptanztest_03 to javafx.fxml, javafx.control, javafx.graphics;
    exports de.pssq.akzeptanztest.pssq_akzeptanztest_03;
    
    opens de.pssq.akzeptanztest.pssq_akzeptanztest_03.gui to javafx.fxml, javafx.control, javafx.graphics;
    exports de.pssq.akzeptanztest.pssq_akzeptanztest_03.gui;
    
    opens de.pssq.akzeptanztest.pssq_akzeptanztest_03.business;
    exports de.pssq.akzeptanztest.pssq_akzeptanztest_03.business;
}
