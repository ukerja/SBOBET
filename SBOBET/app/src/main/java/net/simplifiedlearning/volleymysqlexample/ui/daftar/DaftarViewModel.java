package net.simplifiedlearning.volleymysqlexample.ui.daftar;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class DaftarViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DaftarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Deposit");
    }

    public LiveData<String> getText() {
        return mText;
    }
}