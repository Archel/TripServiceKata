package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

import java.util.List;

public class TestableTripService extends TripService {

    private final User loggedInUser;
    private final List<Trip> tripList;

    public TestableTripService(User loggedInUser) {
        this(loggedInUser, null);
    }

    public TestableTripService(User loggedInUser, List<Trip> tripList) {
        this.loggedInUser = loggedInUser;
        this.tripList = tripList;
    }

    @Override
    protected User getLoggedUser() {
        return loggedInUser;
    }

    @Override
    protected List<Trip> findTripsByUser(User user) {
        return tripList;
    }
}
