package interfaces;

import infrastructure.Enclosure;

public interface Staff {
    void work();
    void cleanEnclosure(Enclosure enclosure);
    String getName();
    String getPosition();
}