package dojo.githubuser.utils;

import android.content.Context;

import jgabrielfreitas.sdialog.dialog.SimpleDialog;
import jgabrielfreitas.sdialog.interfaces.DialogCallback;

/**
 * Created by JGabrielFreitas on 06/03/16.
 */
public class Feedback {

    public static void attentionFeedback(Context context, String message) {
        new SimpleDialog(context).setPositiveButtonText("Fechar").setTitle("Atenção")
                .setMessage(message).setDialogCallback(new DialogCallback() {
            public void onPositiveButton() {

            }

            public void onNegativeButton() {

            }

            public void onNeutralButton() {

            }
        }).create();
    }
}
