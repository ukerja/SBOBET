package net.simplifiedlearning.volleymysqlexample.ui.daftar;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.simplifiedlearning.volleymysqlexample.DaftarAPI;
import net.simplifiedlearning.volleymysqlexample.R;
import net.simplifiedlearning.volleymysqlexample.RegisterAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DaftarFragment extends Fragment {
    //Declaring views
    private EditText editTextNama;
    private EditText editTextBank;
    private EditText editTextNorek;
    private EditText editTextNohp;
    private Button buttonRegister;
    public EditText editText;
    public EditText editText2;
    public EditText editText3;
    public EditText editText4;
    //This is our root url

    public static final String ROOT_URL = "http://192.168.1.7/koneksi/insert4.php";

    private DaftarViewModel daftarViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        daftarViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DaftarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_daftar, container, false);
        //Initializing Views
        editTextNama = (EditText) root.findViewById(R.id.editTextNama);
        editTextBank = (EditText) root.findViewById(R.id.editTextBank);
        editTextNorek = (EditText) root.findViewById(R.id.editTextNorek);
        editTextNohp = (EditText) root.findViewById(R.id.editTextNohp);

        //Untuk clear
        editText = (EditText) root.findViewById(R.id.editTextNama);
        editText2 = (EditText) root.findViewById(R.id.editTextBank);
        editText3 = (EditText) root.findViewById(R.id.editTextNorek);
        editText4 = (EditText) root.findViewById(R.id.editTextNohp);

        buttonRegister = (Button) root.findViewById(R.id.buttonRegister);
        //Adding listener to button
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertUser();
                editText.getText().clear();
                editText2.getText().clear();
                editText3.getText().clear();
                editText4.getText().clear();
            }
        });

        return root;
    }
    private void insertUser(){
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        DaftarAPI api = adapter.create(DaftarAPI.class);

        //Defining the method insertuser of our interface
        api.insertRegis(

                //Passing the values by getting it from editTexts
                editTextNama.getText().toString(),
                editTextBank.getText().toString(),
                editTextNohp.getText().toString(),
                editTextNorek.getText().toString(),


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