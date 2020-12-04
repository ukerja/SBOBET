package net.simplifiedlearning.volleymysqlexample;

import android.app.Application;

import com.livechatinc.inappchat.ChatWindowConfiguration;
import com.squareup.leakcanary.LeakCanary;

import static net.simplifiedlearning.volleymysqlexample.Navigasi.LIVECHAT_SUPPORT_LICENCE_NR;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    public static ChatWindowConfiguration getChatWindowConfiguration() {
        return new ChatWindowConfiguration(LIVECHAT_SUPPORT_LICENCE_NR, null, "SBOBET User", null, null);
    }
}
