package com.joincode.uepb.myapplication;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

public class UserProfileViewModel extends ViewModel {
    private String userId;

    private LiveData<User> user;
    public LiveData<User> getUser() {
        return user;
    }

    public void init(String userId) {
        this.userId = userId;
    }

}
