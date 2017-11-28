package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.junit.Test;

import static org.junit.Assert.*;

public class TripServiceShould {

    @Test(expected = UserNotLoggedInException.class)
    public void not_return_trips_if_the_user_is_not_logged_in() {
        TripService tripService = new TestableTripService(null);
        tripService.getTripsByUser(null);
    }

}