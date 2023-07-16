package com.xonoe.deseos

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.xonoe.deseos.ui.theme.DeseosTheme

@Preview(showBackground = true)
@Composable
fun PermissionPreview() {
    DeseosTheme {
        PermissionsScreen()
    }
}

