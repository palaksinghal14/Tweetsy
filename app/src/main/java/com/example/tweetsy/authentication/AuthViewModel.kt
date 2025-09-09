package com.example.tweetsy.authentication

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class AuthViewModel @Inject constructor(
    val repo:AuthRepository
): ViewModel()
{
    private val _state = mutableStateOf<AuthState>(AuthState.Idle)
    val state: State<AuthState> = _state

    fun login(email: String, password: String) {
        _state.value = AuthState.Loading
        repo.login(email, password) { success, error ->
            _state.value = if (success) AuthState.Success else AuthState.Error(error ?: "Unknown error")
        }
    }

    fun register(email: String, password: String) {
        _state.value = AuthState.Loading
        repo.register(email, password) { success, error ->
            _state.value = if (success) AuthState.Success else AuthState.Error(error ?: "Unknown error")
        }
    }

    fun logout() = repo.logout()
    fun isLoggedIn() = repo.isLoggedIn()
}


    sealed class AuthState {
        object Idle : AuthState()
        object Loading : AuthState()
        object Success : AuthState()
        data class Error(val message: String) : AuthState()
    }
