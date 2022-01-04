package com.kotlinaai.anl.composes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.kotlinaai.anl.R
import com.kotlinaai.anl.pojo.AvatarName
import com.kotlinaai.anl.ui.theme.AvatarNameListTheme
import com.kotlinaai.anl.viewmodel.AvatarNameListViewModel

object ItemType {
    const val ITEM_TYPE_DELETE = -1
    const val ITEM_TYPE_ADD = 1
    const val ITEM_TYPE_AVATAR = 0
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AvatarNameListPage(
    viewModel: AvatarNameListViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onItemClicked: (Int, AvatarName?) -> Unit) {
    val data = viewModel.data

    LazyVerticalGrid(
        modifier = Modifier.wrapContentHeight(),
        cells = GridCells.Fixed(5),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(data) { avatarName ->
            AvatarNameItem (avatarName) {
                onItemClicked(ItemType.ITEM_TYPE_AVATAR, it)
            }
        }
        item {
            Box {
                Image(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clip(CircleShape)
                        .size(46.dp)
                        .clickable {
                            onItemClicked(ItemType.ITEM_TYPE_ADD, null)
                        },
                    painter = painterResource(id = R.drawable.group_button_add2),
                    contentDescription = "add")
            }
        }
        item {
            Box {
                Image(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clip(CircleShape)
                        .size(46.dp)
                        .clickable {
                            onItemClicked(ItemType.ITEM_TYPE_ADD, null)
                        },
                    painter = painterResource(id = R.drawable.group_button_delete2),
                    contentDescription = "delete")
            }
        }
    }
}

@Composable
fun AvatarNameItem(item: AvatarName, onClicked: (AvatarName) -> Unit) {
    Column(
        modifier = Modifier
            .width(IntrinsicSize.Min),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(46.dp)
                .clip(CircleShape)
                .clickable {
                    onClicked(item)
                },
            contentScale = ContentScale.Crop,
            painter = rememberImagePainter(
                data = item.getAvatar()
            ),
            contentDescription = "avatar")
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = item.getName(),
            fontSize = 12.sp,
            maxLines = 1,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ANLPreview() {
    AvatarNameListTheme {
        Surface {
            /*AvatarNameItem(item = object : AvatarName{
                override fun getAvatar(): String = "https://c.wallhere.com/images/a7/49/325390659cf55c01dcbaf83bf225-1467771.png!d"

                override fun getName(): String = "Jaqen Chen"
            })*/
            val data = listOf(
                object : AvatarName {
                    override fun getAvatar(): String = "https://c.wallhere.com/images/a7/49/325390659cf55c01dcbaf83bf225-1467771.png!d"
                    override fun getName(): String = "Jaqen Chen" },
                object : AvatarName {
                    override fun getAvatar(): String = "https://c.wallhere.com/images/a7/49/325390659cf55c01dcbaf83bf225-1467771.png!d"
                    override fun getName(): String = "Jaqen Chen" },
                object : AvatarName {
                    override fun getAvatar(): String = "https://c.wallhere.com/images/a7/49/325390659cf55c01dcbaf83bf225-1467771.png!d"
                    override fun getName(): String = "Jaqen Chen" },
                object : AvatarName {
                    override fun getAvatar(): String = "https://c.wallhere.com/images/a7/49/325390659cf55c01dcbaf83bf225-1467771.png!d"
                    override fun getName(): String = "Jaqen Chen" },
                object : AvatarName {
                    override fun getAvatar(): String = "https://c.wallhere.com/images/a7/49/325390659cf55c01dcbaf83bf225-1467771.png!d"
                    override fun getName(): String = "Jaqen Chen" },
                object : AvatarName {
                    override fun getAvatar(): String = "https://c.wallhere.com/images/a7/49/325390659cf55c01dcbaf83bf225-1467771.png!d"
                    override fun getName(): String = "Jaqen Chen" },
            )

        }
    }
}