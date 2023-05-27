package com.sandroln.dayswithoutbadhabits

import com.sandroln.dayswithoutbadhabits.core.Communication

interface MainCommunication {

    interface Put : Communication.Put<UiState>

    interface Observe : Communication.Observe<UiState>

    interface Mutable : Put, Observe

    class Base : Communication.Abstract<UiState>(), Mutable
}