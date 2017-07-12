package com.graphicalinfo.fim.ui.views;

import com.jemshit.elitemvp.base_presenter.ElitePresenter;
import com.jemshit.elitemvp.view.EliteView;

/**
 * Created by ayoob on 05/07/17.
 */

public interface MainContract {
    interface View extends EliteView {
        void viewMethod();
    }

    abstract class Presenter extends ElitePresenter<MainContract.View> {
        public abstract void presenterMethod();
    }
}
