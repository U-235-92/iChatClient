module aq.koptev.ichatclient {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens aq.koptev.ichatclient to javafx.fxml;
    exports aq.koptev.ichatclient;
    exports aq.koptev.ichatclient.connect;
    opens aq.koptev.ichatclient.connect to javafx.fxml;
    exports aq.koptev.ichatclient.controllers;
    opens aq.koptev.ichatclient.controllers to javafx.fxml;
}