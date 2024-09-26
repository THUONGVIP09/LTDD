package com.example.traicay.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.traicay.R
data class Traicay(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val day: Int,
    @StringRes val gia: Int
)
val traicays= listOf(
    Traicay(R.drawable.img_4009_copy_0087a0f264f8465e9ef33af09b202b75_medium,R.string.name_1,1,R.string.description_1),
    Traicay(R.drawable.mang_cut_640fe24e8a844043b04be67ff9033b10_medium,R.string.name_2,2,R.string.description_2),
    Traicay(R.drawable.xoai_cat_2f2a5d8570314f6caec833a06eb4e74e_medium,R.string.name_3,3,R.string.description_3),
    Traicay(R.drawable.dsc_1729_copy_420f78f4081b427abf83963762a2d8b2_medium,R.string.name_4,4,R.string.description_4),
    Traicay(R.drawable.nhan_xuong_bap_cai_f693efcffa614b77bbbc03f96cc99416_medium,R.string.name_5,5,R.string.description_5),
    Traicay(R.drawable.anh_bia_bestseller_web__6__e088bc4e1d0644ad890eaefd0389b906_medium,R.string.name_6,6,R.string.description_6),
    Traicay(R.drawable.dsc_8632_copy_5e78b91621de455cac38eb1af8a9c94e_medium,R.string.name_7,7,R.string.description_7),
    Traicay(R.drawable.sapoche_8c3c832abd9f412c89c118f34249c7ef_medium,R.string.name_8,8,R.string.description_8),
    Traicay(R.drawable.hong_trung_91ea8d7c4caa472386c16243fa4c7127_medium,R.string.name_9,9,R.string.description_9),
    Traicay(R.drawable.man_hong_dao_3971ef18165c40429691baf5e53b070a_medium,R.string.name_10,10,R.string.description_10),


)