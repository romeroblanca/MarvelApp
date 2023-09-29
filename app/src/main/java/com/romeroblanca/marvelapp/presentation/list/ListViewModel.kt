package com.romeroblanca.marvelapp.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.romeroblanca.marvelapp.domain.model.CharactersListModel
import com.romeroblanca.marvelapp.domain.usecase.GetCharactersListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.romeroblanca.marvelapp.domain.functional.Result.Error
import com.romeroblanca.marvelapp.domain.functional.Result.Success

class ListViewModel(
    private val getCharactersListUseCase: GetCharactersListUseCase
) : ViewModel() {

    private val _charactersList = MutableLiveData<CharactersListModel>()
    val charactersList: LiveData<CharactersListModel> get() = _charactersList

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    fun getData() {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    getCharactersListUseCase.invoke()
                }
                when (result) {
                    is Success -> _charactersList.value = result.value!!
                    is Error -> _errorMessage.value = "Se ha producido un error: '" + result.value.toString() + "'"
                }

            } catch (t: Throwable) {
                _errorMessage.value = "Se ha producido un error"
            }
        }
    }
}