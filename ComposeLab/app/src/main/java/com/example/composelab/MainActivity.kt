package com.example.composelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContent { 이미지 카드용
//            var isFavorite by rememberSaveable {
//                mutableStateOf(false)
//            }
//            /** 구성변경에 안깨짐 */
//
//            ComposeLabTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
//                    ImageCardTest(
//                        Modifier
//                            .fillMaxWidth(0.4f)
//                            .aspectRatio(3f / 4f)
//                            .padding(40.dp), isFavorite
//                    ) { processedValue ->
//                        isFavorite = processedValue
//                    }
//                }
//            }
//        }

        setContent {

        }
    }
}

@Composable
fun Test() {
    Column(
        modifier = Modifier
            .background(color = Color.Blue)
            .padding(15.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column {
            Text("레슬링장이나 가고싶다")
            Text("흐흗흐흐흐흗")
        }
        Row {
            Text("주짓수도")
            Spacer(Modifier.width(16.dp))
            Text("흐흑흐흐흐흐흫ㄷㄱ")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestPreview() {
    Test()
}

@Composable
fun BoxTest() {
    Box(
        modifier = Modifier
            .background(color = Color.Green)
            .fillMaxWidth()
            .height(200.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Text("히히")
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Text("gkgkdhdhdhdh")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxTestPreview() {
    BoxTest()
}

@Composable
fun LazyColumnTest() {
    val scrollState = rememberScrollState()

//    Column(modifier = Modifier
//        .fillMaxWidth()
//        .background(color = Color.Blue)
//        .verticalScroll(scrollState)) {
//        for (i in 1..60) {
//            Text("숫자 숫자 $i")
//        }
//    }

    LazyColumn(
        modifier = Modifier
            .background(color = Color.Green)
            .fillMaxWidth(),
        contentPadding = PaddingValues(start = 20.dp, top = 40.dp),
        /**전체 패딩*/
        verticalArrangement = Arrangement.spacedBy(20.dp)
        /**아이템 간 간격*/
    ) {
        item {
            Text("헤더")
        }
        items(50) { index ->
            Text("글씨 $index")
        }
        item {
            Text("푸터")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyColumnTestPreview() {
    LazyColumnTest()
}

@Composable
fun ImageCardTest(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    onFavoriteClicked: (Boolean) -> Unit
) {
//    var isFavorite by remember {
//        mutableStateOf(false)
//    } /** 구성변경에 깨짐 */

//    var isFavorite by rememberSaveable {
//        mutableStateOf(false)
//    } /** 구성변경에 안깨짐 */

    Card(
//        modifier = Modifier.wrapContentSize()
//        modifier = Modifier
//            .height(200.dp)
//            .width(200.dp),
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
    ) {
        Box {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.tete),
                contentDescription = "이런",
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopEnd,
            ) {
                IconButton(onClick = {
                    onFavoriteClicked(!isFavorite)
                }) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.FavoriteBorder else Icons.Default.Favorite,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    }
}


