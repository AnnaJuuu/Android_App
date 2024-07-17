package com.example.applemarket

import android.content.Context
import android.view.LayoutInflater
import android.view.animation.LayoutAnimationController
import com.example.applemarket.databinding.ItemRecyclerviewBinding


class ProductManager {
    val products: MutableList<MyItem> = mutableListOf()  //지역 변수

    init {
        with(products)
        {
            add(
                MyItem(
                    R.drawable.sample1,
                    "산진 한달된 선풍기 팝니다",
                    "서울 서대문구 창천동",
                    1000,
                    13,R.drawable.chat,
                    25, R.drawable.heart
                )
            )
            add(
                MyItem(
                    R.drawable.sample2,
                    "김치냉장고",
                    "인천 계양구 귤현동",
                    20000,
                    28,R.drawable.chat,
                    8,R.drawable.heart
                )
            )
            add(
                MyItem(
                    R.drawable.sample3,
                    "샤넬 카드지갑",
                    "수성구 범어동",
                    10000,
                    5,R.drawable.chat,
                    23, R.drawable.heart
                )
            )
            add(
                MyItem(
                    R.drawable.sample4,
                    "금고",
                    "해운대구 우제2동",
                    10000,
                    17,R.drawable.chat,
                    14, R.drawable.heart
                )
            )
            add(
                MyItem(
                    R.drawable.sample5,
                    "갤럭시Z플립3 팝니다",
                    "연제구 연산제8동",
                    150000,
                    9,R.drawable.chat,
                    22,R.drawable.heart
                )
            )
            add(
                MyItem(
                    R.drawable.sample6,
                    "프라다 복조리백",
                    "수원시 영통구 원천동",
                    50000,
                    16,R.drawable.chat,
                    25,R.drawable.heart
                )
            )
            add(
                MyItem(
                    R.drawable.sample7,
                    "울산 동해오션뷰 60평 복층 펜트하우스 1일 숙박권 펜션 힐링 숙소 별장",
                    "남구 옥동",
                    150000,
                    54,R.drawable.chat,
                    142, R.drawable.heart
                )
            )
            add(
                MyItem(
                    R.drawable.sample8,
                    "샤넬 탑핸들 가방",
                    "동래구 온천제2동",
                    180000,
                    7, R.drawable.chat,
                    31, R.drawable.heart
                )
            )
            add(
                MyItem(
                    R.drawable.sample9,
                    "4행정 엔진분무기 판매합니다.",
                    "원주시 명륜2동",
                    30000,
                    7,R.drawable.chat,
                    28, R.drawable.heart
                )
            )
            add(
                MyItem(
                    R.drawable.sample10,
                    "셀린느 버킷 가방",
                    "중구 동화동",
                    190000,
                    6, R.drawable.chat,
                    40, R.drawable.heart,
                )
            )
        }
    }
}