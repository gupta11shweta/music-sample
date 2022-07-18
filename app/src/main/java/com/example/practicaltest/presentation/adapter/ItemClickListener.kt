package com.example.practicaltest.presentation.adapter

import com.example.practicaltest.domain.model.SongData

interface ItemClickListener {
    fun onItemClick(songData: SongData)
}