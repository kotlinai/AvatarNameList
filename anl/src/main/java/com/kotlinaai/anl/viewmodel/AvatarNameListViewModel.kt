package com.kotlinaai.anl.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.kotlinaai.anl.pojo.AvatarName

class AvatarNameListViewModel: ViewModel() {
    var data by mutableStateOf<List<AvatarName>>(emptyList())
}