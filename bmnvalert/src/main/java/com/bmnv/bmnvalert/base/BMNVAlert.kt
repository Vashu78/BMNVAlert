package com.bmnv.bmnvalert.base

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import com.bmnv.bmnvalert.pages.BMNVAlert
import com.bmnv.bmnvalert.utils.AlertType
import com.bmnv.bmnvalert.utils.BMNVAlertType

object BMNVAlert {
    /**
     * @param alertType Type of alert to show.
     *
     * @param title Title of the alert.
     *
     * @param message Message of the alert.
     *
     * @param autoDismissInMillis Time in milliseconds to dismiss the alert automatically.
     * If you want alert do not auto dismiss then pass null.
     *
     * @param drawableRes Drawable resource to show with the alert.
     *
     * @param onDismiss Callback to be invoked when the alert is dismissed.
     */
    @Composable
    fun CreateAlert(
        alertType: AlertType,
        title: String,
        message: String,
        autoDismissInMillis: Long? = null,
        @DrawableRes drawableRes: Int? = null,
        onDismiss: () -> Unit
    ) {
        BMNVAlert(
            bmnvAlertType = BMNVAlertType.SIMPLE_ALERT,
            alertType = alertType,
            title = title,
            message = message,
            autoDismissInMillis = autoDismissInMillis,
            drawableRes = drawableRes,
            onDismiss = onDismiss
        )
    }

    /**
     * @param alertType Type of alert to show.
     *
     * @param title Title of the alert.
     *
     * @param message Message of the alert.
     *
     * @param positiveButtonText Text of the positive button.
     *
     * @param negativeButtonText Text of the negative button.
     *
     * @param drawableRes Drawable resource to show with the alert.
     *
     * @param onDismiss Callback to be invoked when the alert is dismissed.
     *
     * @param onConfirm Callback to be invoked when the positive button is clicked.
     */
    @Composable
    fun CreateConfirmationAlert(
        alertType: AlertType,
        title: String,
        message: String,
        positiveButtonText: String = "Ok",
        negativeButtonText: String = "Cancel",
        @DrawableRes drawableRes: Int? = null,
        onDismiss: () -> Unit,
        onConfirm: () -> Unit,
    ) {
        BMNVAlert(
            bmnvAlertType = BMNVAlertType.CONFIRMATION_ALERT,
            alertType = alertType,
            title = title,
            message = message,
            positiveButtonText = positiveButtonText,
            negativeButtonText = negativeButtonText,
            drawableRes = drawableRes,
            onDismiss = onDismiss,
            onConfirm = onConfirm
        )
    }

}