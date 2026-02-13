package com.example.retrofitjc_di.apiviewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitjc_di.dataClasses.UsersItem
import com.example.retrofitjc_di.repo.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class UserUiState{
    object Loading : UserUiState()
    data class Success(val users : List<UsersItem>) : UserUiState()
    data class Error(val message: String) : UserUiState()
}

@HiltViewModel
class ApiViewModel @Inject constructor(
    private val apiRepository: ApiRepository ) : ViewModel()
{
        private val internalState : MutableState<UserUiState> = mutableStateOf(UserUiState.Loading)
        val state : State<UserUiState> = internalState
        init {
            fetchUsers()
        }
        private fun fetchUsers() {
            viewModelScope.launch {
                internalState.value = UserUiState.Loading
                try{
                    val users = apiRepository.getAllUsers()
                    internalState.value = UserUiState.Success(users)
                }catch (e :Exception){
                    internalState.value = UserUiState.Error(e.message.toString())
                }
            }
        }
}