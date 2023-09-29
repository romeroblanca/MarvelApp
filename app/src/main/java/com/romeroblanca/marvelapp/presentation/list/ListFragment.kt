package com.romeroblanca.marvelapp.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.romeroblanca.marvelapp.databinding.FragmentListBinding
import com.romeroblanca.marvelapp.domain.model.CharactersListModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private val listViewModel: ListViewModel by viewModel()

    private var _binding: FragmentListBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listViewModel.charactersList.observe(viewLifecycleOwner) { charactersList ->
            initList(charactersList)
        }

        listViewModel.errorMessage.observe(viewLifecycleOwner) { errorMessage ->
            if (errorMessage == null) {
                hideErrorMessage()
            } else {
                showErrorMessage(errorMessage)
            }
        }

        listViewModel.getData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initList(data: CharactersListModel) = binding.characterList.run {
        adapter = ListAdapter(data)
    }

    private fun showErrorMessage(errorMessage: String) = binding.tvErrorMessage.apply {
        visibility = View.VISIBLE
        text = errorMessage
    }

    private fun hideErrorMessage() = binding.tvErrorMessage.apply {
        visibility = View.GONE
    }
}