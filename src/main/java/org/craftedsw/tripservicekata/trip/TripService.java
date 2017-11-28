package org.craftedsw.tripservicekata.trip;

import java.util.List;
import java.util.Optional;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

import static java.util.Collections.*;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        if (areFriends(user, loggedUser())) {
            return findTripsByUser(user);
        }

        return emptyList();
	}

    private User loggedUser() {
        return Optional
                .ofNullable(getLoggedUser())
                .orElseThrow(UserNotLoggedInException::new);
    }

    private boolean areFriends(User user, User loggedUser) {
        return user
                .getFriends()
                .stream()
                .anyMatch((friend) -> friend.equals(loggedUser));
    }

    protected List<Trip> findTripsByUser(User user) {
		return TripDAO.findTripsByUser(user);
	}

	protected User getLoggedUser() {
		return Optional
                .ofNullable(UserSession.getInstance().getLoggedUser())
                .orElseThrow(UserNotLoggedInException::new);
	}

}
