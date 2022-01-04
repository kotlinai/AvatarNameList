package com.kotlinaai.avatarnamelist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kotlinaai.anl.AvatarNameListFragment
import com.kotlinaai.anl.pojo.AvatarName
import com.kotlinaai.avatarnamelist.ui.theme.AvatarNameListTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        (supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as AvatarNameListFragment)
            .apply {
                setData(listOf(
                object : AvatarName {
                    override fun getAvatar(): String = "https://c.wallhere.com/images/a7/49/325390659cf55c01dcbaf83bf225-1467771.png!d"
                    override fun getName(): String = "Jaqen Chen" },
                object : AvatarName {
                    override fun getAvatar(): String = "https://c.wallhere.com/images/dc/ed/ab5345cbd98e278b8cdbfab75919-1563319.jpg!d"
                    override fun getName(): String = "Jaqen Chen" },
                object : AvatarName {
                    override fun getAvatar(): String = "https://c.wallhere.com/images/f4/c3/c094e657c278143df3b684145754-1566013.jpg!d"
                    override fun getName(): String = "Jaqen Chen" },
                object : AvatarName {
                    override fun getAvatar(): String = "https://c.wallhere.com/images/73/49/2d625b04125f442cbcd34bd65f77-1425823.jpg!d"
                    override fun getName(): String = "Jaqen Chen" },
                object : AvatarName {
                    override fun getAvatar(): String = "https://c.wallhere.com/images/a7/49/325390659cf55c01dcbaf83bf225-1467771.png!d"
                    override fun getName(): String = "安得浮生碎梦月" },
                object : AvatarName {
                    override fun getAvatar(): String = "https://c.wallhere.com/images/a7/49/325390659cf55c01dcbaf83bf225-1467771.png!d"
                    override fun getName(): String = "眉目依旧盛蓝星" },
                ))
                setOnItemClickedListener { _,_ ->
                    Toast.makeText(this@MainActivity, "点击了", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
