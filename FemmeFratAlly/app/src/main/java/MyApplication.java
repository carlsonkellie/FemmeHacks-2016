import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by kelliecarlson on 2/20/16.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
