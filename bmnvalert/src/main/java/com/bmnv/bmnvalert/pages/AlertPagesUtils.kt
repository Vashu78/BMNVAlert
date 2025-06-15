package com.bmnv.bmnvalert.pages

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bmnv.bmnvalert.R
import com.bmnv.bmnvalert.utils.AlertType
import com.bmnv.bmnvalert.utils.BMNVAlertType
import kotlinx.coroutines.delay

@Composable
internal fun BMNVAlert(
    bmnvAlertType: BMNVAlertType,
    alertType: AlertType,
    title: String,
    message: String,
    autoDismissInMillis: Long? = null,
    positiveButtonText: String = "Ok",
    negativeButtonText: String = "Cancel",
    @DrawableRes drawableRes: Int? = null,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit = {},
) {
    val openDialog = remember { mutableStateOf(true) }

    if (autoDismissInMillis != null && openDialog.value) {
        LaunchedEffect(Unit) {
            delay(autoDismissInMillis)
            openDialog.value = false
            onDismiss()
        }
    }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
                onDismiss()
            },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    (drawableRes ?: kotlin.run {
                        when(alertType){
                            AlertType.ERROR -> R.drawable.ic_error
                            AlertType.WARNING -> R.drawable.ic_error
                            AlertType.SUCCESS -> R.drawable.ic_success
                            else -> R.drawable.ic_info

                        }
                    }).let {
                        Icon(
                            painter = painterResource(id = it),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = when (alertType) {
                                AlertType.ERROR -> Color.Red
                                AlertType.WARNING -> Color(0xFFFFA000)
                                AlertType.SUCCESS -> Color(0xFF2E7D32)
                                else -> MaterialTheme.colorScheme.primary
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }
            },
            text = {
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium.copy(lineHeight = 20.sp)
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    openDialog.value = false
                    onConfirm.invoke()
                }) {
                    Text(
                        positiveButtonText,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            },
            dismissButton = {
                if (bmnvAlertType == BMNVAlertType.CONFIRMATION_ALERT) {
                    TextButton(onClick = {
                        openDialog.value = false
                        onDismiss()
                    }) {
                        Text(
                            negativeButtonText,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
            },
            shape = RoundedCornerShape(20.dp),
            containerColor = MaterialTheme.colorScheme.surface,
        )
    }
}