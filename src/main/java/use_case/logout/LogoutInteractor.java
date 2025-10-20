package use_case.logout;

import interface_adapter.logout.LogoutPresenter;

/**
 * The Logout Interactor.
 */
public class LogoutInteractor implements LogoutInputBoundary {
    private LogoutUserDataAccessInterface userDataAccessObject;
    private LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutUserDataAccessInterface userDataAccessInterface,
                            LogoutOutputBoundary logoutOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute() {
        // * set the current username to null in the DAO
        // * instantiate the `LogoutOutputData`, which needs to contain the username.
        // * tell the presenter to prepare a success view.
        final LogoutOutputData logOut = new LogoutOutputData(this.userDataAccessObject.getCurrentUsername());
        this.userDataAccessObject.setCurrentUsername(null);
        logoutPresenter.prepareSuccessView(logOut);
    }
}