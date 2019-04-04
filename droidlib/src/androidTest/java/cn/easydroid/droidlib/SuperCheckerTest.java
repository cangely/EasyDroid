package cn.easydroid.droidlib;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.LinkedList;

import cn.easydroid.util.SuperChecker;

/**
 * Create Date: 3/1/2019
 * Author: Yang Du
 * Description:
 */
@RunWith(AndroidJUnit4.class)
public class SuperCheckerTest {
    @Test
    public void checkEmpty() {
        Assert.assertTrue(SuperChecker.checkEmptyColloction(new LinkedList()));
        Assert.assertTrue(SuperChecker.checkEmptyString(""));
    }

}
