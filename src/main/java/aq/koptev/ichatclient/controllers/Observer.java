package aq.koptev.ichatclient.controllers;

import aq.koptev.ichatclient.models.NetObject;

public interface Observer {

    void update(NetObject netObject);
}
