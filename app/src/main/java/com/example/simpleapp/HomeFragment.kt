package com.example.simpleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.simpleapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _b: FragmentHomeBinding? = null
    private val b get() = _b!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _b = FragmentHomeBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        b.tvCongrats.text = "Поздравляем с активацией Yura"

        b.btnGenerateKey.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Сгенерировать ключ доступа")
                .setMessage("Вам необходимо купить подписку")
                .setPositiveButton("Ок", null)
                .show()
        }

        b.progress.setProgress(100, true)
        b.tvLoaded.text = "Ваши данные полностью загружены"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _b = null
    }
}