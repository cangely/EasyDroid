package cn.easydroid.android.component;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

public class ActivityBus {

    private Intent intent;
    private Activity from;
    private int requestCode;
    private boolean withRequest = false;

    private ActivityBus() {
    }

    public static ActivityBus newInstance(Activity from, Class<? extends Activity> target){
        ActivityBus bus = new ActivityBus();
        bus.intent = new Intent(from,target);
        bus.from = from;
        return bus;
    }
    public void go(){
        if (withRequest) {
            from.startActivityForResult(intent,requestCode);
        } else {
            from.startActivity(intent);

        }

    }


    public ActivityBus with(String key, String value){
        intent.putExtra(key,value);
        return this;
    }
    public ActivityBus with(String key, int value){
        intent.putExtra(key,value);
        return this;
    }
    public ActivityBus with(String key, float value){
        intent.putExtra(key,value);
        return this;
    }
    public ActivityBus with(String key, double value){
        intent.putExtra(key,value);
        return this;
    }
    public ActivityBus with(String key, boolean value){
        intent.putExtra(key,value);
        return this;
    }
    public ActivityBus with(String key, byte value){
        intent.putExtra(key,value);
        return this;
    }
    public ActivityBus with(String key, char value){
        intent.putExtra(key,value);
        return this;
    }
    public ActivityBus with(String key, Bundle bundle){
        intent.putExtra(key,bundle);
        return this;
    }
    public ActivityBus withRequset(int requestCode){
        this.requestCode = requestCode;
        withRequest = true;
        return this;
    }

    public ActivityBus withFlag(int flag) {
        intent.addFlags(flag);
        return this;
    }

    public ActivityBus withAction(String action) {
        if (!TextUtils.isEmpty(action)){
            intent.setAction(action);
        }
        return this;
    }
}
