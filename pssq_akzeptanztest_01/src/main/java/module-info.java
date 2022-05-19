module de.pssq.akzeptanztest.pssq_akzeptanztest_01 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;

    opens de.pssq.akzeptanztest.pssq_akzeptanztest_01 to javafx.fxml, javafx.control, javafx.graphics;
    exports de.pssq.akzeptanztest.pssq_akzeptanztest_01;
    
    opens de.pssq.akzeptanztest.pssq_akzeptanztest_01.gui to javafx.fxml, javafx.control, javafx.graphics;
    exports de.pssq.akzeptanztest.pssq_akzeptanztest_01.gui;
    
    exports de.pssq.akzeptanztest.pssq_akzeptanztest_01.business;
}
