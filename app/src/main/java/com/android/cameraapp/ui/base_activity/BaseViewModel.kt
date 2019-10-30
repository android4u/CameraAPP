package com.android.cameraapp.ui.base_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.cameraapp.di.base_activity.BaseActivityScope
import com.android.cameraapp.util.UserAuthStates
import kotlinx.coroutines.launch
import javax.inject.Inject

@BaseActivityScope
class BaseViewModel @Inject constructor(val repository: BaseRepository) : ViewModel() {

    lateinit var states: LiveData<UserAuthStates>

    fun logIn(email: String?, password: String?, rememberUser: Boolean) =
        repository.logIn(email, password, rememberUser)

    fun getUserNetworkStates(): LiveData<UserAuthStates> {
        states = repository.user_state
        return states
    }

    fun <T> loginWithThirdPartyAccount(account: T, loginIdentifier: Int) =
        repository.logInWithCredentials(account, loginIdentifier)

    override fun onCleared() {
        repository.forgetOneSessionUser()
        repository.removeListener()
    }

    fun registerUser(
        username: String?,
        password: String?,
        reapeat_password: String?,
        email: String?,
        areTermsAccepted: Boolean
    ) = repository.registerUser(username, password, reapeat_password, email, areTermsAccepted)

    fun sendPasswordResetToEmail(email: String?) = repository.sendPasswordResetToEmail(email)


}