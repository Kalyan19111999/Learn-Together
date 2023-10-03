package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnTogether(image = R.drawable.bg_compose_background, title = R.string.title, p1 = R.string.p1, p2 = R.string.p2)
                }
            }
        }
    }
}

@Composable
fun LearnTogether(image: Int, title: Int, p1: Int, p2: Int, modifier: Modifier = Modifier) {
    Column {
        LearnTogetherImage(image = image, modifier = modifier.fillMaxWidth())
        LearnTogetherText(title = title, p1 = p1, p2 = p2, modifier = modifier.padding(16.dp), textAlignment = TextAlign.Justify)
    }
}

@Composable
fun LearnTogetherImage(image: Int, modifier: Modifier) {
    Image(painter = painterResource(image), contentDescription = null, modifier = modifier)
}

@Composable
fun LearnTogetherText(title: Int, p1: Int, p2: Int, modifier: Modifier, textAlignment: TextAlign) {
    Text(text = stringResource(title), fontSize = 24.sp, modifier = modifier, textAlign = textAlignment)
    Text(text = stringResource(p1), modifier = modifier, textAlign = textAlignment)
    Text(text = stringResource(p2), modifier = modifier, textAlign = textAlignment)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        LearnTogether(image = R.drawable.bg_compose_background, title = R.string.title, p1 = R.string.p1, p2 = R.string.p2)
    }
}