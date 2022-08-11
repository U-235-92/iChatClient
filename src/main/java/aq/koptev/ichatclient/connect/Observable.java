package aq.koptev.ichatclient.connect;

import aq.koptev.ichatclient.controllers.Observer;
import aq.koptev.ichatclient.models.NetObject;

public interface Observable {
    void register(Observer observer);
    void remove(Observer observer);
    void send(NetObject netObject);
    DataPool getDataPool();
}
