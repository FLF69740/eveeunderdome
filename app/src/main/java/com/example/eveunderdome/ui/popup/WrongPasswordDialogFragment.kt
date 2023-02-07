package com.example.eveunderdome.ui.popup

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class WrongPasswordDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage("MAUVAIS MOT DE PASSE")
            .setPositiveButton("OK"){_,_ ->}
            .create()
}