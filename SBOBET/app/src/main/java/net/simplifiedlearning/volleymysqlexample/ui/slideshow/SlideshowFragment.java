package net.simplifiedlearning.volleymysqlexample.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.widget.Toast;

import net.simplifiedlearning.volleymysqlexample.R;
import net.simplifiedlearning.volleymysqlexample.RegisterAPI;
import net.simplifiedlearning.volleymysqlexample.WithdrawAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static net.simplifiedlearning.volleymysqlexample.ui.gallery.GalleryFragment.ROOT_URL;

public class SlideshowFragment extends Fragment {
    //Declaring views

    private EditText editTextIdUser;
    private EditText editTextNominal;
    private Button buttonRegister;
    public EditText editText;
    public EditText editText2;

    //This is our root url

    public static final String ROOT_URL = "https://sbobet-admin.godisfaith.com/SBOBET/function/getDataForMobile/insertWitdraw.php";

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        //Initializing Views

        editTextIdUser = (EditText) root.findViewById(R.id.editTextIdUser);
        editTextNominal = (EditText) root.findViewById(R.id.editTextNominal);
        //Untuk clear
        editText = (EditText) root.findViewById(R.id.editTextIdUser);
        editText2 = (EditText) root.findViewById(R.id.editTextNominal);


        buttonRegister = (Button) root.findViewById(R.id.buttonRegister);
        //Adding listener to button
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertUser();
                editText.getText().clear();
                editText2.getText().clear();

            }
        });

        return root;
    }
    private void insertUser(){
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        WithdrawAPI api = adapter.create(WithdrawAPI.class);

        //Defining the method insertuser of our interface
        api.insertWithdraw(

                //Passing the values by getting it from editTexts

                editTextIdUser.getText().toString(),
                editTextNominal.getText().toString(),


                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";

                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        //Displaying the output as a toast
                        Toast.makeText(getActivity().getApplicationContext(), output, Toast.LENGTH_LONG).show();
                    }


                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occured displaying the error as toast
                        Toast.makeText(getActivity().getApplicationContext(), error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}