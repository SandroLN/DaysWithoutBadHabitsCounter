package com.sandroln.dayswithoutbadhabits.presentation

import com.sandroln.dayswithoutbadhabits.core.Communication
import com.sandroln.dayswithoutbadhabits.core.SingleLiveEvent


interface MainCommunication {

    interface Put : Communication.Put<MainUiState>

    interface Observe : Communication.Observe<MainUiState>

    interface Mutable : Put, Observe

    class Base : Communication.Abstract<MainUiState>(SingleLiveEvent()), Mutable
}