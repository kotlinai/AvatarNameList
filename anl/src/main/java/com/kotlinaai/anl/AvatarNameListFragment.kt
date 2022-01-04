package com.kotlinaai.anl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.viewModels
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.kotlinaai.anl.composes.AvatarNameListPage
import com.kotlinaai.anl.pojo.AvatarName
import com.kotlinaai.anl.ui.theme.AvatarNameListTheme
import com.kotlinaai.anl.viewmodel.AvatarNameListViewModel


class AvatarNameListFragment : Fragment() {

    private val viewModel by viewModels<AvatarNameListViewModel>()
    private var listener: OnItemClickedListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_avatar_name_list, container, false)

        root.findViewById<ComposeView>(R.id.composeView).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                AvatarNameListTheme {
                    Surface {
                        AvatarNameListPage { type, avatar ->
                            listener?.onItemClicked(type, avatar)
                        }
                    }
                }
            }
        }

        return root
    }

    fun setData(data: List<AvatarName>) {
        viewModel.data = data
    }

    fun setOnItemClickedListener(listener: OnItemClickedListener) {
        this.listener = listener
    }

    fun interface OnItemClickedListener {
        fun onItemClicked(itemType: Int, item: AvatarName?)
    }
}

