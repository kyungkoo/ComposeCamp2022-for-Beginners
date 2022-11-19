package io.github.kyungkoo.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kyungkoo.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp(
                        BusinessCard(
                            fullName = "Jenifer Doe",
                            title = "Android Developer Extraordinaire",
                            phone = "+11 (123) 444 555 666",
                            sns = "@AndroidDev",
                            email = "jen.doe@android.com"
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(businessCard: BusinessCard) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF143948))
    ) {
        BusinessCenter(
            fullName = businessCard.fullName,
            title = businessCard.title,
            modifier = Modifier.weight(2.0f))
        BusinessBottom(
            phone = businessCard.phone,
            sns = businessCard.sns,
            email = businessCard.email,
            modifier = Modifier.weight(1.0f))
    }
}

@Composable
fun BusinessCenter(
    fullName: String,
    title: String,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null
        )
        Text(
            text = fullName,
            textAlign = TextAlign.Center,
            fontSize = 36.sp,
            fontWeight = FontWeight.Light,
            color = Color.White
        )

        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.teal_200)
        )
    }
}

@Composable
fun BusinessBottom(
    phone: String,
    sns: String,
    email: String,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Divider()
        BottomInformationRow(
            iconId = R.drawable.ic_baseline_call_24,
            text = phone
        )
        Divider()
        BottomInformationRow(
            iconId = R.drawable.ic_baseline_share_24,
            text = sns
        )
        Divider()
        BottomInformationRow(
            iconId = R.drawable.ic_baseline_email_24,
            text = email
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun Divider() {
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
        .background(Color.White))
}

@Composable
fun BottomInformationRow(
    iconId: Int,
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp)
    ) {
        Spacer(modifier = Modifier.width(36.dp))
        Icon(
            painter = painterResource(id = iconId),
            tint = colorResource(id = R.color.teal_200),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCardApp(BusinessCard(
            fullName = "Jenifer Doe",
            title = "Android Developer Extraordinaire",
            phone = "+11 (123) 444 555 666",
            sns = "@AndroidDev",
            email = "jen.doe@android.com"
        ))
    }
}