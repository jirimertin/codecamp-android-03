package ackee.cz.codecamp03;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, createHomeWorkFragment())
                    .commit();
        }
    }

    private Fragment createSchoolProjectFragment() {
        return new SchoolProjectFragment();
    }

    private Fragment createHomeWorkFragment() {
        return new HomeworkFragment();
    }
}
