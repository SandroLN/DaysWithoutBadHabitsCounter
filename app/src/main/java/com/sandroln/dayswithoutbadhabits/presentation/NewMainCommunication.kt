package com.sandroln.dayswithoutbadhabits.presentation

import com.sandroln.dayswithoutbadhabits.core.Communication
import com.sandroln.dayswithoutbadhabits.core.SingleLiveEvent


interface NewMainCommunication {

    interface Put : Communication.Put<NewUiState>

    interface Observe : Communication.Observe<NewUiState>

    interface Mutable : Put, Observe

    class Base() : Communication.Abstract<NewUiState>(SingleLiveEvent()), Mutable
}