package aq.koptev.ichatclient.connect;

import aq.koptev.ichatclient.models.ChatHistory;
import aq.koptev.ichatclient.models.Client;
import aq.koptev.ichatclient.models.ClientPool;

public interface DataPool {
    void setChatHistory(ChatHistory chatHistory);
    void setClient(Client client);
    void setClientPool(ClientPool clientPool);
    Client getClient();
    ChatHistory getChatHistory();
    ClientPool getClientPool();
}
