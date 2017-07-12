package com.graphicalinfo.fim.ui.presenter;

import com.graphicalinfo.fim.ui.views.MainContract;

/**
 * Created by ayoob on 05/07/17.
 */

public class MainPresenter  extends MainContract.Presenter{

    @Override
    public void presenterMethod() {
        if(isViewAttached())
            getView().viewMethod();
    }

}
