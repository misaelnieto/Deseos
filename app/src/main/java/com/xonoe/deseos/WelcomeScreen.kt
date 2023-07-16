package com.xonoe.deseos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.xonoe.deseos.ui.theme.DeseosTheme

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.sunflower),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            alpha = 0.5F
        )
        Column {
            Text(
                text = stringResource(R.string.names),
                fontSize = 72.sp,
                textAlign = TextAlign.Center,
                lineHeight = 72.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Text(
                text = stringResource(R.string.event_date),
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                lineHeight = 36.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            IconButton(
                onClick = { navController.navigate("record") },
                modifier = Modifier
                    .fillMaxSize()
                    .height(100.dp)
                    .width(100.dp),
            ) {
                Icon(
                    Icons.Filled.Call,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    tint = Color(0xFFFFD700)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    DeseosTheme {
        WelcomeScreen(navController)
    }
}