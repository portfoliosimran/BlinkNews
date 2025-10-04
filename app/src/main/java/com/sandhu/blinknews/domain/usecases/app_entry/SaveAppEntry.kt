package com.sandhu.blinknews.domain.usecases.app_entry

import com.sandhu.blinknews.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}