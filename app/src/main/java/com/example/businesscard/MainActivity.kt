package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background // background default
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderSection()
        Spacer(modifier = Modifier.height(40.dp))
        ContactSection()
    }
}


@Composable
fun HeaderSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Tambahkan logo dari drawable
        Image(
            painter = painterResource(id = R.drawable.android_logo), // ganti sesuai file logo
            contentDescription = "Logo Android",
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = "Yesica Frestysia",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3DDC84) // hijau Android
        )
        Text(
            text = "Android Developer",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun ContactSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactRow(icon = { Icon(Icons.Default.Phone, contentDescription = "Phone") }, text = "+62 xxx xxxx xxxx")
        ContactRow(icon = { Icon(Icons.Default.Share, contentDescription = "Social") }, text = "@yesicaa")
        ContactRow(icon = { Icon(Icons.Default.Email, contentDescription = "Email") }, text = "yesica@gmail.com")
    }
}

@Composable
fun ContactRow(icon: @Composable () -> Unit, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(4.dp)
    ) {
        icon()
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, fontSize = 14.sp, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}
