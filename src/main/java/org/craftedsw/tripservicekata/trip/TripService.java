package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<>();

		User loggedUser = Optional
                            .ofNullable(getLoggedUser())
                            .orElseThrow(UserNotLoggedInException::new);

        if (isFriend(user, loggedUser)) {
            tripList = findTripsByUser(user);
        }

        return tripList;
	}

    private boolean isFriend(User user, User loggedUser) {
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
