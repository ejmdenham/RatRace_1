package Rat.Racer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.core.Amplify;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import Rat.Racer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //TODO: add location implementation from here: https://velmurugan-murugesan.medium.com/how-to-get-current-latitude-and-longitude-in-android-example-35437a51052a
    //Send location to backend and TODO: learn how to show markers for other users
    //TODO: Consider the following resources
    //https://www.javatpoint.com/android-google-map-displaying-current-location
    //https://developers.google.com/maps/documentation/android-sdk/map-with-marker
    //http://www.androidhive.info/2013/08/android-working-with-google-maps-v2/
    //https://developer.tomtom.com/?utm_medium=referral&utm_source=quora&utm_campaign=ent_apis_quora_organic
    //https://rapidapi.com/blog/top-map-apis/
    //https://www.mapbox.com/
    //https://rapidapi.com/blog/top-map-apis/
    //https://developer.tomtom.com/

    //for help wth lists (friends, quest, squad chats) https://www.geeksforgeeks.org/how-to-build-a-todo-android-application-with-aws-dynamodb-as-database/

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        AuthUser currentUser = Amplify.Auth.getCurrentUser();

         Intent intent;

        if (currentUser == null){
            //Got to the login screen
            intent = new Intent(getApplicationContext(), SplashScreen.class);
            startActivity(intent);
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                Toast.makeText(getApplicationContext(),"Logging Out", Toast.LENGTH_LONG).show();

                Amplify.Auth.signOut(
                        () -> Log.i("AuthQuickstart", "Signed out successfully"),
                        error -> Log.e("AuthQuickstart", error.toString())
                );

                Intent intent = new Intent(getApplicationContext(),LoginScreen.class);
                startActivity(intent);
                finish();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        //here we reference our main fragment res/layout/content_main.xml with .id
        //which has a navGraph to a nav schema res/navigaton/mobile_nav...
        //which in turn supplies fragment info with refs to .../layout/[frag.xml]
        //and somehow navigates to frags w/ below code
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}