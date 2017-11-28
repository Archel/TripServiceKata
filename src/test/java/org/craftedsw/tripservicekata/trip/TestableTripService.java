package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

public class TestableTripService extends TripService {

    @Override
    protected User getLoggedUser() {
        return null;
    }
}
