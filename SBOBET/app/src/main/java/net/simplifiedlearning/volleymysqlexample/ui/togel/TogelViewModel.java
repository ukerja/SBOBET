package net.simplifiedlearning.volleymysqlexample.ui.togel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

public class TogelViewModel extends ViewModel {
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

    public TogelViewModel() {
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