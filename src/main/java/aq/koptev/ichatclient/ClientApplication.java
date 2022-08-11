package aq.koptev.ichatclient;

import aq.koptev.ichatclient.connect.Connector;
import aq.koptev.ichatclient.connect.DataPool;
import aq.koptev.ichatclient.connect.Observable;
import aq.koptev.ichatclient.controllers.ChatController;
import aq.koptev.ichatclient.controllers.IdentificationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientApplication extends Application {

    private Stage chatStage;
    private Stage identificationStage;
    private Observable connector;
    private ChatController chatController;
    private IdentificationController identificationController;

    @Override
    public void start(Stage stage) throws IOException {
        chatStage = stage;
        connector = new Connector();
        buildIdentificationView();
        buildChatView();
    }

    private void buildIdentificationView() throws IOException {
        identificationStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("identification-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        identificationStage.setTitle("Чат");
        identificationStage.setScene(scene);
        identificationStage.show();
        identificationController = fxmlLoader.getController();
        connector.register(identificationController);
        identificationController.setConnector(connector);
        identificationController.setDataPool(connector.getDataPool());
        identificationController.setClientApplication(this);
    }

    private void buildChatView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("chat-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        chatStage.setTitle("Чат");
        chatStage.setScene(scene);
        chatController = fxmlLoader.getController();
        connector.register(chatController);
        chatController.setConnector(connector);
        chatController.setDataPool(connector.getDataPool());
        chatController.setClientApplication(this);
    }

    public void showChatView() {
        connector.remove(identificationController);
        identificationStage.close();
        chatController.setDataFromDataPool();
        chatStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}