package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

import java.util.List;

public class TestableTripService extends TripService {

    private final User loggedInUser;
    private final List<Trip> tripList;
    private final User friend;

    public TestableTripService(User loggedInUser) {
        this(loggedInUser, null, null);
    }

    public TestableTripService(User loggedInUser, List<Trip> tripList) {
        this(loggedInUser, tripList, null);
    }

    public TestableTripService(User loggedInUser, List<Trip> tripList, User friend) {
        this.loggedInUser = loggedInUser;
        this.tripList = tripList;
        this.friend = friend;
    }

    @Override
    protected User getLoggedUser() {
        return loggedInUser;
    }

    @Override
    protected List<Trip> findTripsByUser(User user) {
        if (friend == user) {
            return tripList;
        }

        return null;
    }
}
