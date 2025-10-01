package com.sandhu.blinknews.presentation.onboarding.components


import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.sandhu.blinknews.presentation.Dimens.MediumPadding1
import com.sandhu.blinknews.presentation.Dimens.MediumPadding2
import com.sandhu.blinknews.presentation.onboarding.Page
import com.sandhu.blinknews.presentation.onboarding.pages
import com.sandhu.blinknews.ui.theme.BlinkNewsTheme


@Composable
fun OnBoardingPage(
    page: Page,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier) {
        Image(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop)

        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

    }

}

@Preview(uiMode = UI_MODE_NIGHT_NO,showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES,showBackground = true)
@Composable
private fun OnBoardingPagePreview() {
    BlinkNewsTheme {
        OnBoardingPage(page = pages[0])
    }
}