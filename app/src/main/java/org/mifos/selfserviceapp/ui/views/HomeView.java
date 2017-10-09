package org.mifos.selfserviceapp.ui.views;

import android.graphics.Bitmap;

import org.mifos.selfserviceapp.models.client.Client;
import org.mifos.selfserviceapp.ui.views.base.MVPView;

/**
 * Created by dilpreet on 19/6/17.
 */

public interface HomeView extends MVPView {

    void showUserDetails(Client client);

    void showUserImageTextDrawable();

    void showUserImage(Bitmap bitmap);

    void showError(String errorMessage);

    void showUserImageNotFound();

}
