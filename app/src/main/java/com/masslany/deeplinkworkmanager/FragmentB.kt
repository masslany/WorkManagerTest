package com.masslany.deeplinkworkmanager

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.work.WorkManager

class FragmentB : Fragment(R.layout.fragment_b_layout) {

    val args: FragmentBArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val outputTextView = view.findViewById<TextView>(R.id.tv_output)
        outputTextView.text = args.id

        val workManager = WorkManager.getInstance(requireContext())

        val showNotificationUseCase = ShowNotificationUseCase(
            workManager
        )
        val launchEntity = LaunchEntity(args.id, "ORBCON-12")

        showNotificationUseCase.execute(launchEntity)
    }
}