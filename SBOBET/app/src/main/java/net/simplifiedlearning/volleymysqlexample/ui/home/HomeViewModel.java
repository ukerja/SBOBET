package net.simplifiedlearning.volleymysqlexample.ui.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.simplifiedlearning.volleymysqlexample.Product;
import net.simplifiedlearning.volleymysqlexample.R;

import java.util.List;

public class HomeViewModel extends ViewModel {
//    //this is the JSON Data URL
//    //make sure you are using the correct ip else it will not work
//    private static final String URL_PRODUCTS = "http://192.168.1.7/koneksi/Api.php";
//
//    //a list to store all the products
//    List<Product> productList;
//
//    //the recyclerview
//    RecyclerView recyclerView;

    private MutableLiveData<String> mText;

    Context context;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

//        recyclerView = recyclerView.findViewById(R.id.recylcerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    public LiveData<String> getText() {
        return mText;
    }
}