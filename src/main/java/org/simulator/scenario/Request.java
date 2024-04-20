package org.simulator.scenario;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Request {
    protected int sectorId;

    public Request(int sectorId) {
        this.sectorId = sectorId;
    }

    public Request copy() {
        return new Request(sectorId);
    }
}
