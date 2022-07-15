package com.example.company.myapplication

import android.app.Activity
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.example.company.lib.Checker
import org.junit.Rule


class Test : Checker() {

    @Rule
    @JvmField
    var mActivityRule = ActivityTestRule(MainActivity::class.java)
    @get:Rule var permissionWRule = GrantPermissionRule.grant(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
    @get:Rule var permissionRRule = GrantPermissionRule.grant(android.Manifest.permission.READ_EXTERNAL_STORAGE)


    override fun getActivity(): Activity?{
        return mActivityRule.activity
    }
}