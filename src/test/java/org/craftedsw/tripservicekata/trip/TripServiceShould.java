package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TripServiceShould {

    private User loggedInUser = new User();

    @Test(expected = UserNotLoggedInException.class)
    public void not_return_trips_if_the_user_is_not_logged_in() {
        TripService tripService = new TestableTripService(null);
        tripService.getTripsByUser(null);
    }

    @Test
    public void not_return_trips_is_user_has_no_friends() {
        TripService tripService = new TestableTripService(loggedInUser);
        tripService.getTripsByUser(loggedInUser);
        User billyNoMates = new User();

        List<Trip> trips = tripService.getTripsByUser(billyNoMates);

        assertEquals(0, trips.size());
    }

}