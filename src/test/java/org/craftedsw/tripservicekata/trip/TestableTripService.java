package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

public class TestableTripService extends TripService {

    private final User user;

    public TestableTripService(User user) {
        this.user = user;
    }

    @Override
    protected User getLoggedUser() {
        return this.user;
    }
}
