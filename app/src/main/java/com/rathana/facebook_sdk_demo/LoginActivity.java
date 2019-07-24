package com.rathana.facebook_sdk_demo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    LoginButton btnLogin;
    CallbackManager callbackManager;
    private static final String[] permissions={"public_profile","email"};
    private static final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin=findViewById(R.id.login_button);
        callbackManager=CallbackManager.Factory.create();
        btnLogin.setReadPermissions(Arrays.asList(permissions));

        btnLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                setResult(RESULT_OK);
                Log.e(TAG, "onSuccess: user Id"+ loginResult.getAccessToken().getUserId());
                Log.e(TAG, "onSuccess: token"+loginResult.getAccessToken().getToken());

                getFacebookProfile(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                setResult(RESULT_CANCELED);
                Log.e(TAG, "onCancel: " );
            }

            @Override
            public void onError(FacebookException error) {
                Log.e(TAG, "onError: "+error.toString() );
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void getFacebookProfile(AccessToken accessToken){
        final GraphRequest request=GraphRequest.newMeRequest(
                accessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {

                        Gson gson= new GsonBuilder().create();
                        FacebookUser user=gson.fromJson(object.toString(),FacebookUser.class);
                        String profile="";
                        try {
                            JSONObject obj=response.getJSONObject().getJSONObject("picture").getJSONObject("data");
                            profile=obj.getString("url");
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        if(user!=null){
                            user.setProfile(profile);
                        }

                        Log.e(TAG, "onCompleted: User Profile"+user.toString() );
                    }
                }
        );

        Bundle parameters=new Bundle();
        parameters.putString("fields","id,name,first_name,last_name,email,picture.type(large),gender,link,birthday");
        request.setParameters(parameters);
        request.executeAsync();

    }
}
