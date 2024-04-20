package org.simulator.scenario;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RTRequest extends Request {
    protected int deadline;

    public RTRequest(int sectorId, int deadline) {
        super(sectorId);
        this.deadline = deadline;
    }

    @Override
    public Request copy() {
        return new RTRequest(sectorId, deadline);
    }
}
